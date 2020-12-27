package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Move;
import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.exceptions.TakenCellException;
import it.units.sdm.project.gui.imageviews.CircleImageView;
import it.units.sdm.project.gui.imageviews.CrossImageView;
import it.units.sdm.project.gui.windows.EndGameWindow;
import it.units.sdm.project.utils.WinnerChecker;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
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

        // TODO: introducing unordered()?
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
            EndGameWindow endGameWindow = new EndGameWindow(rootController.getCurrentPlayer());
            endGameWindow.show();
        } else {
            rootController.changePlayer();
        }

    }

    public void toEmptyBoard() {

        rootController.setBoard(new Board());
        initialize(null, null);

//        Collection<Node> cells = graphicBoard.getChildren()
//                .stream()
//                .filter(cell -> cell instanceof StackPane) //TODO: discuss if it is worth to keep it
//                .peek(cell -> ((StackPane) cell).getChildren().removeAll(((StackPane) cell).getChildren()))
//                .collect(Collectors.toCollection(FXCollections::observableSet));
//
//        graphicBoard.getChildren().removeAll(graphicBoard.getChildren());
//        graphicBoard.getChildren().addAll(cells);
    }

}
