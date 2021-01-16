package sdm.project.guicomponents.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class InstructionsWindow {

    public void display() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Instructions.fxml"));
            Pane root = loader.load();

            Stage stage = new Stage(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
                if (!isFocused) stage.close();
            });

            Scene scene = new Scene(root);
            scene.setOnMouseClicked(event -> stage.close());
            scene.getStylesheets().add("/css/themes/light-theme.css"); //TODO

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
