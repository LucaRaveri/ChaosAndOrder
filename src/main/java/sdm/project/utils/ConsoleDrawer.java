package sdm.project.utils;

import sdm.project.entities.Board;
import sdm.project.entities.Cell;
import sdm.project.entities.Symbol;

import java.util.stream.IntStream;

public class ConsoleDrawer {

    private static final String COLUMNS_LABEL = "         A     B     C     D     E     F       ";
    private static final String ROW_SEPARATOR = "      +-----+-----+-----+-----+-----+-----+    ";
    private static final String COLUMN_SEPARATOR = "|";


    public static void print(String message) {
        System.out.print(message);

    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(Board board) {
        println("");
        println(COLUMNS_LABEL);
        println(ROW_SEPARATOR);
        IntStream.range(0, Board.SIZE).forEach(i -> {
            print("   " + i + "  ");
            IntStream.range(0, Board.SIZE).forEach(j -> print(COLUMN_SEPARATOR + "  " + getCorrectSymbol(board.getCell(i, j)) + "  "));
            println(COLUMN_SEPARATOR);
            println(ROW_SEPARATOR);
        });
    }

    // TODO: rename method
    private static String getCorrectSymbol(Cell cell) {

        if (cell.getSymbol() == null) return " ";
        else return (cell.getSymbol() == Symbol.CIRCLE) ? "O" : "X";

        //        return (cell.getSymbol() == null) ? " " : (cell.getSymbol() == Symbol.CROSS) ? "X" : "O";
    }


}
