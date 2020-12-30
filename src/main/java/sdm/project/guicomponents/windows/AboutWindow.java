package sdm.project.guicomponents.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AboutWindow {


    public void display(){
        Parent root = null;
        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.setResizable(false);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/About.fxml"));
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root, Color.web("0x4D4D4D"));
        scene.getStylesheets().add("/css/light-theme.css");
        stage.setScene(scene);

        stage.focusedProperty().addListener((observable, wasFocused, isFocused) -> {
            if(!isFocused) stage.close();
        });
        stage.show();
    }

}
