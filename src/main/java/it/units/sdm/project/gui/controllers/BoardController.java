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
    ImageView cross = new ImageView(new Image(getClass().getResourceAsStream("/cross.png")));
    ImageView circle = new ImageView(new Image(getClass().getResourceAsStream("/circle.png")));


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AnchorPane.setBottomAnchor(anchorPane, 0.0);
        AnchorPane.setLeftAnchor(anchorPane, 120.0);
        AnchorPane.setBottomAnchor(board, 50.0);

//        board.setGridLinesVisible(true);
        board.getStyleClass().add("grid");

        cross.setFitWidth(50);
        cross.setFitHeight(50);
        circle.setFitHeight(50);
        circle.setFitWidth(50);

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
//            cells[i][j].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/circle.png"))));
            cells[i][j].getChildren().add(circle);
            cells[i][j].setDisable(true);
            rootController.logicBoard.addSymbol(i, j, symbol);
        } else if (symbol == Symbol.CROSS) {
//            cells[i][j].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/cross.png"))));
//            cells[i][j].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/cross.png"))));
            cells[i][j].getChildren().add(cross);
            cells[i][j].setDisable(true);
            rootController.logicBoard.addSymbol(i, j, symbol);
        }

    }


    public void injectRootController(RootController rootController) {
        this.rootController = rootController;
    }
}
