package it.units.sdm.project.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameScreen extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("Start Game");
        button.setOnAction(e -> System.out.println("Game Started!"));
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}