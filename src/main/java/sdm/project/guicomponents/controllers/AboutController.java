package sdm.project.guicomponents.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable {

    @FXML
    TextFlow credits;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label label = new Label("Our Project can be found on Github:");
        Hyperlink hyperlink = new Hyperlink("http://github.com/RacmanT/ChaosAndOrder");
        hyperlink.setOnAction(event-> {
            try {
                Desktop.getDesktop().browse(new URI(hyperlink.getText()));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        });
        credits.getChildren().addAll(label, hyperlink);

    }
}
