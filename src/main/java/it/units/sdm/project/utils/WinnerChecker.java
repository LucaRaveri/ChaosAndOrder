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

    // TODO: Refactor -> eliminate code duplication
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

    // ---------------------------------------------------------------------------------------------------------------

    public static Stream<Cell> pickPrimaryDiagonal(Board board){
        return range(0,Board.SIZE).mapToObj(i -> board.getCell(i,i));
    }

    public static Stream<Cell> pickPrimaryUpperDiagonal(Board board){
        return range(0,Board.SIZE-1).mapToObj(i -> board.getCell(i,i+1));
    }

    public static Stream<Cell> pickPrimaryLowerDiagonal(Board board){
        return range(1,Board.SIZE).mapToObj(i -> board.getCell(i,i-1));
    }

    public static Stream<Cell> pickSecondaryDiagonal(Board board){
        return range(0,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-1-i));
    }

    public static Stream<Cell> pickSecondaryUpperDiagonal(Board board){
        return range(1,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-i));
    }

    public static Stream<Cell> pickSecondaryLowerDiagonal(Board board){
        return range(0,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-i-2));
    }

    private static boolean checkDiagonals(Board board) {
        Supplier<Stream<Cell>> stream1 = () -> pickSecondaryDiagonal(board);
        Supplier<Stream<Cell>> firstFiveElements1 = () -> stream1.get().limit(5);
        if(isAQuintupleCircle(firstFiveElements1.get()) || isAQuintupleCross(firstFiveElements1.get())) {
            return true;
        }
        Supplier<Stream<Cell>> lastFiveElements1 = () -> stream1.get().skip(1);
        if(isAQuintupleCircle(lastFiveElements1.get()) || isAQuintupleCross(lastFiveElements1.get())) {
            return true;
        }
        // ...code duplication
        Supplier<Stream<Cell>> stream2 = () -> pickPrimaryDiagonal(board);
        Supplier<Stream<Cell>> firstFiveElements2 = () -> stream2.get().limit(5);
        if(isAQuintupleCircle(firstFiveElements2.get()) || isAQuintupleCross(firstFiveElements2.get())) {
            return true;
        }
        Supplier<Stream<Cell>> lastFiveElements2 = () -> stream2.get().skip(1);
        if(isAQuintupleCircle(lastFiveElements2.get()) || isAQuintupleCross(lastFiveElements2.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream3 = () -> pickPrimaryUpperDiagonal(board);
        if(isAQuintupleCircle(stream3.get()) || isAQuintupleCross(stream3.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream4 = () -> pickPrimaryLowerDiagonal(board);
        if(isAQuintupleCircle(stream4.get()) || isAQuintupleCross(stream4.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream5 = () -> pickSecondaryUpperDiagonal(board);
        if(isAQuintupleCircle(stream5.get()) || isAQuintupleCross(stream5.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream6 = () -> pickSecondaryLowerDiagonal(board);
        if(isAQuintupleCircle(stream6.get()) || isAQuintupleCross(stream6.get())) {
            return true;
        }
        return false;
    }

    // ---------------------------------------------------------------------------------------------------------------

    public static boolean isAQuintupleCircle(Stream<Cell> cells) {
        return  cells.allMatch(c -> c.getSymbol() == Symbol.CIRCLE);
    }

    public static boolean isAQuintupleCross(Stream<Cell> cells) {
        return  cells.allMatch(c -> c.getSymbol() == Symbol.CROSS);
    }
}