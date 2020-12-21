package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Symbol;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private MenuBarController menuBarController;

    @FXML
    private BoardController boardController;

    @FXML
    private SelectorSymbolController selectorSymbolController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBarController.injectRootController(this);
        boardController.injectRootController(this);
    }

    public Symbol getSymbol(){
        return selectorSymbolController.getSymbol();
    }

}
