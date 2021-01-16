package sdm.project.guicomponents.controllers.mainwindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import sdm.project.core.entities.Player;
import sdm.project.core.entities.Symbol;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectorSymbolController implements Initializable {

    @FXML AnchorPane anchorPane;

    @FXML Label nextMove;
    @FXML ToggleGroup toggleGroup;
    @FXML RadioButton crossRadio;
    @FXML RadioButton circleRadio;

    @FXML DropShadow circleEffect;
    @FXML DropShadow crossEffect;

    Player currentPlayer;

    MediaPlayer mediaPlayer;

    {
        currentPlayer = Player.ORDER;
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/sounds/switch-symbol.mp3").toString()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // only circleEffect has to be shown
        crossEffect.setRadius(0d);

        nextMove.setText("You are player " + currentPlayer.name() + ".\nSelect your next symbol!");

        toggleGroup.selectedToggleProperty().addListener((observable, oldSymbol, newSymbol) -> {

            if (oldSymbol == crossRadio) {
                crossEffect.setRadius(0d);
                circleEffect.setRadius(10d);
            } else {
                crossEffect.setRadius(10d);
                circleEffect.setRadius(0d);
            }

            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();

        });

    }

    public Symbol getCurrentSymbol() {
        return (circleRadio.isSelected()) ? Symbol.CIRCLE : Symbol.CROSS;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        nextMove.setText("You are player " + currentPlayer.name() + ".\nSelect your next symbol!");
    }


    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == Player.CHAOS) ? Player.ORDER : Player.CHAOS;
        nextMove.setText("You are player " + currentPlayer.name() + ".\nSelect your next symbol!");
    }

}
