package sdm.project.guicomponents.controllers;

import javafx.scene.control.RadioMenuItem;
import javafx.stage.Window;
import sdm.project.guicomponents.windows.InstructionsWindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController implements Initializable {

    @FXML
    MenuBar menuBar;

    @FXML
    Menu fileMenu;
    @FXML
    MenuItem newGame;
    @FXML
    MenuItem exitGame;

    @FXML
    Menu helpMenu;
    @FXML
    MenuItem readInstructions;
    @FXML
    MenuItem about;

    @FXML
    Menu themeMenu;
    @FXML
    RadioMenuItem lightTheme;
    @FXML
    RadioMenuItem darkTheme;

    RootController rootController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        newGame.setOnAction(event -> rootController.newGame());
        exitGame.setOnAction(event -> System.exit(0));
        menuBar.getStyleClass().add("menubar");

        lightTheme.setOnAction(event -> {
//            menuBar.getScene().getStylesheets().remove(getClass().getResource("/css/dark-theme.css").toExternalForm());
            menuBar.getScene().getStylesheets().remove(menuBar.getScene().getStylesheets());
            menuBar.getScene().getStylesheets().add("/css/light-theme.css");
        });

        darkTheme.setOnAction(event -> {
            menuBar.getScene().getStylesheets().remove(menuBar.getScene().getStylesheets());
//            menuBar.getScene().getStylesheets().remove(getClass().getResource("/css/light-theme.css").toExternalForm());
            menuBar.getScene().getStylesheets().add("/css/dark-theme.css");
        });

        readInstructions.setOnAction(event -> {
            InstructionsWindow instructionsWindow = new InstructionsWindow();
            instructionsWindow.show();
        });

        about.setOnAction(event -> {
            Window window = Window.getWindows().stream().filter(Window::isShowing).findFirst().get();
            window.getScene().getStylesheets().add("/css/light-theme.css");
        });

    }

    public void injectRootController(RootController rootController) {
        this.rootController = rootController;
    }

}
