package sdm.project.utils.predicates;

import sdm.project.entities.Cell;
import sdm.project.entities.Symbol;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ContainsQuintuple implements Predicate<Cell[]> {

    @Override
    public boolean test(Cell[] cells) {

        Supplier<Stream<Cell>> cellsStream = () -> Arrays.stream(cells);

        switch (cells.length){

            case 6:
                boolean firstFiveMatch = Arrays.stream(Symbol.values())
                        .anyMatch(symbol -> cellsStream.get().limit(5).allMatch(cell -> cell.getSymbol() == symbol));
                boolean lastFiveMatch = Arrays.stream(Symbol.values())
                        .anyMatch(symbol -> cellsStream.get().skip(1).allMatch(cell -> cell.getSymbol() == symbol));
                return firstFiveMatch || lastFiveMatch;

            case 5:
                return Arrays.stream(Symbol.values())
                        .anyMatch(symbol -> cellsStream.get().allMatch(cell -> cell.getSymbol() == symbol));
            default:
                return false;
        }

    }

}
