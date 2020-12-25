package it.units.sdm.project.utils.predicates;

import it.units.sdm.project.entities.Cell;
import it.units.sdm.project.entities.Symbol;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ContainsQuintuple implements Predicate<Cell[]> {

    @Override
    public boolean test(Cell[] cells) {

        Supplier<Stream<Cell>> cellsStream = () -> Arrays.stream(cells);

        if (cells.length == 6) {

            boolean firstBool = Arrays.stream(Symbol.values())
                    .filter(symbol -> cellsStream.get().limit(5).allMatch(cell -> cell.getSymbol() == symbol))
                    .findAny().isPresent();

            boolean secondBool = Arrays.stream(Symbol.values())
                    .filter(symbol -> cellsStream.get().skip(1).allMatch(cell -> cell.getSymbol() == symbol))
                    .findAny().isPresent();

            return firstBool || secondBool;

        } else if (cells.length==5){

            boolean thirdBoolean = Arrays.stream(Symbol.values())
                    .filter(symbol -> cellsStream.get().allMatch(cell -> cell.getSymbol() == symbol))
                    .findAny().isPresent();
            return thirdBoolean;
        } else{
            return false;
        }
    }

}
