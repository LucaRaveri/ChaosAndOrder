package sdm.project.guicomponents.controllers.mainwindow;

import sdm.project.core.entities.Board;
import sdm.project.core.entities.Player;
import sdm.project.core.entities.Symbol;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sdm.project.core.utils.WinnerChecker;
import sdm.project.guicomponents.windows.EndGameWindow;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML private MenuBarController menuBarController;
    @FXML private BoardController boardController;
    @FXML private SelectorSymbolController selectorSymbolController;

    private Board logicBoard = new Board();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBarController.injectRootController(this);
        boardController.injectRootController(this);
    }

    public Symbol getSymbol() {
        return selectorSymbolController.getCurrentSymbol();
    }

    public void setBoard(Board board) {
        logicBoard = board;
    }

    public void changePlayer() {
        selectorSymbolController.switchCurrentPlayer();
    }

    public void newGame() {
        boardController.reinitializeBoard();
        selectorSymbolController.setCurrentPlayer(Player.ORDER);
    }

    public void makeMove(int row, int column, Symbol symbol){
        logicBoard.getCell(row, column).setSymbol(symbol);
        WinnerChecker.setBoard(logicBoard);

        if (WinnerChecker.getWinnerRole() != null) {
            boardController.disableEnabledCells();
            EndGameWindow endGameWindow = new EndGameWindow();
            endGameWindow.display(WinnerChecker.getWinnerRole());
        } else {
            changePlayer();
        }
    }

}
