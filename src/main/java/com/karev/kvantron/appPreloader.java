package com.karev.kvantron;

import javafx.application.Preloader;
import javafx.application.Preloader.StateChangeNotification.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class appPreloader extends Preloader {
    private Stage preloaderStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("preloader start");
        this.preloaderStage = primaryStage;

//        VBox loading = new VBox(20);
//        loading.setMaxWidth(Region.USE_PREF_SIZE);
//        loading.setMaxHeight(Region.USE_PREF_SIZE);
//        loading.getChildren().add(new ProgressBar());
//        loading.getChildren().add(new Label("Please wait..."));
//
//        BorderPane root = new BorderPane(loading);
//        Scene scene = new Scene(root);

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("/fxml/preloader.fxml"));
        Scene scene = new Scene(root, 600, 400);

//        primaryStage.setWidth(800);
//        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Лазерная Гравировка");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));

        primaryStage.show();
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
        if (stateChangeNotification.getType() == Type.BEFORE_START) {
            System.out.println("notification BEFORE START");
            preloaderStage.hide();
        }
    }

}
