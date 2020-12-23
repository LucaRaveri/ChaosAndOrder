package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.gui.windows.InstructionsWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {

    @FXML
    MenuBar menuBar;

    @FXML Menu fileMenu ;
    @FXML MenuItem newGame;
    @FXML MenuItem exit;

    @FXML Menu helpMenu;
    @FXML MenuItem readInstructions;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        AnchorPane.setRightAnchor(menuBar, 0.0);
        AnchorPane.setLeftAnchor(menuBar, 0.0);

        exit.setOnAction(event -> System.exit(0));

        readInstructions.setOnAction(event -> {
            InstructionsWindow instructionsWindow = new InstructionsWindow();
            instructionsWindow.show();
        });

    }

}
