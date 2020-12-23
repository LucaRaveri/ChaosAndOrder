package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Player;
import it.units.sdm.project.entities.Role;
import it.units.sdm.project.entities.Symbol;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectorSymbolController implements Initializable {

    @FXML AnchorPane anchorPane;
    @FXML Label nextMove;
    @FXML RadioButton crossRadio;
    @FXML RadioButton circleRadio;

    ToggleGroup toggleGroup;
    ImageView cross = new ImageView(new Image("/images/cross.png"));
    ImageView circle = new ImageView(new Image("/images/circle.png"));

    Player currentPlayer;
    Symbol symbol;
    Effect circleEffect;
    Effect crossEffect;

    {
        currentPlayer = new Player(Role.ORDER);
        symbol = Symbol.CIRCLE;

        circleEffect = new DropShadow(10d, Color.BLUE);
        crossEffect = new DropShadow(10d, Color.RED);

        cross.setFitWidth(50);
        cross.setFitHeight(50);
        circle.setFitWidth(50);
        circle.setFitHeight(50);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        toggleGroup = new ToggleGroup();
        crossRadio.setToggleGroup(toggleGroup);
        circleRadio.setToggleGroup(toggleGroup);
        crossRadio.setGraphic(cross);
        circleRadio.setGraphic(circle);
        circleRadio.setEffect(circleEffect);

//        circleButton.setEffect(circleEffect);

        AnchorPane.setRightAnchor(anchorPane, 50.0);
        AnchorPane.setLeftAnchor(anchorPane, 50.0);

        AnchorPane.setLeftAnchor(nextMove, 10.0);
        AnchorPane.setTopAnchor(nextMove, 50.0);

        AnchorPane.setTopAnchor(circleRadio, 50.0);
        AnchorPane.setTopAnchor(crossRadio, 50.0);

        AnchorPane.setRightAnchor(crossRadio, 40.0);
        AnchorPane.setRightAnchor(circleRadio, 120.0);

        nextMove.setTextFill(Color.WHITE);
        nextMove.setText("You are player ORDER.\nSelect your next symbol!");
        nextMove.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Baby_Girl.otf"), 20));

    }

    public Symbol getSymbol() {
        return (toggleGroup.getSelectedToggle()==circleRadio)? Symbol.CIRCLE: Symbol.CROSS;
    }

    public void setEffect(){
        if(toggleGroup.getSelectedToggle()==circleRadio){
            circleRadio.setEffect(circleEffect);
            crossRadio.setEffect(null);
        } else{
            crossRadio.setEffect(crossEffect);
            circleRadio.setEffect(null);
        }
    }


    public void switchPlayer() {
        if (currentPlayer.getRole() == Role.ORDER) {
            nextMove.setText("You are player CHAOS.\nSelect your next symbol!");
            currentPlayer.setRole(Role.CHAOS);
        } else {
            nextMove.setText("You are player ORDER.\nSelect your next symbol!");
            currentPlayer.setRole(Role.ORDER);
        }
    }
}
