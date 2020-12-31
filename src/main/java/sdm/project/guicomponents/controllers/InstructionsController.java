package sdm.project.guicomponents.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sdm.project.core.utils.GameMessages;

import java.net.URL;
import java.util.ResourceBundle;

public class InstructionsController implements Initializable {

    @FXML
    Label instructions;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instructions.setText(GameMessages.INTRO);
    }
}
