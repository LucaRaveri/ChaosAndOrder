package it.units.sdm.project.gui.windows;

import it.units.sdm.project.utils.GameMessages;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InstructionsWindow extends Stage {

    public InstructionsWindow() {
        super();
        setTitle("Chaos & Order Instructions");
        getIcons().add(new Image(getClass().getResourceAsStream("/images/application_icon.png")));
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        Label label = new Label();
        label.setText(GameMessages.INTRO);
        label.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Baby_Girl.otf"), 20));

        StackPane layout = new StackPane();
        layout.getChildren().add(label);

        setScene(new Scene(layout, 700, 300));

    }


}
