package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Symbol;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private BoardController boardController;

    @FXML
    private SelectorSymbolController selectorSymbolController;

    public Board logicBoard = new Board();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardController.injectRootController(this);

        AnchorPane.setBottomAnchor(boardController.getBoard(), 25d);
        AnchorPane.setLeftAnchor(boardController.getBoard(), 50d);
    }

    public Symbol getSymbol(){
        return selectorSymbolController.getSymbol();
    }

    public void changePlayer(){
        selectorSymbolController.switchPlayer();
    }

}
