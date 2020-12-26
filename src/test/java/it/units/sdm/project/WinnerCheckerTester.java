package it.units.sdm.project;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.utils.WinnerChecker;
import it.units.sdm.project.exceptions.TakenCellException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class WinnerCheckerTester {

    @ParameterizedTest
    @CsvSource({"1, 1", "0, 0", "5, 1"})
    void testCheckRaw(int raw, int column) throws TakenCellException {
        Board board = new Board();
        horizontalQuintupleFiller(board, raw, column);
        assertEquals(true, WinnerChecker.checkRows(board));
    }

    void horizontalQuintupleFiller(Board board, int raw, int column) throws TakenCellException {
        for (int i = 0; i < 5; i++) {
            board.addSymbol(raw, column + i, Symbol.CIRCLE);
        }
    }

    @Test
    void testNewCheckerRaws() {
        Board board = new Board();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                board.getCell(i, j).setSymbol(Symbol.CROSS);
            }
        }
        assertEquals(true, WinnerChecker.checkRows(board));
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
        assertEquals(true, WinnerChecker.checkGoingToDownDiagonals(board));
        board.getCell(row+2, column+2).setSymbol(Symbol.CROSS);
        assertEquals(false, WinnerChecker.checkGoingToDownDiagonals(board));
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
        assertEquals(true, WinnerChecker.checkGoingToUpDiagonals(board));
        board.getCell(row-2, column+2).setSymbol(Symbol.CROSS);
        assertEquals(false, WinnerChecker.checkGoingToUpDiagonals(board));
    }


    @ParameterizedTest
    @CsvSource({"0, 0", "1, 5", "1,1"})
    void testCheckColumn(int raw, int column) throws TakenCellException {
        Board board = new Board();
        verticalQuintupleFiller(board, raw, column);
        assertFalse(WinnerChecker.getWinnerRole(board).isEmpty());
    }

    void verticalQuintupleFiller(Board board, int raw, int column) throws TakenCellException {
        for (int i = 0; i < 5; i++) {
            board.addSymbol(raw + i, column, Symbol.CIRCLE);
        }
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 0", "1, 1"})
    void testCheckPrimaryDiag(int raw, int column) throws TakenCellException {
        Board board = new Board();
        primaryDiagQuintupleFiller(board, raw, column);
        assertFalse(WinnerChecker.getWinnerRole(board).isEmpty());
    }

    void primaryDiagQuintupleFiller(Board board, int raw, int column) throws TakenCellException {
        for (int i = 0; i < 5; i++) {
            board.addSymbol(raw + i, column + i, Symbol.CIRCLE);
        }
    }

    @ParameterizedTest
    @CsvSource({"5, 0", "4, 1", "5, 1"})
    void testCheckSecondaryDiag(int raw, int column) throws TakenCellException {
        Board board = new Board();
        secondaryDiagQuintupleFiller(board, raw, column);
        assertFalse(WinnerChecker.getWinnerRole(board).isEmpty());
    }

    void secondaryDiagQuintupleFiller(Board board, int raw, int column) throws TakenCellException {
        for (int i = 0; i < 5; i++) {
            board.addSymbol(raw - i, column + i, Symbol.CIRCLE);
        }
    }

}


