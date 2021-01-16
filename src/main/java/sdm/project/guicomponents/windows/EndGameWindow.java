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

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EndGame.fxml")).load();
            Parent root = loader.load();

            Stage stage = new Stage(StageStyle.UNDECORATED);
            stage.initModality(Modality.APPLICATION_MODAL);

            EndGameController controller = loader.getController();
            controller.setWinner(winner);

            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
