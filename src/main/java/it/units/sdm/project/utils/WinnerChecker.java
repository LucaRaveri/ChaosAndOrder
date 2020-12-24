package it.units.sdm.project.utils;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Cell;
import it.units.sdm.project.entities.Role;
import it.units.sdm.project.entities.Symbol;

import java.util.OptionalInt;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class WinnerChecker {

    private static final int SIZE_TO_WIN = 5;

    public static boolean thereIsAWinner(Board board) {
        return chaosWinCondition(board) || orderWinCondition(board);
    }

    public static Role getWinnerRole(Board board) {
        if (thereIsAWinner(board)) {
            if (chaosWinCondition(board)) {
                return Role.CHAOS;
            } else {
                return Role.ORDER;
            }
        } else {
            return null;
        }

    }

    private static boolean chaosWinCondition(Board board) {
        return board.isFull() && !orderWinCondition(board);
    }

    private static boolean orderWinCondition(Board board) {
        return checkRows(board) || checkColumns(board) || checkDiagonals(board);
    }


    public static boolean checkRows(Board board) {
        OptionalInt rowNumber = range(0, Board.SIZE).parallel().filter(x ->
        {
            Supplier<Stream<Cell>> stream = () -> board.getCells().stream().filter(c -> c.getRow() == x);
            //() -> range(0,Board.SIZE).mapToObj(i -> board.getCell(x,i));
            return isAQuintupleCircle(stream.get().limit(5)) || isAQuintupleCross(stream.get().limit(5))
                    || isAQuintupleCircle(stream.get().skip(1)) || isAQuintupleCross(stream.get().skip(1));
        }).findAny();
        return rowNumber.isPresent();
    }


    public static boolean checkColumns(Board board) {
        OptionalInt columnNumber = range(0, Board.SIZE).parallel().filter(x ->
        {
            Supplier<Stream<Cell>> stream = () -> board.getCells().stream().filter(c -> c.getColumn() == x);
            //() -> range(0,Board.SIZE).mapToObj(i -> board.getCell(i,x));
            return isAQuintupleCircle(stream.get().limit(5)) || isAQuintupleCross(stream.get().limit(5))
                    || isAQuintupleCircle(stream.get().skip(1)) || isAQuintupleCross(stream.get().skip(1));
        }).findAny();
        return columnNumber.isPresent();
    }

    public static boolean checkDiagonals(Board board) {
        return checkPrimaryDiagonal(board) ||
                checkPrimaryUpperDiagonal(board) ||
                checkPrimaryLowerDiagonal(board) ||
                checkSecondaryDiagonal(board) ||
                checkSecondaryUpperDiagonal(board) ||
                checkSecondaryLowerDiagonal(board);
    }

    private static boolean checkPrimaryDiagonal(Board board) {
        Supplier<Stream<Cell>> LeftToRightDiagonal = () -> range(0, Board.SIZE).mapToObj(i -> board.getCell(i, i)); //parallel()?
        return isAQuintupleCircle(LeftToRightDiagonal.get().limit(5)) || isAQuintupleCross(LeftToRightDiagonal.get().limit(5))
                || isAQuintupleCircle(LeftToRightDiagonal.get().skip(1)) || isAQuintupleCross(LeftToRightDiagonal.get().skip(1));
    }

    private static boolean checkSecondaryDiagonal(Board board) {
        Supplier<Stream<Cell>> RightToLeftDiagonal = () -> range(0, Board.SIZE).mapToObj(i -> board.getCell(i, Board.SIZE-1-i)); //parallel()?
        return isAQuintupleCircle(RightToLeftDiagonal.get().limit(5)) || isAQuintupleCross(RightToLeftDiagonal.get().limit(5))
                || isAQuintupleCircle(RightToLeftDiagonal.get().skip(1)) || isAQuintupleCross(RightToLeftDiagonal.get().skip(1));
    }

    private static boolean checkPrimaryUpperDiagonal(Board board) {
        Supplier<Stream<Cell>> shortDiagonal = () -> range(0,Board.SIZE-1).mapToObj(i -> board.getCell(i,i+1));
        return (isAQuintupleCircle(shortDiagonal.get()) || isAQuintupleCross(shortDiagonal.get()));
    }

    private static boolean checkPrimaryLowerDiagonal(Board board) {
        Supplier<Stream<Cell>> shortDiagonal = () -> range(1,Board.SIZE).mapToObj(i -> board.getCell(i,i-1));
        return (isAQuintupleCircle(shortDiagonal.get()) || isAQuintupleCross(shortDiagonal.get()));
    }

    private static boolean checkSecondaryUpperDiagonal(Board board) {
        Supplier<Stream<Cell>> shortDiagonal = () -> range(1,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-i));
        return (isAQuintupleCircle(shortDiagonal.get()) || isAQuintupleCross(shortDiagonal.get()));
    }

    private static boolean checkSecondaryLowerDiagonal(Board board) {
        Supplier<Stream<Cell>> shortDiagonal = () -> range(0,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-i-2));
        return (isAQuintupleCircle(shortDiagonal.get()) || isAQuintupleCross(shortDiagonal.get()));
    }

    public static boolean isAQuintupleCircle(Stream<Cell> cells) {
        return  cells.allMatch(c -> c.getSymbol() == Symbol.CIRCLE);
    }

    public static boolean isAQuintupleCross(Stream<Cell> cells) {
        return  cells.allMatch(c -> c.getSymbol() == Symbol.CROSS);
    }

/*    public static boolean isQuintuple(Stream<Cell> cells) {
        return isAQuintupleCross(cells) || isAQuintupleCircle(cells);
    }*/
}
