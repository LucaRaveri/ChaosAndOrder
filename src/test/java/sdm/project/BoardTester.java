package sdm.project;

import sdm.project.entities.Board;
import sdm.project.entities.Move;
import sdm.project.entities.Symbol;
import sdm.project.exceptions.TakenCellException;
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
                    board.insert(new Move(x, y, symbol1));
                    board.insert(new Move(x, y, symbol2));
                });
    }

    @Test
    void testBoardIsFull() throws TakenCellException {
        Board board = new Board();
        fillBoard(board);
        assertEquals(true, board.isFull());
    }

    @Test
    void testBoardIsNotFull() throws TakenCellException {
        Board board = new Board();
        partiallyFillBoard(board);
        assertEquals(false, board.isFull());

    }

    void fillBoard(Board board) throws TakenCellException {
        for (int raw = 0; raw < board.SIZE; raw++) {
            for (int column = 0; column < board.SIZE; column++) {
                board.insert(new Move(raw, column, Symbol.CIRCLE));
            }
        }
    }

    void partiallyFillBoard(Board board) throws TakenCellException {
        board.insert(new Move(2, 5, Symbol.CIRCLE));
        board.insert(new Move(5, 2, Symbol.CIRCLE));
        board.insert(new Move(1, 1, Symbol.CROSS));
    }

}


