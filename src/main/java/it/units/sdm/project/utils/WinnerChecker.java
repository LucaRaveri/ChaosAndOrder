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
        return board.isFull();
    }

    private static boolean orderWinCondition(Board board) {
        return checkRows(board) || checkColumns(board) || checkDiagonals(board);
    }

    public static boolean checkRows(Board board) {
        OptionalInt rowNumber = range(0, Board.SIZE).parallel().filter(x -> {
            Supplier<Stream<Cell>> stream = () -> range(0,Board.SIZE).mapToObj(i -> board.getCell(x,i));;
            Supplier<Stream<Cell>> firstFiveElements = () -> stream.get().limit(5);
            Supplier<Stream<Cell>> lastFiveElements = () -> stream.get().skip(1);
            return isAQuintupleCircle(firstFiveElements.get()) ||
                    isAQuintupleCross(firstFiveElements.get()) ||
                    isAQuintupleCircle(lastFiveElements.get()) ||
                    isAQuintupleCross(lastFiveElements.get());
        }).findAny();
        return rowNumber.isPresent();
    }

    public static boolean checkColumns(Board board) {
        OptionalInt columnNumber = range(0, Board.SIZE).parallel().filter(x -> {
            Supplier<Stream<Cell>> stream = () -> range(0,Board.SIZE).mapToObj(i -> board.getCell(i,x));
            Supplier<Stream<Cell>> firstFiveElements = () -> stream.get().limit(5);
            Supplier<Stream<Cell>> lastFiveElements = () -> stream.get().skip(1);
            return isAQuintupleCircle(firstFiveElements.get()) ||
                    isAQuintupleCross(firstFiveElements.get()) ||
                    isAQuintupleCircle(lastFiveElements.get()) ||
                    isAQuintupleCross(lastFiveElements.get());
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
        Supplier<Stream<Cell>> diagonal = () -> range(0,Board.SIZE).mapToObj(i -> board.getCell(i,i));
        Supplier<Stream<Cell>> firstFiveElements = () -> diagonal.get().limit(5);
        if(isAQuintupleCircle(firstFiveElements.get()) || isAQuintupleCross(firstFiveElements.get())) {
            return true;
        }
        Supplier<Stream<Cell>> lastFiveElements = () -> diagonal.get().skip(1);
        if(isAQuintupleCircle(lastFiveElements.get()) || isAQuintupleCross(lastFiveElements.get())) {
            return true;
        }
        return false;
    }

    private static boolean checkSecondaryDiagonal(Board board) {
        Supplier<Stream<Cell>> diagonal = () -> range(0,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-1-i));
        Supplier<Stream<Cell>> firstFiveElements = () -> diagonal.get().limit(5);
        if(isAQuintupleCircle(firstFiveElements.get()) || isAQuintupleCross(firstFiveElements.get())) {
            return true;
        }
        Supplier<Stream<Cell>> lastFiveElements = () -> diagonal.get().skip(1);
        if(isAQuintupleCircle(lastFiveElements.get()) || isAQuintupleCross(lastFiveElements.get())) {
            return true;
        }
        return false;
    }

    private static boolean checkPrimaryUpperDiagonal(Board board) {
        Supplier<Stream<Cell>> shortDiagonal = () -> range(0,Board.SIZE-1).mapToObj(i -> board.getCell(i,i+1));
        if(isAQuintupleCircle(shortDiagonal.get()) || isAQuintupleCross(shortDiagonal.get())) {
            return true;
        }
        return false;
    }

    private static boolean checkPrimaryLowerDiagonal(Board board) {
        Supplier<Stream<Cell>> shortDiagonal = () -> range(1,Board.SIZE).mapToObj(i -> board.getCell(i,i-1));
        if(isAQuintupleCircle(shortDiagonal.get()) || isAQuintupleCross(shortDiagonal.get())) {
            return true;
        }
        return false;
    }

    private static boolean checkSecondaryUpperDiagonal(Board board) {
        Supplier<Stream<Cell>> shortDiagonal = () -> range(1,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-i));
        if(isAQuintupleCircle(shortDiagonal.get()) || isAQuintupleCross(shortDiagonal.get())) {
            return true;
        }
        return false;
    }

    private static boolean checkSecondaryLowerDiagonal(Board board) {
        Supplier<Stream<Cell>> shortDiagonal = () -> range(0,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-i-2));
        if(isAQuintupleCircle(shortDiagonal.get()) || isAQuintupleCross(shortDiagonal.get())) {
            return true;
        }
        return false;
    }

    public static boolean isAQuintupleCircle(Stream<Cell> cells) {
        return  cells.allMatch(c -> c.getSymbol() == Symbol.CIRCLE);
    }

    public static boolean isAQuintupleCross(Stream<Cell> cells) {
        return  cells.allMatch(c -> c.getSymbol() == Symbol.CROSS);
    }
}