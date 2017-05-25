package com.karev.kvantron.controllers;

import com.karev.kvantron.model.Settings;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsLayoutController implements Initializable {
    private Settings settings;

    public Settings getSettings() {
        return settings;
    }

    @FXML
    private TextField cncMaxSpeed;
    @FXML
    private TextField cncMaxAcc;
    @FXML
    private TextField stepX;
    @FXML
    private TextField stepY;
    @FXML
    private RadioButton simetricaly;
    @FXML
    private TextField refractiveIndex;
    @FXML
    private TextField xZero;
    @FXML
    private TextField yZero;
    @FXML
    private TextField zZero;
    @FXML
    private Label stepXLabel;
    @FXML
    private Label stepYLabel;


    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cncMaxSpeed.textProperty().addListener(this::doubleChange);
        cncMaxAcc.textProperty().addListener(this::doubleChange);
        stepX.textProperty().addListener(this::doubleChange);
        stepY.textProperty().addListener(this::doubleChange);
        refractiveIndex.textProperty().addListener(this::doubleChange);
        xZero.textProperty().addListener(this::doubleChange);
        yZero.textProperty().addListener(this::doubleChange);
        zZero.textProperty().addListener(this::doubleChange);

        simetricaly.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                stepY.setVisible(false);
                stepYLabel.setVisible(false);
                stepXLabel.setText("Размер пикселя");
                stepY.textProperty().bind(stepX.textProperty());
            } else {
                stepY.setVisible(true);
                stepYLabel.setVisible(true);
                stepXLabel.setText("Размер пикселя по X:");
                stepYLabel.setText("Размер пикселя по Y:");
                stepY.textProperty().unbind();
            }
        });

        loadSettingsFromFile();

        NumberStringConverter converter = new NumberStringConverter();
        Bindings.bindBidirectional(cncMaxSpeed.textProperty(), settings.cncMaxSpeedProperty(), converter);
        Bindings.bindBidirectional(cncMaxAcc.textProperty(), settings.cncMaxAccProperty(), converter);
        Bindings.bindBidirectional(stepX.textProperty(), settings.stepXProperty(), converter);
        Bindings.bindBidirectional(stepY.textProperty(), settings.stepYProperty(), converter    );
        Bindings.bindBidirectional(refractiveIndex.textProperty(), settings.refractiveIndexProperty(), converter    );
        Bindings.bindBidirectional(xZero.textProperty(), settings.xZeroProperty(), converter);
        Bindings.bindBidirectional(yZero.textProperty(), settings.yZeroProperty(), converter);
        Bindings.bindBidirectional(zZero.textProperty(), settings.zZeroProperty(), converter);
        Bindings.bindBidirectional(simetricaly.selectedProperty(), settings.simetricalyProperty());
    }


    private void doubleChange(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        StringProperty textProperty = (StringProperty) observable;
        if (!newValue.isEmpty()) {
            if (!newValue.matches("\\d*.\\d*")) {
                String begin = newValue.substring(0, newValue.indexOf(".")).replaceAll("[^\\d]", "");
                String end = newValue.substring(newValue.indexOf(".")).replaceAll("[^\\d]", "");
                newValue = begin + "." + end;
                textProperty.setValue(newValue);
            }
        } else {
            textProperty.setValue("0.0");
        }
    }

    public void loadSettingsFromFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Settings.class);
            Unmarshaller um = context.createUnmarshaller();
            settings = (Settings) um.unmarshal(new File(getClass().getResource("/configs/setting.xml").getFile()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void saveSettingsToFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Settings.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(settings, new File(getClass().getResource("/configs/setting.xml").getFile()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
