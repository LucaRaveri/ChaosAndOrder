package it.units.sdm.project;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.exceptions.TakenCellException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTester {

    @ParameterizedTest
    @CsvSource({"1, 1, CIRCLE, CROSS", "2, 5, CIRCLE, CIRCLE", "3, 5, CROSS, CROSS", "4, 3, CIRCLE, CROSS"})
    void testAddSymbol(int x, int y, Symbol symbol1, Symbol symbol2) {
        Board board = new Board();
        TakenCellException thrown = assertThrows(
                TakenCellException.class,
                () -> {
                    board.addSymbol(x, y, symbol1);
                    board.addSymbol(x, y, symbol2);
                });
    }

    @Test
    void testBoardIsFull() throws TakenCellException {
        Board board = new Board();
        fillBoard(board);
        assertEquals(true, board.isFull());
    }

    void fillBoard(Board board) throws TakenCellException {
        for (int raw = 1; raw <= board.SIZE; raw++) {
            for (int column = 1; column <= board.SIZE; column++) {
                board.addSymbol(raw, column, Symbol.CIRCLE);
            }
        }
    }


}


