package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Symbol;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
    RootController rootController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AnchorPane.setRightAnchor(anchorPane, 50.0);
        AnchorPane.setLeftAnchor(anchorPane, 50.0);

        AnchorPane.setLeftAnchor(nextMove, 10.0);

        AnchorPane.setTopAnchor(nextMove, 30.0);
        AnchorPane.setTopAnchor(circle, 30.0);
        AnchorPane.setTopAnchor(cross, 30.0);

        AnchorPane.setRightAnchor(cross, 40.0);
        AnchorPane.setRightAnchor(circle, 120.0);

        nextMove.setText("You are player ORDER.\nSelect your next symbol!");
        nextMove.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Baby_Girl.otf"), 20));

    }

    @FXML
    private void selectSymbol(Event e) {
        if (e.getSource() == circle) {
            circle.setEffect(new Shadow(BlurType.GAUSSIAN, Color.AQUA, 5.0));
            cross.setEffect(null);
            setSymbol(Symbol.CIRCLE);
        } else {
            cross.setEffect(new Shadow(BlurType.GAUSSIAN, Color.RED, 5.0));
            circle.setEffect(null);
            setSymbol(Symbol.CROSS);
        }
    }

    private void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    ;

    public Symbol getSymbol() {
        return symbol;
    }

    public void injectRootCotroller(RootController rootController) {
        this.rootController = rootController;
    }
}
