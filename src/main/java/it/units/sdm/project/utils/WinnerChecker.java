package it.units.sdm.project.utils;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Cell;
import it.units.sdm.project.entities.Role;
import it.units.sdm.project.utils.predicates.ContainsQuintuple;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinnerChecker {

    private static ContainsQuintuple containsQuintuple = new ContainsQuintuple();

    public static boolean checkRows(Board board) {
        Stream<Cell[]> rows = IntStream.range(0, Board.SIZE).parallel()
                .mapToObj(row -> board.getCells().stream().filter(cell -> cell.getRow() == row).toArray(Cell[]::new));

        return rows.filter(row -> containsQuintuple.test(row)).findAny().isPresent();

    }

    public static boolean checkColumns(Board board) {
        Stream<Cell[]> columns = IntStream.range(0, Board.SIZE).parallel()
                .mapToObj(column -> board.getCells().stream().filter(cell -> cell.getColumn() == column).toArray(Cell[]::new));

        return columns.filter(column -> containsQuintuple.test(column)).findAny().isPresent();

    }

    //TODO: rename method to be more readable
    public static boolean checkGoingToDownDiagonals(Board board) {

        // the cells in which are interested in have their row index moved by one from their column index or equal to
        Stream<Cell[]> diagonals = IntStream.rangeClosed(-1, 1)
                .parallel()
                .mapToObj(index -> board.getCells()
                        .stream()
                        .filter(cell -> cell.getRow() == cell.getColumn() + index)
                        .toArray(Cell[]::new));

        return diagonals.filter(diagonal -> containsQuintuple.test(diagonal)).findAny().isPresent();

    }

    //TODO: rename method to be more readable
    public static boolean checkGoingToUpDiagonals(Board board) {

        // the cells in which we are interested in have the summation of indexes in the interval [4,6]
        Stream<Cell[]> diagonals = IntStream.rangeClosed(4, 6).parallel()
                .mapToObj(sum -> board.getCells().stream().filter(cell -> cell.getRow() + cell.getColumn() == sum).toArray(Cell[]::new));

        return diagonals.filter(diagonal -> containsQuintuple.test(diagonal)).findAny().isPresent();

    }


    public static Role getWinnerRole(Board board) {

        //TODO: discuss if it is the case to avoid multiple returns
        if (chaosWinCondition(board)) {
            return Role.CHAOS;
        } else if (orderWinCondition(board)) {
            return Role.ORDER;
        } else {
            return null;
        }

    }

    private static boolean chaosWinCondition(Board board) {
        return board.isFull() && !orderWinCondition(board);
    }

    private static boolean orderWinCondition(Board board) {
        return checkRows(board) || checkColumns(board) || checkGoingToDownDiagonals(board) || checkGoingToUpDiagonals(board);
    }

}
