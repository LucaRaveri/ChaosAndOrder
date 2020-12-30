package sdm.project.guicomponents.windows;

import com.sun.media.jfxmedia.events.PlayerEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sdm.project.Play;
import sdm.project.core.entities.Player;
import sdm.project.guicomponents.controllers.EndGameController;

import java.io.IOException;


public class EndGameWindow {

    public void display(Player winner) {

        Parent root = null;
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EndGame.fxml"));
            root = loader.load();
            EndGameController controller = loader.getController();
            controller.setWinner(winner);
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
