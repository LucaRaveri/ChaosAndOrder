package sdm.project.core.utils.predicates;

import sdm.project.core.entities.Cell;
import sdm.project.core.entities.Symbol;

import java.util.Arrays;
import java.util.function.Predicate;

public class ContainsQuintuple implements Predicate<Cell[]> {

    @Override
    public boolean test(Cell[] cells) {

        if(cells.length == 5 || cells.length == 6)
            return firstFiveMatch(cells) || lastFiveMatch(cells);
        else
            return false;

    }

    private boolean firstFiveMatch(Cell[] cells) {
        return Arrays.stream(Symbol.values()).anyMatch(symbol -> Arrays.stream(cells).limit(5).allMatch(cell -> cell.getSymbol() == symbol));
    }

    private boolean lastFiveMatch(Cell[] cells) {
        return Arrays.stream(Symbol.values()).anyMatch(symbol -> Arrays.stream(cells).skip(1).allMatch(cell -> cell.getSymbol() == symbol));
    }

}
