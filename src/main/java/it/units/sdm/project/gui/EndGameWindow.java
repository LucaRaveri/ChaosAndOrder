package it.units.sdm.project.gui;

import it.units.sdm.project.entities.Role;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class EndGameWindow extends Stage{


    public EndGameWindow(Role role){

        super();
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        StackPane layout = new StackPane();
        layout.getChildren().add(new Label("Player " + role.name() + " wins!"));

        setScene(new Scene(layout, 300, 300));


    }

}
