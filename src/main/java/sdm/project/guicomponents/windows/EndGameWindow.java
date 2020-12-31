package sdm.project.guicomponents.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sdm.project.core.entities.Player;
import sdm.project.guicomponents.controllers.EndGameController;

import java.io.IOException;


public class EndGameWindow {

    public void display(Player winner) {

        Parent root = null;
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EndGame.fxml"));
            root = loader.load();
            EndGameController controller = loader.getController();
            controller.setWinner(winner);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/light-theme.css");

        stage.setScene(scene);
        stage.setTitle("Game comes up with an end");
        stage.setResizable(false);
        stage.show();

    }

}
