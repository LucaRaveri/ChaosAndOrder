package sdm.project;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import sdm.project.entities.Cell;
import sdm.project.entities.Symbol;
import sdm.project.utils.predicates.ContainsQuintuple;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class ContainsQuintupleTester {

    private ContainsQuintuple containsQuintuple = new ContainsQuintuple();
    private Cell[] cells;

    //TODO: Refactoring needed
    @ParameterizedTest
    @CsvSource({"CIRCLE, CROSS", "CROSS, CIRCLE"})
    public void testSixCellsArray(Symbol matchSymbol, Symbol unmatchSymbol) {

        cells = new Cell[6];
        cells = Arrays.stream(cells).map(cell -> cell = new Cell(1, 1)).toArray(Cell[]::new);

        assertFalse(containsQuintuple.test(cells));
        Arrays.stream(cells).forEach(cell -> cell.setSymbol(matchSymbol));
        assertTrue(containsQuintuple.test(cells));

        cells[0].setSymbol(unmatchSymbol);
        assertTrue(containsQuintuple.test(cells));
        cells[0].setSymbol(matchSymbol);

        cells[5].setSymbol(unmatchSymbol);
        assertTrue(containsQuintuple.test(cells));

        cells[3].setSymbol(unmatchSymbol);
        assertFalse(containsQuintuple.test(cells));

    }

    @ParameterizedTest
    @CsvSource({"CIRCLE, CROSS", "CROSS, CIRCLE"})
    public void testFiveCellsArray(Symbol matchSymbol, Symbol unmatchSymbol) {

        cells = new Cell[5];
        cells = Arrays.stream(cells).map(cell -> cell = new Cell(1, 1)).toArray(Cell[]::new);

        assertFalse(containsQuintuple.test(cells));
        Arrays.stream(cells).forEach(cell -> cell.setSymbol(matchSymbol));
        assertTrue(containsQuintuple.test(cells));

        cells[3].setSymbol(unmatchSymbol);
        assertFalse(containsQuintuple.test(cells));

    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 7, 10})
    public void testNotFiveAndNotSixCellsArray(int length) {
        cells = new Cell[length];
        cells = Arrays.stream(cells).map(cell -> cell = new Cell(2, 4)).toArray(Cell[]::new);
        assertFalse(containsQuintuple.test(cells));
    }

}
