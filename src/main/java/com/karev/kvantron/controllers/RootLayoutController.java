package com.karev.kvantron.controllers;

import ServoConRemote.*;
import ServoConRemote.LongProcessPackage.Status;
import com.karev.kvantron.Main;
import com.karev.kvantron.ServoCon;
import com.karev.kvantron.model.*;
import com.karev.kvantron.util.FileUtil;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.Any;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class RootLayoutController implements Initializable {
    private ServoCon servocon;
    private Cnc cncModel;
    private Glass glass;
    private static final Logger logger = LogManager.getLogger(RootLayoutController.class);
    private Main mainApp;
    private File workDir;
    private File imageDir;
    private ListPicturesWrapper picturesList = new ListPicturesWrapper();
    private File lastAddDir;
    private File savedFile;
    private Settings settingModel;
    private DialogPane settingsPane;
    private SettingsLayoutController settingsController;
    private DoubleProperty scaleValue = new SimpleDoubleProperty(1.0);

    @FXML
    private Label xPosition;
    @FXML
    private Label yPosition;
    @FXML
    private Label zPosition;
    @FXML
    private Button xPlus;
    @FXML
    private Button xMinus;
    @FXML
    private Button yPlus;
    @FXML
    private Button yMinus;
    @FXML
    private Button zPlus;
    @FXML
    private Button zMinus;
    @FXML
    private Slider jogVelocity;
    @FXML
    private Button cncOnOff;
    @FXML
    private Button toHome;
    @FXML
    private Button toZero;
    @FXML
    private Button laserOnOff;
    @FXML
    private Label cncConnect;
    @FXML
    private Label cncState;


    @FXML
    private TextField glassLength;
    @FXML
    private TextField glassWidth;
    @FXML
    private TextField glassThickness;
    @FXML
    private ListView<Picture> pictures;
    @FXML
    private TextField height;
    @FXML
    private TextField offsetX;
    @FXML
    private TextField offsetY;
    @FXML
    private ScrollPane preview;
    @FXML
    private Rectangle glassPreview;
    @FXML
    private ImageView picturePreview;
    @FXML
    private Label previewInfo;
    @FXML
    private ComboBox<String> plane;
    @FXML
    private ComboBox<String> scale;
    @FXML
    private Rectangle yzPreview;
    @FXML
    Line toStartLine;
    @FXML
    Line toZeroLine;
    @FXML
    Rectangle progressArea;


    @FXML
    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeLogger();
        loadSettings();
        initializeManualTab();
        handleNew();
        initializeProgramTab();

    }

    private void loadSettings() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/settingsLayout.fxml"));
        try {
            settingsPane = loader.load();
            settingsController = loader.getController();
            settingModel = settingsController.getSettings();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeLogger() {
        System.setProperty("log4j.configurationFile", getClass().getResource("/log4j2.xml").getPath());
        logger.trace("Controller initial");
    }

    private void initializeManualTab() {

        cncModel = new Cnc();
        servocon = ServoCon.INSTANCE;
        if (!servocon.connect()) {
            Platform.runLater(this::showConnectError);
        }

        Task<Void> rootTask = new Task<Void>() {
            boolean connectState;
            double[] position;
            String state;

            @Override
            protected Void call() throws Exception {
                while (!isCancelled()) {
                    connectState = servocon.connectState();
                    if (connectState) {
                        state = servocon.getStatus();
                        position = servocon.getPosition();
                        Platform.runLater(() -> {
                            cncModel.setCncConnect(connectState);
                            cncModel.setxPosition(position[0]);
                            cncModel.setyPosition(position[1]);
                            cncModel.setzPosition(position[2]);
                            cncModel.setCncState(state);
                        });
                    } else {
                        Platform.runLater(() -> cncModel.setCncConnect(connectState));
                    }
                    Thread.sleep(300);
                }
                return null;
            }
        };

        Thread cncObserver = new Thread(rootTask, "cncObserver");
        cncObserver.setDaemon(true);
        cncObserver.start();

        xPosition.textProperty().bind(cncModel.xPositionProperty().asString(Locale.ENGLISH, "%.3f"));
        yPosition.textProperty().bind(cncModel.yPositionProperty().asString(Locale.ENGLISH, "%.3f"));
        zPosition.textProperty().bind(cncModel.zPositionProperty().asString(Locale.ENGLISH, "%.3f"));
        cncState.textProperty().bind(cncModel.cncStateProperty());

        cncState.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("ON")) {
                cncOnOff.setText("ЧПУ ВЫКЛ.");
            } else if (newValue.equals("RESET")) {
                cncOnOff.setText("ЧПУ ВКЛ.");
            }
        });

        cncModel.cncConnectProperty().addListener(((observable, oldValue, newValue) -> {
            if (newValue) {
                cncConnect.setText("Подключено");
            } else {
                cncConnect.setText("Нет подключения");
                showConnectError();
            }
        }));
    }


    private void initializeProgramTab() {
        plane.getItems().setAll("XY", "YZ", "ALL");
        plane.getSelectionModel().select("XY");
        yzPreview.setVisible(false);
        plane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //TODO: сделать выбор вида
            if (newValue.equals("XY")) {
                picturePreview.setVisible(true);
                glassPreview.setVisible(true);
                yzPreview.setVisible(false);
            } else if (newValue.equals("YZ")) {
                picturePreview.setVisible(false);
                glassPreview.setVisible(false);
                yzPreview.setVisible(true);
                yzPreview.setWidth(preview.getWidth());
                yzPreview.setHeight(preview.getHeight());
                if (!pictures.getItems().isEmpty()) {
                }
            } else {
                picturePreview.setVisible(true);
                glassPreview.setVisible(true);
                yzPreview.setVisible(false);
                WritableImage wImage = new WritableImage((int) glassPreview.getWidth(), (int) glassPreview.getHeight());
                PixelWriter writer = wImage.getPixelWriter();
                Image image;
                PixelReader reader;
                for (Picture picture : pictures.getItems()) {
                    image = picture.getImage();
                    reader = image.getPixelReader();
                    for (int y = 0; y < image.getHeight(); y++) {
                        for (int x = 0; x < image.getWidth(); x++) {
                            if (reader.getColor(x, y).equals(Color.WHITE)) {
                                double xW = (picture.getOffsetX() / settingModel.getStepX() + x) * scaleValue.get();
                                double yW = (picture.getOffsetY() / settingModel.getStepY() + y) * scaleValue.get();
                                writer.setColor((int) xW, (int) yW, Color.BLACK);
                            }
                        }
                    }
                }
                picturePreview.setImage(wImage);
            }
        });

