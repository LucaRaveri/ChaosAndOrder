package sdm.project.guicomponents.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class EndGameController implements Initializable {

    @FXML
    Label congratulations;

    @FXML
    Button newGame;
    @FXML
    Button backToBoard;

    @FXML
    ImageView imageview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        congratulations.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Baby_Girl.otf"), 30));
        congratulations.setText("Congratulations,\nWinner!");

        imageview.setFitHeight(100);
        imageview.setPreserveRatio(true);
        imageview.setImage(new Image("/images/Chaos.png"));
    }


}
