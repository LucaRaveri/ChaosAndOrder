package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Symbol;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectorSymbolController implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    Label nextMove;
    @FXML
    ImageView cross;
    @FXML
    ImageView circle;

    Symbol symbol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AnchorPane.setRightAnchor(anchorPane, 0.0);
        AnchorPane.setLeftAnchor(anchorPane, 0.0);

        AnchorPane.setTopAnchor(nextMove, 30.0);
        AnchorPane.setTopAnchor(circle, 30.0);
        AnchorPane.setTopAnchor(cross, 30.0);

        AnchorPane.setRightAnchor(cross, 40.0);
        AnchorPane.setRightAnchor(circle, 120.0);

        getClass();

        nextMove.setText("You are player ORDER.\nSelect your next symbol!");
        nextMove.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Baby_Girl.otf"), 20));

        cross.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> symbol = Symbol.CROSS);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> symbol = Symbol.CIRCLE);
    }

    public Symbol getSymbol(){
        return symbol;
    }
}