//        Scale scaleTransform = new Scale(1, 1);
//        preview.getContent().getTransforms().add(scaleTransform);

        scale.getItems().setAll("200%", "150%", "100%", "75%", "50%", "25%", "12%", "Вписать");
        scale.getSelectionModel().select("100%");
        scale.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Вписать")) {
                scaleValue.set(Math.min(preview.getHeight() / (glass.getLength() / settingModel.getStepX()),
                        preview.getWidth() / (glass.getWidth() / settingModel.getStepY())));
            } else {
                scaleValue.set(Double.parseDouble(newValue.substring(0, newValue.indexOf("%"))) / 100.0);
            }

            System.out.println(scaleValue.get());
        });

        pictures.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("selected: " + newValue);
            if (newValue != null) {
                if (oldValue == null) {
                    height.setDisable(false);
                    offsetX.setDisable(false);
                    offsetY.setDisable(false);
                } else {
                    Bindings.unbindBidirectional(height.textProperty(), oldValue.heightProperty());
                    Bindings.unbindBidirectional(offsetX.textProperty(), oldValue.offsetXProperty());
                    Bindings.unbindBidirectional(offsetY.textProperty(), oldValue.offsetYProperty());
                }
                NumberStringConverter converter = new NumberStringConverter();
                Bindings.bindBidirectional(height.textProperty(), newValue.heightProperty(), converter);
                Bindings.bindBidirectional(offsetX.textProperty(), newValue.offsetXProperty(), converter);
                Bindings.bindBidirectional(offsetY.textProperty(), newValue.offsetYProperty(), converter);

                picturePreview.setX(newValue.getOffsetX() / settingModel.getStepX() * scaleValue.get());
                picturePreview.setY(newValue.getOffsetY() / settingModel.getStepY() * scaleValue.get());

                newValue.offsetXProperty().addListener((observableOffX, oldValueOffX, newValueOffX) ->
                        picturePreview.setX(newValueOffX.doubleValue() / settingModel.getStepX() * scaleValue.get()));
                newValue.offsetYProperty().addListener((observableOffY, oldValueOffY, newValueOffY) ->
                        picturePreview.setY(newValueOffY.doubleValue() / settingModel.getStepY() * scaleValue.get()));

                picturePreview.setFitHeight(newValue.getImage().getHeight() * scaleValue.get());
                picturePreview.setFitWidth(newValue.getImage().getWidth() * scaleValue.get());
                picturePreview.setImage(newValue.getImage());

                String.format(Locale.ENGLISH, newValue + " ");
                String info = "Длина: " + newValue.getImage().getHeight() * 0.1 + "мм(" +
                        newValue.getImage().getHeight() + "px) " +
                        "Ширина " + newValue.getImage().getWidth() * 0.1 + "мм(" +
                        newValue.getImage().getWidth() + "px)";
                previewInfo.setText(info);
            } else {
                height.setText("0.0");
                height.setDisable(true);
                offsetX.setText("0.0");
                offsetX.setDisable(true);
                offsetY.setText("0.0");
                offsetY.setDisable(true);
                picturePreview.setImage(null);
                previewInfo.setText("Предпросмотр:");
            }
        });

        Bindings.bindBidirectional(glassLength.textProperty(), glass.lengthProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(glassWidth.textProperty(), glass.widthProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(glassThickness.textProperty(), glass.thicknessProperty(), new NumberStringConverter());

        glass.lengthProperty().addListener((observable, oldValue, newValue) -> {
            glassPreview.setHeight(newValue.doubleValue() / settingModel.getStepX() * scaleValue.get());
            System.out.println("change glass length " + newValue.doubleValue() / settingModel.getStepX() * scaleValue.get());
        });

        glass.widthProperty().addListener((observable, oldValue, newValue) -> {
            glassPreview.setWidth(newValue.doubleValue() / settingModel.getStepY() * scaleValue.get());
            System.out.println("change glass width " + newValue.doubleValue() / settingModel.getStepY() * scaleValue.get());
        });


        scaleValue.addListener((observable, oldValue, newValue) -> {
            glassPreview.setHeight(glass.getLength() / settingModel.getStepX() * newValue.doubleValue());
            glassPreview.setWidth(glass.getWidth() / settingModel.getStepY() * newValue.doubleValue());
            if (picturePreview.getImage() != null) {
                picturePreview.setFitHeight(picturePreview.getImage().getHeight() * newValue.doubleValue());
                picturePreview.setFitWidth(picturePreview.getImage().getWidth() * newValue.doubleValue());
                picturePreview.setX(pictures.getSelectionModel().getSelectedItem().getOffsetX()
                        / settingModel.getStepX() * newValue.doubleValue());
                picturePreview.setY(pictures.getSelectionModel().getSelectedItem().getOffsetY()
                        / settingModel.getStepX() * newValue.doubleValue());
            }
        });


        glassLength.textProperty().addListener(this::doubleChange);
        glassWidth.textProperty().addListener(this::doubleChange);
        glassThickness.textProperty().addListener(this::doubleChange);
        height.textProperty().addListener(this::doubleChange);
        offsetX.textProperty().addListener(this::doubleChange);
        offsetY.textProperty().addListener(this::doubleChange);

//        preview.heightProperty().addListener((observable, oldValue, newValue) -> {
//            setGlassPreviewSize(glass.getLength(), glass.getWidth());
//            if (pictures.getSelectionModel().getSelectedItem() != null) {
//                setPicturePreviewSize(pictures.getSelectionModel().getSelectedItem().getImage());
//            }
//        });
//
//        preview.widthProperty().addListener((observable, oldValue, newValue) -> {
//            setGlassPreviewSize(glass.getLength(), glass.getWidth());
//            if (pictures.getSelectionModel().getSelectedItem() != null) {
//                setPicturePreviewSize(pictures.getSelectionModel().getSelectedItem().getImage());
//            }
//        });
    }

    public void close() {
        System.out.println("CLOSE");
        FileUtil.clearDirectory(workDir);
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    private void setPicturePreviewSize(Image image) {
        if (image != null) {
            double scale = glassPreview.getHeight() / glass.getLength();
            picturePreview.setFitHeight(image.getHeight() * 0.1 * scale);
            picturePreview.setFitWidth(image.getWidth() * 0.1 * scale);
            System.out.println("PIC - Scale: " + scale + ", Height: " +
                    picturePreview.getFitHeight() + ", Width: " + picturePreview.getFitWidth());
        }
    }

    private void setGlassPreviewSize(double length, double width) {
        double ratioGlass = length / width;
        double maxLength = preview.getHeight();
        double maxWidth = preview.getWidth();
        double ratioPreview = maxLength / maxWidth;
        if (Double.isNaN(ratioGlass) || Double.isNaN(ratioPreview)) {
            if (length == 0.0 && width == 0.0) {
                glassPreview.setHeight(0.0);
                glassPreview.setWidth(0.0);
            }
            return;
        }
        // стеко более вытянуто по высоте чем размер превью поля
        if (ratioGlass >= ratioPreview) {
            glassPreview.setHeight(maxLength);
            glassPreview.setWidth(maxLength / ratioGlass);
        } else {
            glassPreview.setWidth(maxWidth);
            glassPreview.setHeight(maxLength * ratioGlass);
        }
//        if (length >= width){
//            glassPreview.setHeight(maxLength);
//            glassPreview.setWidth(maxLength / r1);
//        }else {
//            glassPreview.setWidth(maxWidth);
//            glassPreview.setHeight(maxWidth * r1);
//        }
        System.out.println(ratioGlass + " : " + glassPreview.getHeight() + " : " + glassPreview.getWidth());
    }

    private void doubleChange(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        System.out.println("change");
        StringProperty textProperty = (StringProperty) observable;
        TextField owner = (TextField) textProperty.getBean();
        if (!newValue.isEmpty()) {
            if (!newValue.matches("\\d*.\\d*")) {
                String begin = newValue.substring(0, newValue.indexOf(".")).replaceAll("[^\\d]", "");
                String end = newValue.substring(newValue.indexOf(".")).replaceAll("[^\\d]", "");
                newValue = begin + "." + end;
                owner.setText(newValue);
            }
        } else {
            owner.setText("0.0");
        }

//        setGlassPreviewSize(glass.getLength(), glass.getWidth());
//        if (pictures.getSelectionModel().getSelectedItem() != null) {
//            setValueById(owner.getId(), newValue);
//            setPicturePreviewSize(pictures.getSelectionModel().getSelectedItem().getImage());
//        }
    }

    private void setValueById(String id, String value) {
        switch (id) {
            case "glassLength":
                if (!value.isEmpty()) {
                    glass.setLength(Double.parseDouble(value));
                } else {
                    glass.setLength(0.0);
                }
                break;
            case "glassWidth":
                if (!value.isEmpty()) {
                    glass.setWidth(Double.parseDouble(value));
                } else {
                    glass.setWidth(0.0);
                }
                break;
            case "glassThickness":
                if (!value.isEmpty()) {
                    glass.setThickness(Double.parseDouble(value));
                } else {
                    glass.setThickness(0.0);
                }
                break;
            case "height":
                if (!value.isEmpty()) {
                    pictures.getSelectionModel().getSelectedItem().setHeight(Double.parseDouble(value));
                } else {
                    pictures.getSelectionModel().getSelectedItem().setHeight(0.0);
                }
                break;
            case "offsetX":
                if (!value.isEmpty()) {
                    pictures.getSelectionModel().getSelectedItem().setOffsetX(Double.parseDouble(value));
                } else {
                    pictures.getSelectionModel().getSelectedItem().setOffsetX(0.0);
                }
                double x = pictures.getSelectionModel().getSelectedItem().getOffsetX() *
                        glassPreview.getHeight() / glass.getLength();
                picturePreview.setX(x);
                break;
            case "offsetY":
                if (!value.isEmpty()) {
                    pictures.getSelectionModel().getSelectedItem().setOffsetY(Double.parseDouble(value));
                } else {
                    pictures.getSelectionModel().getSelectedItem().setOffsetY(0.0);
                }
                double y = pictures.getSelectionModel().getSelectedItem().getOffsetY() *
                        glassPreview.getHeight() / glass.getLength();
                picturePreview.setY(y);
                break;
        }
    }

    @FXML
    private void xPlusHandle() {
        try {
            servocon.jogX(jogVelocity.getValue());
        } catch (Exception e) {
            Platform.runLater(() -> showError(e));
            e.printStackTrace();
        }
    }

    @FXML
    private void xMinusHandle() {
        try {
            servocon.jogX(-jogVelocity.getValue());
        } catch (Exception e) {
            Platform.runLater(() -> showError(e));
            e.printStackTrace();
        }
    }

    @FXML
    private void yPlusHandle() {
        try {
            servocon.jogY(jogVelocity.getValue());
        } catch (Exception e) {
            Platform.runLater(() -> showError(e));
            e.printStackTrace();
        }
    }

    @FXML
    private void yMinusHandle() {
        try {
            servocon.jogY(-jogVelocity.getValue());
        } catch (Exception e) {
            Platform.runLater(() -> showError(e));
            e.printStackTrace();
        }
    }

    @FXML
    private void zPlusHandle() {
        try {
            servocon.jogZ(jogVelocity.getValue());
        } catch (Exception e) {
            Platform.runLater(() -> showError(e));
            e.printStackTrace();
        }
    }

    @FXML
    private void zMinusHandle() {
        try {
            servocon.jogZ(jogVelocity.getValue());
        } catch (Exception e) {
            Platform.runLater(() -> showError(e));
            e.printStackTrace();
        }
    }

    @FXML
    private void jogStop() {
        try {
            servocon.jogStop();
        } catch (Exception e) {
            Platform.runLater(() -> showError(e));
            e.printStackTrace();
        }
    }

    @FXML
    private void onOffHandle() {
        try {
            servocon.toggleState();
        } catch (CNCError cncError) {
            System.out.println(cncError.Message);
            cncError.printStackTrace();
        }
    }

    @FXML
    private void toHomeHandle() throws CNCError {
        servocon.goToHome();
    }

    @FXML
    private void toZeroHandle() {
        try {
            servocon.goToPoint(0, 0);
        } catch (CNCError cncError) {
            cncError.printStackTrace();
        }
    }

    @FXML
    private void laserOnOffHandle() {
        if (laserOnOff.getText().equals("ЛАЗЕР ВКЛ.")) {
            laserOnOff.setText("ЛАЗЕР ВЫКЛ.");
        } else {
            laserOnOff.setText("ЛАЗЕР ВКЛ.");
        }
    }

    @FXML
    private void handleNew() {
        workDir = FileUtil.createWorkDirectory();
        imageDir = FileUtil.createSubDir(workDir, "images");

        glass = new Glass();

        pictures.getItems().clear();

        savedFile = null;

    }

    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Project files (*.prj)", "*.prj");
        fileChooser.getExtensionFilters().add(extFilter);
        if (savedFile != null) {
            fileChooser.setInitialDirectory(savedFile.getParentFile());
        }
        savedFile = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        if (savedFile != null) {
            FileUtil.clearDirectory(workDir);
            workDir = FileUtil.createWorkDirectory();
            imageDir = FileUtil.createSubDir(workDir, "images");
            FileUtil.unzipToDir(savedFile, workDir);
            glass = FileUtil.loadGlassFromFile(new File(workDir, "glass.xml"));
            if (glass != null) {
                glassLength.setText(Double.toString(glass.getLength()));
                glassWidth.setText(Double.toString(glass.getWidth()));
                glassThickness.setText(Double.toString(glass.getThickness()));
            }
            picturesList = FileUtil.loadPicturesFromFile(new File(workDir, "pictures.xml"));
            if (picturesList != null) {
                if (picturesList.getPictures() != null) {
                    for (Picture picture : picturesList.getPictures()) {
                        picture.setImage(new Image(new File(imageDir, picture.getName()).toURI().toString()));
                    }
                    pictures.getItems().setAll(picturesList.getPictures());
                }
            }
            mainApp.setFilePath(savedFile);
        }
    }

    @FXML
    private void handleSave() {
        if (savedFile == null) {
            handleSaveAs();
        } else {
            FileUtil.saveGlassToFile(glass, new File(workDir, "glass.xml"));
            FileUtil.savePicturesToFile(picturesList, new File(workDir, "pictures.xml"));
            FileUtil.addFilesToZip(workDir, savedFile);
        }
    }

    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Project files (*.prj)", "*.prj");
        fileChooser.getExtensionFilters().add(extFilter);
        if (savedFile != null) {
            fileChooser.setInitialDirectory(savedFile.getParentFile());
        }
        savedFile = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
        if (savedFile != null) {
            FileUtil.saveGlassToFile(glass, new File(workDir, "glass.xml"));
            FileUtil.savePicturesToFile(picturesList, new File(workDir, "pictures.xml"));
            FileUtil.addFilesToZip(workDir, savedFile);
            mainApp.setFilePath(savedFile);
        }
    }

    @FXML
    private void handleSettings() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Настройки");
        alert.setDialogPane(settingsPane);
        alert.initOwner(mainApp.getPrimaryStage());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get().equals(ButtonType.OK)) {
            settingsController.saveSettingsToFile();
        }
        System.out.println(settingModel.getCncMaxAcc());
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("О программе");
        alert.setHeaderText("Лазерная гравировка по стеку");
        alert.setContentText("");
        alert.initOwner(mainApp.getPrimaryStage());
        alert.showAndWait();
    }

    @FXML
    private void handleAdd() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "BMP files (*.bmp)", "*.bmp");
        fileChooser.getExtensionFilters().add(extFilter);
        if (lastAddDir != null) {
            fileChooser.setInitialDirectory(lastAddDir);
        }
        List<File> files = fileChooser.showOpenMultipleDialog(mainApp.getPrimaryStage());
        if (files != null) {
            lastAddDir = files.get(0).getParentFile();
            FileUtil.copyFilesToDir(files, imageDir);
            picturesList.setPictures(FileUtil.updatePicturesFromDir(imageDir));
            pictures.getItems().setAll(picturesList.getPictures());
        }
    }

    @FXML
    private void handleDelete() {
        pictures.getItems().remove(pictures.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void handleStart() {
        picturesList.setPictures(pictures.getItems());
        picturesList.sort();
        Task<Void> porgamTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                AnchorPane view = (AnchorPane) preview.getContent();
                for (Picture picture : pictures.getItems()) {
                    System.out.println(picture.getHeight());
                    Platform.runLater(() -> pictures.getSelectionModel().select(picture));
                    double xStart = (picture.getStartX() + picture.getOffsetX() / settingModel.getStepX()) * scaleValue.get();
                    double yStart = (picture.getStartY() + picture.getOffsetY() / settingModel.getStepY()) * scaleValue.get();
                    Line toStart = new Line(0.0, 0.0, xStart, yStart);
                    toStart.setStroke(Color.RED);
                    Platform.runLater(() -> view.getChildren().add(toStart));
                    double xStartMm = picture.getStartX() * settingModel.getStepX() + picture.getOffsetX();
                    double xEndMm = picture.getEndX() * settingModel.getStepX() + picture.getOffsetX();
                    double yStartMm = picture.getStartY() * settingModel.getStepY() + picture.getOffsetY();
                    servocon.goToPoint(xStartMm, yStartMm);
                    double width = (picture.getEndX() - picture.getStartX()) * scaleValue.get();
                    Rectangle workArea = new Rectangle(xStart, yStart, width, 0.0);
                    workArea.setFill(Color.GREEN);
                    workArea.setOpacity(0.5);
                    Platform.runLater(() -> view.getChildren().add(workArea));
                    int count = picture.getEndY() - picture.getStartY();
                    for (int i = 1; i <= count; i++) {
                        if (i % 2 == 0) {
                            servocon.goToX(xEndMm);
                        } else {
                            servocon.goToX(xStartMm);
                        }
                        workArea.setHeight(i * scaleValue.get());
                        System.out.print(i + " ");
                        servocon.goToY(yStartMm + i * settingModel.getStepY());
                    }
                    System.out.println();
                    double xEnd;
                    if (count % 2 == 0) {
                        xEnd = xStart;
                    } else {
                        xEnd = (picture.getEndX() + picture.getOffsetX() / settingModel.getStepX()) * scaleValue.get();
                    }
                    double yEnd = (picture.getEndY() + picture.getOffsetY() / settingModel.getStepY()) * scaleValue.get();
                    Line toZero = new Line(xEnd, yEnd, 0.0, 0.0);
                    toStart.setStroke(Color.BLUE);
                    Platform.runLater(() -> view.getChildren().add(toZero));
                    Platform.runLater(() -> view.getChildren().remove(toStart));
                    Platform.runLater(() -> view.getChildren().remove(workArea));
                    Platform.runLater(() -> view.getChildren().remove(toZero));
                }
                return null;
            }
        };
        new Thread(porgamTask).start();
    }

    @FXML
    private void handleStop() {

    }

    @FXML
    private void handlePause() {

    }

    private void showError(Exception ex) {
        //TODO: Сделать логику сообщений пользователю, например о неверно введенном значении и т.п.
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception");
        alert.setHeaderText(ex.toString());
        alert.setContentText(ex.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    private void showConnectError() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Нет подключения");

        alert.showAndWait();
    }

    private class ProgramTask extends Task<Void> {
        double xStartPx;
        double xStartMm;
        double yStartPx;
        double yStartMm;
        double xEndPx;
        double xEndMm;
        double yEndPx;
        double yEndMm;
        double accPath;
        int count;


        @Override
        protected Void call() throws Exception {
            sortPictures();
            for (Picture picture : picturesList.getPictures()) {
                selectPicture(picture);
                calculateParams(picture);
                Platform.runLater(this::drawToStartLine);
                servocon.goToPoint(xStartMm - accPath, yStartMm);
                servocon.goToZ(picture.getHeight());
                //здесь нужно послать данные MCU
                Platform.runLater(this::drawProgressArea);
                for (int i = 0; i < count; i++) {
                    if (i % 2 == 0) {
                        servocon.goToX(xEndMm + accPath, settingModel.getCncMaxSpeed());
                    } else {
                        servocon.goToX(xStartMm - accPath, settingModel.getCncMaxSpeed());
                    }
                    progressArea.setHeight(i * scaleValue.get());
                }
                Platform.runLater(this::drawToZeroLine);
                servocon.goToPoint(0, 0);
                Platform.runLater(this::clear);
            }
            return null;
        }

        private void clear() {
            toStartLine.setVisible(false);
            progressArea.setVisible(false);
            toZeroLine.setVisible(false);
        }

        private void drawToZeroLine() {
            if (count % 2 == 0) {
                toStartLine.setStartX(xStartPx);
            } else {
                toStartLine.setStartX(xEndPx);
            }
            toStartLine.setStartY(yEndPx);
            toStartLine.setEndX(0);
            toStartLine.setEndY(0);
            toStartLine.setVisible(true);
        }

        private void drawProgressArea() {
            progressArea.setX(xStartPx);
            progressArea.setY(yStartPx);
            progressArea.setWidth(xEndPx - xStartPx);
            progressArea.setHeight(0);
            progressArea.setVisible(true);
        }

        private void drawToStartLine() {
            toStartLine.setStartX(0);
            toStartLine.setStartY(0);
            toStartLine.setEndX(xStartPx);
            toStartLine.setEndY(yStartPx);
            toStartLine.setVisible(true);
        }

        private void calculateParams(Picture picture) {
            int startX = picture.getStartX();
            int startY = picture.getStartY();
            int endX = picture.getEndX();
            int endY = picture.getEndY();
            xStartPx = (startX + picture.getOffsetX() / settingModel.getStepX()) * scaleValue.get();
            xStartMm = startX * settingModel.getStepX() + picture.getOffsetX();
            yStartPx = (startY + picture.getOffsetY() / settingModel.getStepY()) * scaleValue.get();
            yStartMm = startY * settingModel.getStepY() + picture.getOffsetX();
            xEndPx = (endX + picture.getOffsetX() / settingModel.getStepX()) * scaleValue.get();
            xEndMm = endX * settingModel.getStepX() + picture.getOffsetX();
            yEndPx = (endY + picture.getOffsetY() / settingModel.getStepY()) * scaleValue.get();
            yEndMm = endY * settingModel.getStepY() + picture.getOffsetY();

//          V(t) = a * t, s(t) = a * t^2 / 2
//          t = v / a, s =  v^2 / 2*a
            accPath = Math.pow(settingModel.getCncMaxSpeed(), 2) / 2 * settingModel.getCncMaxAcc();

            count = endY - startY;

        }

        private void selectPicture(Picture picture) {
            Platform.runLater(() -> pictures.getSelectionModel().select(picture));
        }

        private void sortPictures() {
            picturesList.setPictures(pictures.getItems());
            picturesList.sort();
        }
    }
}