package sdm.project.guicomponents.controllers;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sdm.project.GUIGame;
import sdm.project.guicomponents.windows.InstructionsWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {

    @FXML MenuBar menuBar;

    @FXML Menu fileMenu;
    @FXML MenuItem newGame;
    @FXML MenuItem exitGame;

    @FXML Menu helpMenu;
    @FXML MenuItem readInstructions;
    @FXML MenuItem about;

    RootController rootController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        newGame.setOnAction(event -> rootController.newGame());
        exitGame.setOnAction(event -> System.exit(0));

        readInstructions.setOnAction(event -> {
            InstructionsWindow instructionsWindow = new InstructionsWindow();
            instructionsWindow.show();
        });

        about.setOnAction(event -> {
            ((Node) event.getSource()).getScene().getStylesheets().add("/css/application2.css");
        });

    }

    public void injectRootController(RootController rootController) {
        this.rootController = rootController;
    }

}
