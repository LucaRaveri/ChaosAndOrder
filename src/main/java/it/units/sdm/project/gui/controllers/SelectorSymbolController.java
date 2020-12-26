package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Player;
import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.gui.imageviews.CircleImageView;
import it.units.sdm.project.gui.imageviews.CrossImageView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
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

    ToggleGroup toggleGroup;
    ImageView cross = new CrossImageView();
    ImageView circle = new CircleImageView();

    Player currentPlayer;
    Symbol currentSymbol;
    Effect circleEffect;
    Effect crossEffect;
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

        toggleGroup = new ToggleGroup();
        crossRadio.setToggleGroup(toggleGroup);
        circleRadio.setToggleGroup(toggleGroup);
        crossRadio.setGraphic(cross);
        circleRadio.setGraphic(circle);
        circleRadio.setEffect(circleEffect);


        AnchorPane.setRightAnchor(anchorPane, 50.0);
        AnchorPane.setLeftAnchor(anchorPane, 50.0);
        AnchorPane.setTopAnchor(anchorPane, 50.0);

        AnchorPane.setLeftAnchor(nextMove, 10.0);

        AnchorPane.setRightAnchor(crossRadio, 40.0);
        AnchorPane.setRightAnchor(circleRadio, 120.0);

        nextMove.setTextFill(Color.WHITE);
        nextMove.setText("You are player ORDER.\nSelect your next symbol!");
        nextMove.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Baby_Girl.otf"), 20));

    }

    public Symbol getCurrentSymbol() {
        return (toggleGroup.getSelectedToggle() == circleRadio) ? Symbol.CIRCLE : Symbol.CROSS;
    }

    public void setEffect() {

        mediaPlayer.seek(Duration.ZERO);
        mediaPlayer.play();

        if (toggleGroup.getSelectedToggle() == circleRadio) {
            circleRadio.setEffect(circleEffect);
            crossRadio.setEffect(null);
        } else {
            crossRadio.setEffect(crossEffect);
            circleRadio.setEffect(null);
        }
    }


    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == Player.CHAOS) ? Player.ORDER : Player.CHAOS;
        nextMove.setText("You are player " + currentPlayer.name() + ".\nSelect your next symbol!");
    }
}
