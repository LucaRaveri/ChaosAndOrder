package sdm.project.guicomponents.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sdm.project.core.utils.GameMessages;

import java.io.IOException;

public class InstructionsWindow {

    public void display(){
        Pane root = null;
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.setResizable(false);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Instructions.fxml"));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        scene.setOnMouseClicked(event1 -> stage.close());
        scene.getStylesheets().add("/css/light-theme.css");
        stage.setScene(scene);

        stage.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
            if(!isFocused) stage.close();
        });
        stage.show();
    }


}
