package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Symbol;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectorSymbolController implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    Label nextMove;
    @FXML
    ImageView circle;
    @FXML
    ImageView cross;

    Symbol symbol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AnchorPane.setTopAnchor(circle, 30.0);
        AnchorPane.setTopAnchor(cross, 30.0);

        AnchorPane.setLeftAnchor(circle, 20.0);
        AnchorPane.setLeftAnchor(cross, 70.0);

        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> symbol = Symbol.CIRCLE);
        cross.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> symbol = Symbol.CROSS);
    }

    public Symbol getSymbol(){
        return symbol;
    }
}
