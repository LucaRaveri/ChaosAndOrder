package sdm.project;

import org.junit.jupiter.params.provider.ValueSource;
import sdm.project.core.entities.Board;
import sdm.project.core.entities.Player;
import sdm.project.core.entities.Symbol;
import sdm.project.core.utils.WinnerChecker;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WinnerCheckerTester {

    private final Board board = new Board();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    public void testCheckRow(int row) {
        board.getCells().stream().filter(cell -> cell.getRow() == row).forEach(cell -> cell.setSymbol(Symbol.CIRCLE));
        assertEquals(Player.ORDER, WinnerChecker.getWinnerRole(board));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    public void testCheckColumn(int column) {
        board.getCells().stream().filter(cell -> cell.getColumn() == column).forEach(cell -> cell.setSymbol(Symbol.CROSS));
        assertEquals(Player.ORDER, WinnerChecker.getWinnerRole(board));
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void testCheckGoingToDownDiagonals(int index) {
        board.getCells().stream().filter(cell -> cell.getRow() == cell.getColumn() + index).forEach(cell -> cell.setSymbol(Symbol.CIRCLE));
        assertNotNull(WinnerChecker.getWinnerRole(board));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    public void testCheckGoingToUpDiagonals(int sum) {
        board.getCells().stream().filter(cell -> cell.getRow() + cell.getColumn() == sum).forEach(cell -> cell.setSymbol(Symbol.CROSS));
        assertNotNull(WinnerChecker.getWinnerRole(board));
    }


}


