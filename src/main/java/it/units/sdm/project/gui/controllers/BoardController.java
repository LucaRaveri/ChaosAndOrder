package it.units.sdm.project.gui.controllers;

import it.units.sdm.project.entities.Symbol;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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
    Rectangle[][] cells = new Rectangle[6][6];

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AnchorPane.setBottomAnchor(anchorPane, 0.0);
        AnchorPane.setLeftAnchor(anchorPane, 120.0);
        AnchorPane.setBottomAnchor(board, 50.0);

        board.setGridLinesVisible(true);
        board.getStyleClass().add("grid");

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                final int row, column;
                row = i;
                column = j;
                cells[i][j]= new Rectangle();
                cells[i][j].setHeight(80);
                cells[i][j].setWidth(80);
                cells[i][j].setFill(Color.WHITE);
                cells[i][j].setOnMouseClicked(event -> makeMove(row, column, rootController.getSymbol()));
                board.add(cells[i][j], i, j);
            }
        }

    }

    private void makeMove(int i, int j, Symbol symbol) {


        if (symbol == Symbol.CIRCLE) {
            cells[i][j].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/circle.png"))));
        } else {
            cells[i][j].setFill(new ImagePattern(new Image(getClass().getResourceAsStream("/cross.png"))));
        }
        cells[i][j].setDisable(true);
    }


    public void injectRootController(RootController rootController) {
        this.rootController = rootController;
    }
}
