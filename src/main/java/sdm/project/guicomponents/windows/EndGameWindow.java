package sdm.project.guicomponents.windows;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sdm.project.core.entities.Player;


public class EndGameWindow {

    private Player winner;
    private Label label;
    private Button newGameButton;
    private ImageView imageView;

    {
        label = new Label();
        imageView= new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        newGameButton = new Button("New Game");
    }

    public EndGameWindow(Player winner) {
        this.winner = winner;
        label.setText("The winner is " + winner.name());
        imageView.setImage(winner == Player.ORDER ? new Image("/images/Order.png") : new Image("/images/Chaos.png"));
    }

    public void display() {

        Stage secondaryStage = new Stage();
        secondaryStage.initModality(Modality.APPLICATION_MODAL);
        secondaryStage.setTitle("There is a winner!");
        secondaryStage.setResizable(false);

        StackPane layout = new StackPane();
        layout.getChildren().add(label);

        StackPane.setAlignment(imageView, Pos.CENTER_RIGHT);
        StackPane.setAlignment(label, Pos.CENTER_LEFT);
        StackPane.setMargin(imageView, new Insets(10, 10, 10, 10));

        layout.getChildren().add(imageView);

        Scene scene = new Scene(layout, 500, 200);
        secondaryStage.setScene(scene);
        secondaryStage.showAndWait();
    }

}
