package sdm.project.guicomponents.controllers;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import sdm.project.core.entities.Board;
import sdm.project.core.entities.Move;
import sdm.project.core.entities.Player;
import sdm.project.core.entities.Symbol;
import sdm.project.core.exceptions.TakenCellException;
import sdm.project.guicomponents.imageviews.CircleImageView;
import sdm.project.guicomponents.imageviews.CrossImageView;
import sdm.project.guicomponents.windows.EndGameWindow;
import sdm.project.core.utils.WinnerChecker;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class BoardController implements Initializable {

    @FXML
    GridPane graphicBoard;

    RootController rootController;
    MediaPlayer mediaPlayer;
    ScaleTransition animation;

    {
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/sounds/pop.mp3").toString()));

        animation = new ScaleTransition(Duration.seconds(0.3));
        animation.setFromX(0);
        animation.setFromY(0);
        animation.setToX(1);
        animation.setToY(1);
    }

    public void injectRootController(RootController rootController) {
        this.rootController = rootController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        IntStream.range(0, Board.SIZE).forEach(row -> {
            IntStream.range(0, Board.SIZE).forEach(column -> {
                StackPane cell = new StackPane();
                GridPane.setConstraints(cell, row, column);
                cell.setPrefSize(80, 80);
                cell.getStyleClass().add("cell");
                cell.setOnMouseClicked(event -> {
                    try {
                        makeMove(cell, rootController.getSymbol());
                    } catch (TakenCellException e) {
                        System.out.println(e.getMessage());
                    }
                });
                graphicBoard.add(cell, row, column);
            });
        });

    }

    private void makeMove(StackPane cell, Symbol symbol) throws TakenCellException {

        ImageView symbolIcon = (symbol == Symbol.CIRCLE) ? new CircleImageView() : new CrossImageView();

        animation.setNode(symbolIcon);
        mediaPlayer.seek(Duration.ZERO);

        mediaPlayer.play();
        animation.play();

        cell.getChildren().add(symbolIcon);
        cell.setDisable(true);
        rootController.getLogicBoard().insert(new Move(GridPane.getRowIndex(cell), GridPane.getColumnIndex(cell), symbol));

        if (WinnerChecker.getWinnerRole(rootController.getLogicBoard()) != null) {
            graphicBoard.getChildren().stream().filter(Predicate.not(Node::isDisabled)).forEach(pane -> pane.setDisable(true));
            EndGameWindow endGameWindow = new EndGameWindow(WinnerChecker.getWinnerRole(rootController.getLogicBoard()));
            endGameWindow.display();
        } else {
            rootController.changePlayer();
        }
    }

    public void toEmptyBoard() {
        rootController.setBoard(new Board());
        initialize(null, null);
    }

}
