package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.exceptions.TakenCellException;
import it.units.sdm.project.gui.windows.EndGameWindow;
import it.units.sdm.project.utils.WinnerChecker;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    GridPane board;

    RootController rootController;
    StackPane[][] cells = new StackPane[6][6];
    Image cross;
    Image circle;
    MediaPlayer mediaPlayer;
    ScaleTransition scaleTransition;

    {
        cross = new Image(getClass().getResourceAsStream("/images/cross.png"));
        circle = new Image(getClass().getResourceAsStream("/images/circle.png"));

        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/sounds/pop.mp3").toString()));

        scaleTransition = new ScaleTransition(Duration.seconds(0.3));
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        board.getStyleClass().add("grid");

//        Stream<StackPane> cellStream = Arrays.stream(cells).flatMap(Arrays::stream);
//        cellStream.forEach(cell -> {
//            cell = new StackPane();
//            cell.setPrefWidth(80);
//            cell.setPrefHeight(80);
//            cell.getStyleClass().add("cell");
//            final StackPane finalCell = cell;
//            cell.setOnMouseClicked(event -> {
//                try {
//                    makeMove(finalCell, rootController.getSymbol());
//                } catch (TakenCellException e) {
//                    e.getMessage();
//                }
//            });
//        });



        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                final int row, column;
                row = i;
                column = j;
                cells[i][j] = new StackPane();
                cells[i][j].setPrefHeight(80);
                cells[i][j].setPrefWidth(80);
                cells[i][j].getStyleClass().add("cell");
                cells[i][j].setOnMouseClicked(event -> {
                    try {
                        makeMove(cells[row][column], rootController.getSymbol());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                });
                board.add(cells[i][j], i, j);
            }
        }

    }

    private void makeMove(StackPane cell, Symbol symbol) throws TakenCellException {

        ImageView imageView = new ImageView();
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);


        if (symbol == Symbol.CIRCLE) {
            imageView.setImage(circle);
        } else {
            imageView.setImage(cross);
        }

        scaleTransition.setNode(imageView);
        mediaPlayer.seek(Duration.ZERO);

        mediaPlayer.play();
        scaleTransition.play();

        cell.getChildren().add(imageView);
        cell.setDisable(true);
        rootController.logicBoard.addSymbol(board.getRowIndex(cell), board.getColumnIndex(cell), symbol);

        if (!WinnerChecker.getWinnerRole(rootController.logicBoard).isEmpty()) {
            EndGameWindow endGameWindow = new EndGameWindow(WinnerChecker.getWinnerRole(rootController.logicBoard));
            endGameWindow.show();
        }

        rootController.changePlayer();
    }

    public GridPane getBoard() {
        return board;
    }

    public void injectRootController(RootController rootController) {
        this.rootController = rootController;
    }


}
