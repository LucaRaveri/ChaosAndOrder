package sdm.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sdm.project.core.entities.Board;
import sdm.project.core.entities.Move;
import sdm.project.core.entities.Symbol;
import sdm.project.core.exceptions.TakenCellException;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTester {

    private final Board board = new Board();

    @ParameterizedTest
    @CsvSource({"1, 1, CIRCLE, CROSS", "2, 5, CIRCLE, CIRCLE", "3, 5, CROSS, CROSS", "4, 3, CIRCLE, CROSS"})
    public void testTakenCellException(int x, int y, Symbol symbol1, Symbol symbol2) {
        assertThrows(TakenCellException.class, () -> {
            board.insert(new Move(x, y, symbol1));
            board.insert(new Move(x, y, symbol2));
        });
    }

     @ParameterizedTest
     @CsvSource({"1, 4, CROSS", "0, 3, CIRCLE", "5, 5, CROSS"})
     public void testMove(int row, int column, Symbol symbol) throws TakenCellException {
        board.insert(new Move(row, column, symbol));
         assertSame(board.getCell(row, column).getSymbol(), symbol);
     }

    @Test
    public void testBoardIsFull() {
        fillBoard(board, true);
        assertTrue(board.isFull());
    }

    @Test
    public void testBoardIsNotFull(){
        fillBoard(board, false);
        assertFalse(board.isFull());
    }

    private void fillBoard(Board board, boolean totally) {
        if (totally) board.getCells().stream().forEach(cell -> cell.setSymbol(Symbol.CIRCLE));
        else board.getCells().stream().filter(cell -> cell.getColumn() == 2).forEach(cell -> cell.setSymbol(Symbol.CROSS));
    }

}


