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
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

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

        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                StackPane cell = new StackPane();
                GridPane.setRowIndex(cell, i);
                GridPane.setColumnIndex(cell, j);
                cell.setPrefHeight(80);
                cell.setPrefWidth(80);
                cell.getStyleClass().add("cell");
                cell.setOnMouseClicked(event -> {
                    try {
                        makeMove(cell, rootController.getSymbol());
                    } catch (TakenCellException e) {
                        System.out.println(e.getMessage());
                    }
                });
                graphicBoard.add(cell, i, j);
            }
        }
    }

    private void makeMove(StackPane cell, Symbol symbol) throws TakenCellException {

        ImageView symbolIcon = (symbol == Symbol.CIRCLE) ? new CircleImageView() : new CrossImageView();

        animation.setNode(symbolIcon);
        mediaPlayer.seek(Duration.ZERO);

        mediaPlayer.play();
        animation.play();

        cell.getChildren().add(symbolIcon);
        cell.setDisable(true);
        rootController.logicBoard.insert(new Move(graphicBoard.getRowIndex(cell), graphicBoard.getColumnIndex(cell), symbol));

        if (WinnerChecker.getWinnerRole(rootController.logicBoard) != null) {
            EndGameWindow endGameWindow = new EndGameWindow(WinnerChecker.getWinnerRole(rootController.logicBoard));
            endGameWindow.show();
        }

        rootController.changePlayer();
    }

    public void toEmptyBoard() {

//        cells = cells.stream().peek(cell -> {
//            if (cell.isDisable()) cell.getChildren().removeAll(cell.getChildren());
//        }).collect(Collectors.toSet());

        Collection<Node> cells = graphicBoard.getChildren()
                .stream()
//                .filter(cell -> cell instanceof StackPane)
                .peek(cell -> ((StackPane) cell).getChildren().removeAll(((StackPane) cell).getChildren()))
                .collect(Collectors.toCollection(FXCollections::observableSet));

        graphicBoard.getChildren().removeAll(graphicBoard.getChildren());
        graphicBoard.getChildren().addAll(cells);
    }

}
