package com.karev.kvantron;

import com.karev.kvantron.controllers.RootLayoutController;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

public class Main extends Application {
    private Scene scene;
    private Stage primaryStage;
    private String name = "Лазер-Фото";

    @Override
    public void stop() throws Exception {
        rootLayoutController.close();
    }

    private RootLayoutController rootLayoutController;

    public static void main(String[] args) {
        LauncherImpl.launchApplication(Main.class, appPreloader.class, args);
//        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/rootLayout.fxml"));
        Parent root = loader.load();
                //loader.load(getClass().getResourceAsStream("/fxml/rootLayout.fxml"));
        rootLayoutController = loader.getController();
        rootLayoutController.setMainApp(this);
        scene = new Scene(root, 900, 600);


    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println("start");
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(name);
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage name.
            primaryStage.setTitle(name + " - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage name.
            primaryStage.setTitle(name);
        }
    }


    public File getFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    public String getName() {
        return this.name;
    }
}
