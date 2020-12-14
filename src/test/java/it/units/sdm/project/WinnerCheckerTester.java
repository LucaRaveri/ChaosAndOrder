package it.units.sdm.project;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.entities.WinnerChecker;
import it.units.sdm.project.exceptions.TakenCellException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinnerCheckerTester {

    @ParameterizedTest
    @CsvSource({"1, 1", "0, 0", "5, 1"})
    void testCheckRaw(int raw, int column) throws TakenCellException {
        Board board = new Board();
        horizontalQuintupleFiller(board, raw, column);
        WinnerChecker checker = new WinnerChecker();
        checker.setCurrentBoard(board);
        assertEquals(true, checker.thereIsAWinner());
    }

    void horizontalQuintupleFiller(Board board, int raw, int column) throws TakenCellException {
        for(int i=0; i<5; i++) {
            board.addSymbol(raw +1, column +1 + i, Symbol.CIRCLE);
        }
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 5", "1,1"})
    void testCheckColumn(int raw, int column) throws TakenCellException {
        Board board = new Board();
        verticalQuintupleFiller(board, raw, column);
        WinnerChecker checker = new WinnerChecker();
        checker.setCurrentBoard(board);
        assertEquals(true, checker.thereIsAWinner());
    }

    void verticalQuintupleFiller(Board board, int raw, int column) throws TakenCellException {
        for(int i=0; i<5; i++) {
            board.addSymbol(raw +1 + i, column +1, Symbol.CIRCLE);
        }
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 0", "1, 1"})
    void testCheckPrimaryDiag(int raw, int column) throws TakenCellException {
        Board board = new Board();
        primaryDiagQuintupleFiller(board, raw, column);
        WinnerChecker checker = new WinnerChecker();
        checker.setCurrentBoard(board);
        assertEquals(true, checker.thereIsAWinner());
    }

    void primaryDiagQuintupleFiller(Board board, int raw, int column) throws TakenCellException {
        for(int i=0; i<5; i++) {
            board.addSymbol(raw +1 + i, column +1 + i, Symbol.CIRCLE);
        }
    }

    @ParameterizedTest
    @CsvSource({"5, 0", "4, 1", "5, 1"})
    void testCheckSecondaryDiag(int raw, int column) throws TakenCellException {
        Board board = new Board();
        secondaryDiagQuintupleFiller(board, raw, column);
        WinnerChecker checker = new WinnerChecker();
        checker.setCurrentBoard(board);
        assertEquals(true, checker.thereIsAWinner());
    }

    void secondaryDiagQuintupleFiller(Board board, int raw, int column) throws TakenCellException {
        for(int i=0; i<5; i++) {
            board.addSymbol(raw +1 - i, column +1 + i, Symbol.CIRCLE);
        }
    }

}


