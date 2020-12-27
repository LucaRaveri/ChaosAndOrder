package it.units.sdm.project.gui.windows;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InstructionsWindow extends Stage {

    private static String INSTRUCTIONS = "Order and Chaos is a tic-tac-toe variant, played on a 6x6 game board.\n" +
            "The player Order strives to create a five-in-a-row of either Xs or Os,\n" +
            "while opponent Chaos endeavors to prevent this. Order moves first.\n";

    public InstructionsWindow() {
        super();
        setTitle("Chaos & Order Instructions");
        getIcons().add(new Image(getClass().getResourceAsStream("/images/application_icon.png")));
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        Label label = new Label();
        label.setText(INSTRUCTIONS);
        label.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Baby_Girl.otf"), 20));


        StackPane layout = new StackPane();
        layout.getChildren().add(label);

        setScene(new Scene(layout, 700, 300));


    }


}
