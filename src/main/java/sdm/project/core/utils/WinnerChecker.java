package sdm.project.core.utils;

import sdm.project.core.entities.Board;
import sdm.project.core.entities.Cell;
import sdm.project.core.entities.Player;
import sdm.project.core.utils.predicates.ContainsQuintuple;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinnerChecker {

    private static final ContainsQuintuple containsQuintuple = new ContainsQuintuple();

    private static boolean checkRows(Board board) {

        Stream<Cell[]> rows = IntStream.range(0, Board.SIZE).parallel()
                .mapToObj(row -> board.getCells().stream().filter(cell -> cell.getRow() == row).toArray(Cell[]::new));

        return rows.anyMatch(containsQuintuple);
    }

    private static boolean checkColumns(Board board) {

        Stream<Cell[]> columns = IntStream.range(0, Board.SIZE).parallel()
                .mapToObj(column -> board.getCells().stream().filter(cell -> cell.getColumn() == column).toArray(Cell[]::new));

        return columns.anyMatch(containsQuintuple);

    }

    //TODO: rename method to be more readable
    private static boolean checkGoingToDownDiagonals(Board board) {

        // the cells in which are interested in have their row index moved by one from their column index or equal to
        Stream<Cell[]> diagonals = IntStream.rangeClosed(-1, 1)
                .parallel()
                .mapToObj(index -> board.getCells()
                        .stream()
                        .filter(cell -> cell.getRow() == cell.getColumn() + index)
                        .toArray(Cell[]::new));

        return diagonals.anyMatch(containsQuintuple);

    }

    //TODO: rename method to be more readable
    private static boolean checkGoingToUpDiagonals(Board board) {

        // the cells in which we are interested in have the summation of indexes in the interval [4,6]
        Stream<Cell[]> diagonals = IntStream.rangeClosed(4, 6).parallel()
                .mapToObj(sum -> board.getCells().stream().filter(cell -> cell.getRow() + cell.getColumn() == sum).toArray(Cell[]::new));

        return diagonals.anyMatch(containsQuintuple);

    }


    public static Player getWinnerRole(Board board) {

        //TODO: discuss if it is the case to avoid multiple returns
        if (chaosWinCondition(board)) {
            return Player.CHAOS;
        } else if (orderWinCondition(board)) {
            return Player.ORDER;
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
