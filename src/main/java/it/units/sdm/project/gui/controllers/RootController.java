package it.units.sdm.project.gui.controllers;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBarController.injectRootController(this);
    }

}
