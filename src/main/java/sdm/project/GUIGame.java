package sdm.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GUIGame extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainwindow/Root.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/light-theme.css");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/application_icon.png")));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Chaos And Order Game");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}