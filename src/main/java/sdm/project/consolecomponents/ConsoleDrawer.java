package sdm.project.consolecomponents;

import sdm.project.core.entities.Board;
import sdm.project.core.entities.Cell;
import sdm.project.core.entities.Symbol;

import java.util.stream.IntStream;

public class ConsoleDrawer {

    private static final String COLUMNS_LABEL = "         A     B     C     D     E     F";
    private static final String ROW_SEPARATOR = "      +-----+-----+-----+-----+-----+-----+";
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
            print("   " + (i + 1) + "  ");
            IntStream.range(0, Board.SIZE).forEach(j -> print(COLUMN_SEPARATOR + "  " + getCellContentAsString(board.getCell(i, j)) + "  "));
            println(COLUMN_SEPARATOR);
            println(ROW_SEPARATOR);
        });
    }

    private static String getCellContentAsString(Cell cell) {

        return (cell.getSymbol() == null) ? " " : (cell.getSymbol() == Symbol.CROSS) ? "X" : "O";
        
    }

    public static void println(Board board) {
        print(board);
        println("");
    }
}
