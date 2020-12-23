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

    // TODO: use Streams
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
            Supplier<Stream<Cell>> stream = () -> pickRow(board, x);
            Supplier<Stream<Cell>> firstConfig = () -> stream.get().limit(5);
            Supplier<Stream<Cell>> secondConfig = () -> stream.get().skip(1);
            return isAQuintupleCircle(firstConfig.get()) || isAQuintupleCross(firstConfig.get()) || isAQuintupleCircle(secondConfig.get()) || isAQuintupleCross(secondConfig.get());
        }).findAny();
        return rowNumber.isPresent();
    }

    public static boolean checkColumns(Board board) {
        OptionalInt columnNumber = range(0, Board.SIZE).parallel().filter(x -> {
            Supplier<Stream<Cell>> stream = () -> pickColumn(board, x);
            Supplier<Stream<Cell>> firstConfig = () -> stream.get().limit(5);
            Supplier<Stream<Cell>> secondConfig = () -> stream.get().skip(1);
            return isAQuintupleCircle(firstConfig.get()) || isAQuintupleCross(firstConfig.get()) || isAQuintupleCircle(secondConfig.get()) || isAQuintupleCross(secondConfig.get());
        }).findAny();
        return columnNumber.isPresent();
    }

    public static Stream<Cell> pickFirstFiveElements(Stream<Cell> stream) {
        return      stream.limit(5);
    }

    public static Stream<Cell> pickLastFiveElements(Stream<Cell> stream) {
        return      stream.skip(1);
    }

    // don t works
//    public static boolean isAQuintuple(Stream<Cell> cells) {
//        return  isAQuintupleCircle(cells) || isAQuintupleCross(cells);
//    }

    public static Stream<Cell> pickRow(Board board, int index){
        return range(0,Board.SIZE).mapToObj(i -> board.getCell(index,i));    }

    public static Stream<Cell> pickColumn(Board board, int index){
        return range(0,Board.SIZE).mapToObj(i -> board.getCell(i,index));
    }

    public static Stream<Cell> pickSecondaryDiag(Board board){
        return range(0,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-1-i));
    }

    public static Stream<Cell> pickSecondaryDiagUpper(Board board){
        return range(1,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-i));
    }

    public static Stream<Cell> pickSecondaryDiagLower(Board board){
        return range(0,Board.SIZE).mapToObj(i -> board.getCell(i,Board.SIZE-i-2));
    }

    public static Stream<Cell> pickPrimaryDiag(Board board){
        return range(0,Board.SIZE).mapToObj(i -> board.getCell(i,i));
    }

    public static Stream<Cell> pickPrimaryDiagUpper(Board board){
        return range(0,Board.SIZE-1).mapToObj(i -> board.getCell(i,i+1));
    }

    public static Stream<Cell> pickPrimaryDiagLower(Board board){
        return range(1,Board.SIZE).mapToObj(i -> board.getCell(i,i-1));
    }

    private static boolean checkDiagonals(Board board) {
        Supplier<Stream<Cell>> stream1 = () -> pickSecondaryDiag(board);
        Supplier<Stream<Cell>> firstConfig1 = () -> pickFirstFiveElements(stream1.get());
        if(isAQuintupleCircle(firstConfig1.get()) || isAQuintupleCross(firstConfig1.get())) {
            return true;
        }
        Supplier<Stream<Cell>> secondConfig1 = () -> pickLastFiveElements(stream1.get());
        if(isAQuintupleCircle(secondConfig1.get()) || isAQuintupleCross(secondConfig1.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream2 = () -> pickPrimaryDiag(board);
        Supplier<Stream<Cell>> firstConfig2 = () -> pickFirstFiveElements(stream2.get());
        if(isAQuintupleCircle(firstConfig2.get()) || isAQuintupleCross(firstConfig2.get())) {
            return true;
        }
        Supplier<Stream<Cell>> secondConfig2 = () -> pickLastFiveElements(stream2.get());
        if(isAQuintupleCircle(secondConfig2.get()) || isAQuintupleCross(secondConfig2.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream3 = () -> pickSecondaryDiagUpper(board);
        if(isAQuintupleCircle(stream3.get()) || isAQuintupleCross(stream3.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream4 = () -> pickSecondaryDiagLower(board);
        if(isAQuintupleCircle(stream4.get()) || isAQuintupleCross(stream4.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream5 = () -> pickPrimaryDiagUpper(board);
        if(isAQuintupleCircle(stream5.get()) || isAQuintupleCross(stream5.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream6 = () -> pickPrimaryDiagLower(board);
        if(isAQuintupleCircle(stream6.get()) || isAQuintupleCross(stream6.get())) {
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