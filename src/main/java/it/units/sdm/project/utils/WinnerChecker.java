package it.units.sdm.project.utils;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Cell;
import it.units.sdm.project.entities.Role;
import it.units.sdm.project.entities.Symbol;

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
        // iterate over Row
        for (int i = 0; i < Board.SIZE; i++) {
            final int row = i;
            Supplier<Stream<Cell>> stream = () -> pickRow(board, row);
            Supplier<Stream<Cell>> firstConfig = () -> pickFirstFiveElements(stream.get());
            if(isAQuintupleCircle(firstConfig.get())) {
                return true;
            }
            if(isAQuintupleCross(firstConfig.get())) {
                return true;
            }
            Supplier<Stream<Cell>> secondConfig = () -> pickLastFiveElements(stream.get());
            if(isAQuintupleCircle(secondConfig.get())) {
                return true;
            }
            if(isAQuintupleCross(secondConfig.get())) {
                return true;
            }
        }
        return false;
    }

    public static Stream<Cell> pickFirstFiveElements(Stream<Cell> stream) {

        return      stream
                .limit(5);

    }

    public static Stream<Cell> pickLastFiveElements(Stream<Cell> stream) {

        return      stream
                .skip(1);

    }

    public static boolean isAQuintupleCircle(Stream<Cell> cells) {
        return  cells.allMatch(c -> c.getSymbol() == Symbol.CIRCLE);
    }

    public static boolean isAQuintupleCross(Stream<Cell> cells) {
        return  cells.allMatch(c -> c.getSymbol() == Symbol.CROSS);
    }

    public static boolean checkColumns(Board board) {
        // iterate over Row
        for (int i = 0; i < Board.SIZE; i++) {
            final int column = i;
            Supplier<Stream<Cell>> stream = () -> pickColumn(board, column);
            Supplier<Stream<Cell>> firstConfig = () -> pickFirstFiveElements(stream.get());
            if(isAQuintupleCircle(firstConfig.get())) {
                return true;
            }
            if(isAQuintupleCross(firstConfig.get())) {
                return true;
            }
            Supplier<Stream<Cell>> secondConfig = () -> pickLastFiveElements(stream.get());
            if(isAQuintupleCircle(secondConfig.get())) {
                return true;
            }
            if(isAQuintupleCross(secondConfig.get())) {
                return true;
            }
        }
        return false;
    }

    public static Stream<Cell> pickRow(Board board, int index){
        return range(0,Board.SIZE)
                .mapToObj(i -> board.getCell(index,i));    }

    public static Stream<Cell> pickColumn(Board board, int index){
        return range(0,Board.SIZE)
                .mapToObj(i -> board.getCell(i,index));
    }

    public static Stream<Cell> pickRightDiag(Board board){
        return range(0,Board.SIZE)
                .mapToObj(i -> board.getCell(i,Board.SIZE-1-i));
    }

    public static Stream<Cell> pickRightDiagUpper(Board board){
        return range(1,Board.SIZE)
                .mapToObj(i -> board.getCell(i,Board.SIZE-i));
    }

    public static Stream<Cell> pickRightDiagLower(Board board){
        return range(0,Board.SIZE)
                .mapToObj(i -> board.getCell(i,Board.SIZE-i-2));
    }

    public static Stream<Cell> pickLeftDiag(Board board){
        return range(0,Board.SIZE)
                .mapToObj(i -> board.getCell(i,i));
    }

    public static Stream<Cell> pickLeftDiagUpper(Board board){
        return range(0,Board.SIZE-1)
                .mapToObj(i -> board.getCell(i,i+1));
    }

    public static Stream<Cell> pickLeftDiagLower(Board board){
        return range(1,Board.SIZE)
                .mapToObj(i -> board.getCell(i,i-1));
    }

    private static boolean checkDiagonals(Board board) {
        Supplier<Stream<Cell>> stream1 = () -> pickRightDiag(board);
        Supplier<Stream<Cell>> firstConfig1 = () -> pickFirstFiveElements(stream1.get());
        if(isAQuintupleCircle(firstConfig1.get())) {
            return true;
        }
        if(isAQuintupleCross(firstConfig1.get())) {
            return true;
        }
        Supplier<Stream<Cell>> secondConfig1 = () -> pickLastFiveElements(stream1.get());
        if(isAQuintupleCircle(secondConfig1.get())) {
            return true;
        }
        if(isAQuintupleCross(secondConfig1.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream2 = () -> pickLeftDiag(board);
        Supplier<Stream<Cell>> firstConfig2 = () -> pickFirstFiveElements(stream2.get());
        if(isAQuintupleCircle(firstConfig2.get())) {
            return true;
        }
        if(isAQuintupleCross(firstConfig2.get())) {
            return true;
        }
        Supplier<Stream<Cell>> secondConfig2 = () -> pickLastFiveElements(stream2.get());
        if(isAQuintupleCircle(secondConfig2.get())) {
            return true;
        }
        if(isAQuintupleCross(secondConfig2.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream3 = () -> pickRightDiagUpper(board);
        if(isAQuintupleCircle(stream3.get())) {
            return true;
        }
        if(isAQuintupleCross(stream3.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream4 = () -> pickRightDiagLower(board);
        if(isAQuintupleCircle(stream4.get())) {
            return true;
        }
        if(isAQuintupleCross(stream4.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream5 = () -> pickLeftDiagUpper(board);
        if(isAQuintupleCircle(stream5.get())) {
            return true;
        }
        if(isAQuintupleCross(stream5.get())) {
            return true;
        }
        Supplier<Stream<Cell>> stream6 = () -> pickLeftDiagLower(board);
        if(isAQuintupleCircle(stream6.get())) {
            return true;
        }
        if(isAQuintupleCross(stream6.get())) {
            return true;
        }
        return false;
    }

}