package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Player;
import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.gui.imageviews.CircleImageView;
import it.units.sdm.project.gui.imageviews.CrossImageView;
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

        nextMove.setTextFill(Color.WHITE);
        nextMove.setText("You are player " + currentPlayer.name() + ".\nSelect your next symbol!");
        nextMove.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Baby_Girl.otf"), 20));

    }

    public Symbol getCurrentSymbol() {
        return (circleRadio.isSelected()) ? Symbol.CIRCLE : Symbol.CROSS;
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    @FXML
    private void setEffect() {

        mediaPlayer.seek(Duration.ZERO);
        mediaPlayer.play();

        if (circleRadio.isSelected()) {
            circleRadio.setEffect(circleEffect);
            crossRadio.setEffect(null);
        } else {
            crossRadio.setEffect(crossEffect);
            circleRadio.setEffect(null);
        }

//        ToggleGroup tg = new ToggleGroup();
//
//        circleRadio.selectedProperty().addListener((observable, oldValue, newValue) -> {
//            if(oldValue==true){
//                circleRadio.setEffect(circleEffect);
//            } else{
//                circleRadio.setEffect(null);
//            }
//        });
//
//        crossRadio.selectedProperty().addListener((observable, oldValue, newValue) -> {
//            if(newValue==true){
//                circleRadio.setEffect(crossEffect);
//            } else{
//                circleRadio.setEffect(null);
//            }
//        });
    }


    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == Player.CHAOS) ? Player.ORDER : Player.CHAOS;
        nextMove.setText("You are player " + currentPlayer.name() + ".\nSelect your next symbol!");
    }
}
