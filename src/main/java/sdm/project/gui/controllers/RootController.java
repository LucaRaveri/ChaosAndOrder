package sdm.project.gui.controllers;

import sdm.project.entities.Board;
import sdm.project.entities.Player;
import sdm.project.entities.Symbol;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

//    @FXML private AnchorPane anchorPane;

    @FXML
    private MenuBarController menuBarController;
    @FXML
    private BoardController boardController;
    @FXML
    private SelectorSymbolController selectorSymbolController;

    private Board logicBoard = new Board();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardController.injectRootController(this);
        menuBarController.injectRootController(this);
    }

    public Symbol getSymbol() {
        return selectorSymbolController.getCurrentSymbol();
    }

    public Board getLogicBoard() {
        return logicBoard;
    }

    public void setBoard(Board board) {
        logicBoard = board;
    }

    public void changePlayer() {
        selectorSymbolController.switchCurrentPlayer();
    }

    public void newGame() {
        boardController.toEmptyBoard();
        selectorSymbolController.setCurrentPlayer(Player.ORDER);
    }

    public Player getCurrentPlayer() {
        return selectorSymbolController.getCurrentPlayer();
    }
}
