package it.units.sdm.project.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable{

    private RootController rootController;


    @FXML MenuBar menuBar;

    @FXML Menu fileMenu;
    @FXML MenuItem newGame;
    @FXML MenuItem exit;

    @FXML Menu helpMenu;
    @FXML MenuItem readInstructions;

    public void injectRootController(RootController rootController){
        this.rootController = rootController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileMenu.setText("File");
        newGame.setText("New Game...");
        exit.setText("Exit...");

        helpMenu.setText("Help");
        readInstructions.setText("Read Instructions...");

    }
}
