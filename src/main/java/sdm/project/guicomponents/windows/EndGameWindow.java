package sdm.project.guicomponents.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sdm.project.core.entities.Player;

import java.io.IOException;


public class EndGameWindow {

    public EndGameWindow(Player winner) {
//        imageView.setImage(winner == Player.ORDER ? new Image("/images/Order.png") : new Image("/images/Chaos.png"));
    }

    public void display() {

        Parent root = null;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/EndGame.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, Color.web("0x4D4D4D"));
        scene.getStylesheets().add("/css/light-theme.css");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/application_icon.png")));

        stage.setScene(scene);
        stage.setTitle("Game comes up with an end");
        stage.setResizable(false);
        stage.show();

    }

}
