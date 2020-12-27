package it.units.sdm.project.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Root.fxml"));
        Scene scene = new Scene(root, 600, 650, Color.web("0x4D4D4D"));
        scene.getStylesheets().add("/css/stylesheet.css");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/application_icon.png")));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Chaos And Order Game");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}