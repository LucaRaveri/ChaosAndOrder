package sdm.project.guicomponents.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sdm.project.core.entities.Player;

import java.net.URL;
import java.util.ResourceBundle;

public class EndGameController implements Initializable {

    @FXML Label congratulations;

    @FXML Button exit;

    @FXML Button backToBoard;

    @FXML ImageView winnerIcon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        backToBoard.setOnAction(event -> ((Stage) backToBoard.getScene().getWindow()).close());
        exit.setOnAction(event -> Platform.exit());

    }

    public void setWinner(Player winner) {
        winnerIcon.setImage(new Image(winner == Player.ORDER ? "/images/order.png" : "/images/chaos.png"));
        winnerIcon.setSmooth(true);
        winnerIcon.setCache(true);

        congratulations.setText("Congratulations,\n" + winner.name());
    }


}
