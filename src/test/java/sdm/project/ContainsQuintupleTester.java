package sdm.project;

import org.junit.jupiter.api.Test;
import sdm.project.entities.Cell;
import sdm.project.entities.Symbol;
import sdm.project.utils.predicates.ContainsQuintuple;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class ContainsQuintupleTester {

    ContainsQuintuple containsQuintuple = new ContainsQuintuple();
    Cell[] cells;


    @Test
    public void testSixCellsArray(){
        cells = new Cell[6];
        cells = Arrays.stream(cells).map(cell -> cell = new Cell(1,1)).toArray(Cell[]::new);
        assertFalse(containsQuintuple.test(cells));
        Arrays.stream(cells).forEach(cell -> cell.setSymbol(Symbol.CROSS));
        assertTrue(containsQuintuple.test(cells));
        cells[0].setSymbol(Symbol.CIRCLE);
        assertTrue(containsQuintuple.test(cells));
        cells[0].setSymbol(Symbol.CROSS);
        cells[5].setSymbol(Symbol.CIRCLE);
        assertTrue(containsQuintuple.test(cells));
        cells[3].setSymbol(Symbol.CIRCLE);
        assertFalse(containsQuintuple.test(cells));

    }


    @Test
    public void testFiveCellsArray(){
        cells = new Cell[5];
        cells = Arrays.stream(cells).map(cell -> cell = new Cell(1,1)).toArray(Cell[]::new);
        assertFalse(containsQuintuple.test(cells));
        Arrays.stream(cells).forEach(cell -> cell.setSymbol(Symbol.CROSS));
        assertTrue(containsQuintuple.test(cells));
        cells[3].setSymbol(Symbol.CIRCLE);
        assertFalse(containsQuintuple.test(cells));

    }

}
