package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.exceptions.TakenCellException;
import it.units.sdm.project.utils.WinnerChecker;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    GridPane board;

    RootController rootController;
    StackPane[][] cells = new StackPane[6][6];
    Image cross;
    Image circle;
    MediaPlayer mediaPlayer;
    ScaleTransition scaleTransition;

    {
        cross = new Image(getClass().getResourceAsStream("/cross.png"));
        circle = new Image(getClass().getResourceAsStream("/circle.png"));
        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/pop.mp3").toString()));
        mediaPlayer.seek(Duration.ZERO);

        scaleTransition = new ScaleTransition(Duration.seconds(0.3));
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AnchorPane.setBottomAnchor(anchorPane, 0.0);
        AnchorPane.setLeftAnchor(anchorPane, 120.0);
        AnchorPane.setBottomAnchor(board, 50.0);


//        board.setGridLinesVisible(true);
        board.getStyleClass().add("grid");


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
                        makeMove(row, column, rootController.getSymbol());
                    } catch (TakenCellException e) {
                        System.out.println(e.getMessage());
                    }
                });
                board.add(cells[i][j], i, j);
            }
        }

    }

    private void makeMove(int i, int j, Symbol symbol) throws TakenCellException {

        if (symbol == Symbol.CIRCLE) {
            ImageView imageView = new ImageView(circle);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);

            scaleTransition.setNode(imageView);
            mediaPlayer.seek(Duration.ZERO);

            mediaPlayer.play();
            scaleTransition.play();

            cells[i][j].getChildren().add(imageView);
            cells[i][j].setDisable(true);
            rootController.logicBoard.addSymbol(i, j, symbol);
            System.out.println(WinnerChecker.thereIsAWinner(rootController.logicBoard));

        } else if (symbol == Symbol.CROSS) {
            ImageView imageView = new ImageView(cross);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);

            /* add animation */


            mediaPlayer.seek(Duration.ZERO);
            scaleTransition.setNode(imageView);

            mediaPlayer.play();
            scaleTransition.play();


            cells[i][j].getChildren().add(imageView);
            cells[i][j].setDisable(true);
            rootController.logicBoard.addSymbol(i, j, symbol);
            System.out.println(WinnerChecker.thereIsAWinner(rootController.logicBoard));
        }

    }


    public void injectRootController(RootController rootController) {
        this.rootController = rootController;
    }


}
