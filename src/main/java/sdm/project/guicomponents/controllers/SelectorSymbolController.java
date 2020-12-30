package sdm.project.guicomponents.controllers;

import javafx.scene.control.ToggleGroup;
import sdm.project.core.entities.Player;
import sdm.project.core.entities.Symbol;
import sdm.project.guicomponents.imageviews.CircleImageView;
import sdm.project.guicomponents.imageviews.CrossImageView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectorSymbolController implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    Label nextMove;
    @FXML
    RadioButton crossRadio;
    @FXML
    RadioButton circleRadio;
    @FXML
    ToggleGroup toggleGroup;

    Player currentPlayer;
    Symbol currentSymbol;
    Effect circleEffect, crossEffect;
    MediaPlayer mediaPlayer;

    {
        currentPlayer = Player.ORDER;
        currentSymbol = Symbol.CIRCLE;

        circleEffect = new DropShadow(10d, Color.BLUE);
        crossEffect = new DropShadow(10d, Color.RED);

        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/sounds/switch-symbol.mp3").toString()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        crossRadio.setGraphic(new CrossImageView());
        circleRadio.setGraphic(new CircleImageView());
        circleRadio.setEffect(circleEffect);
        circleRadio.setSelected(true);

        nextMove.setText("You are player " + currentPlayer.name() + ".\nSelect your next symbol!");
        nextMove.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bookerly-Bold.ttf"), 20));

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            ((RadioButton) oldValue).setEffect(null);
            ((RadioButton) newValue).setEffect(newValue==crossRadio? crossEffect: circleEffect);
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
