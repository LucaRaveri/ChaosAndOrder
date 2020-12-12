package it.units.sdm.project.drawer;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Symbol;

public class BoardDrawer {

    public static void print(Board board) {

        System.out.println("         A     B     C     D     E     F       ");
        for (int k = 0; k < 6; k++) {
            System.out.println("      +-----+-----+-----+-----+-----+-----+ ");
            System.out.print("  " + (k+1) + " ");
            for (int i = 0; i < 6; i++) {
                System.out.print("  |  ");
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

    }

}
