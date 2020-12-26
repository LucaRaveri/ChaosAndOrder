package it.units.sdm.project.utils;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Symbol;

public class ConsoleDrawer {

    private static final String COLUMNS_LABEL = "         A     B     C     D     E     F       ";
    private static final String ROW_SEPARATOR = "      +-----+-----+-----+-----+-----+-----+    ";
    private static final String COLUMN_SEPARATOR = " | ";

    public static void print(String message){
        System.out.print(message);
    }

    public static void println(String message){
        System.out.println(message);
    }

    public static void print(Board board) {
        System.out.println();
        System.out.println(COLUMNS_LABEL);
        for (int k = 0; k < 6; k++) {
            System.out.println(ROW_SEPARATOR);
            System.out.print("  " + (k+1) + " ");
            for (int i = 0; i < 6; i++) {
                System.out.print(COLUMN_SEPARATOR);
                if (board.getCell(k, i).getSymbol() == Symbol.CIRCLE) {
                    System.out.print("O");
                } else if (board.getCell(k, i).getSymbol() == Symbol.CROSS) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("  |  \n");
        }
        System.out.println("      +-----+-----+-----+-----+-----+-----+ ");
        System.out.println();
    }


}
