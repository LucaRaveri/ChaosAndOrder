package sdm.project;

import sdm.project.entities.Board;
import sdm.project.entities.Move;
import sdm.project.entities.Player;
import sdm.project.entities.Symbol;
import sdm.project.utils.WinnerChecker;
import sdm.project.exceptions.TakenCellException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WinnerCheckerTester {

   private Board board = new Board();

    @ParameterizedTest
    @CsvSource({"1, 1", "0, 0", "5, 1"})
    void testCheckRow(int row, int column) throws TakenCellException {
        horizontalQuintupleFiller(board, row, column);
        assertEquals(Player.ORDER, WinnerChecker.getWinnerRole(board));
    }

    void horizontalQuintupleFiller(Board board, int row, int column) throws TakenCellException {
        for (int i = 0; i < 5; i++) {
            board.insert(new Move(row, column + i, Symbol.CIRCLE));
        }
    }

    @Test
    void testNewCheckerRows() {
        Board board = new Board();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                board.getCell(i, j).setSymbol(Symbol.CROSS);
            }
        }
        assertEquals(Player.ORDER, WinnerChecker.getWinnerRole(board));
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 0", "0, 1"})
    void testCheckGoingToDownDiagonals(int row, int column){
        Board board = new Board();
        board.getCell(row, column).setSymbol(Symbol.CIRCLE);
        board.getCell(row+1, column+1).setSymbol(Symbol.CIRCLE);
        board.getCell(row+2, column+2).setSymbol(Symbol.CIRCLE);
        board.getCell(row+3, column+3).setSymbol(Symbol.CIRCLE);
        board.getCell(row+4, column+4).setSymbol(Symbol.CIRCLE);
        assertEquals(Player.ORDER, WinnerChecker.getWinnerRole(board));
        board.getCell(row+2, column+2).setSymbol(Symbol.CROSS);
        assertNull(WinnerChecker.getWinnerRole(board));
    }

    @ParameterizedTest
    @CsvSource({"5, 0", "4, 0", "5, 1"})
    void testCheckGoingToUpDiagonals(int row, int column){
        Board board = new Board();
        board.getCell(row, column).setSymbol(Symbol.CIRCLE);
        board.getCell(row-1, column+1).setSymbol(Symbol.CIRCLE);
        board.getCell(row-2, column+2).setSymbol(Symbol.CIRCLE);
        board.getCell(row-3, column+3).setSymbol(Symbol.CIRCLE);
        board.getCell(row-4, column+4).setSymbol(Symbol.CIRCLE);
        assertEquals(Player.ORDER, WinnerChecker.getWinnerRole(board));
        board.getCell(row-2, column+2).setSymbol(Symbol.CROSS);
        assertNull( WinnerChecker.getWinnerRole(board));
    }


    @ParameterizedTest
    @CsvSource({"0, 0", "1, 5", "1,1"})
    void testCheckColumn(int row, int column) throws TakenCellException {
        Board board = new Board();
        verticalQuintupleFiller(board, row, column);
        assertEquals(Player.ORDER, WinnerChecker.getWinnerRole(board));
    }

    void verticalQuintupleFiller(Board board, int row, int column) throws TakenCellException {
        for (int i = 0; i < 5; i++) {
            board.insert(new Move(row + i, column, Symbol.CIRCLE));
        }
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 0", "1, 1"})
    void testCheckPrimaryDiag(int row, int column) throws TakenCellException {
        Board board = new Board();
        primaryDiagQuintupleFiller(board, row, column);
        assertEquals(Player.ORDER, WinnerChecker.getWinnerRole(board));
    }

    void primaryDiagQuintupleFiller(Board board, int row, int column) throws TakenCellException {
        for (int i = 0; i < 5; i++) {
            board.insert(new Move(row + i, column + i, Symbol.CIRCLE));
        }
    }

    @ParameterizedTest
    @CsvSource({"5, 0", "4, 1", "5, 1"})
    void testCheckSecondaryDiag(int row, int column) throws TakenCellException {
        Board board = new Board();
        secondaryDiagQuintupleFiller(board, row, column);
        assertEquals(Player.ORDER, WinnerChecker.getWinnerRole(board));
    }

    void secondaryDiagQuintupleFiller(Board board, int row, int column) throws TakenCellException {
        for (int i = 0; i < 5; i++) {
            board.insert(new Move(row - i, column + i, Symbol.CIRCLE));
        }
    }

}


