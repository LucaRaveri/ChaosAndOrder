package sdm.project.guicomponents.windows;

import javafx.stage.StageStyle;
import sdm.project.core.utils.GameMessages;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InstructionsWindow extends Stage {

    public InstructionsWindow() {
        super(StageStyle.UNDECORATED);
        setResizable(false);
        setTitle("Chaos & Order Instructions");
        getIcons().add(new Image(getClass().getResourceAsStream("/images/application_icon.png")));

        focusedProperty().addListener((observable, wasFocused, isFocused) -> {
            if(isFocused==false) close();
        });


        Label label = new Label();
        label.setText(GameMessages.INTRO);
        label.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Baby_Girl.otf"), 20));

        StackPane layout = new StackPane();
        layout.getChildren().add(label);

        Scene scene = new Scene(layout, 700, 300);
        setScene(scene);
        scene.setOnMouseClicked(event1 -> close());

    }


}
