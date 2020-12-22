package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.exceptions.TakenCellException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    GridPane board;

    RootController rootController;
    StackPane[][] cells = new StackPane[6][6];
    Image cross = new Image(getClass().getResourceAsStream("/cross.png"));
    Image circle =new Image(getClass().getResourceAsStream("/circle.png"));


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AnchorPane.setBottomAnchor(anchorPane, 0.0);
        AnchorPane.setLeftAnchor(anchorPane, 120.0);
        AnchorPane.setBottomAnchor(board, 50.0);

//        board.setGridLinesVisible(true);
        board.getStyleClass().add("grid");

//        cross.setFitWidth(50);
//        cross.setFitHeight(50);
//        circle.setFitHeight(50);
//        circle.setFitWidth(50);

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
            cells[i][j].getChildren().add(imageView);
            cells[i][j].setDisable(true);
            rootController.logicBoard.addSymbol(i, j, symbol);
        } else if (symbol == Symbol.CROSS) {
            ImageView imageView = new ImageView(cross);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);
            cells[i][j].getChildren().add(imageView);
            cells[i][j].setDisable(true);
            rootController.logicBoard.addSymbol(i, j, symbol);
        }

    }


    public void injectRootController(RootController rootController) {
        this.rootController = rootController;
    }
}
