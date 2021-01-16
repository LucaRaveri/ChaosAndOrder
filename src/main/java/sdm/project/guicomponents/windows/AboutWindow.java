package sdm.project.guicomponents.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AboutWindow {

    public void display() {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/About.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
                if (!isFocused) stage.close();
            });

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
