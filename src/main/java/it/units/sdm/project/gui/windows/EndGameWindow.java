package it.units.sdm.project.gui.windows;

import it.units.sdm.project.entities.Player;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class EndGameWindow extends Stage {


    public EndGameWindow(Player player) {

        super();
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        Label label = new Label();
        label.setText("Player " + player.name() + " wins!");

        if (player == Player.CHAOS) {
            label.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Paint_Drops.ttf"), 40));
        }

        StackPane layout = new StackPane();
        layout.getChildren().add(label);

        setScene(new Scene(layout, 500, 200));


    }

}
