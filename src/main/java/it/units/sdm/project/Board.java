package it.units.sdm.project;

import java.util.Arrays;

public class Board {

    private final int SIZE = 6;

    Cell[][] board = new Cell[SIZE][SIZE];

    public Board() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int i, int j) {
        return board[i][j];
    }

    //  metodo inutile, esiste Cell.setSymbol()
//    public void setCellSymbol(int x, int y, Cell.Symbol symbol) {
//        board[x][y].setSymbol(symbol);
//    }

    public boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (getCell(i, j).getSymbol() == null) {
                    isFull = false;
                    break;
                }
            }
        }
        return isFull;
    }

    public boolean existsQuintupleInARaw() {
        boolean checkRighe = false;
        int count;
        for (int i = 0; i < SIZE; i++) {
            count = 0;
            for (int j = 0; j < SIZE - 2; j++) {
                if (getCell(i, j).getSymbol() == getCell(i, j+1).getSymbol()) {
                    count++;
                    if(count == 4) {
                        checkRighe = true;
                    }
                }
        else break;
            }
            count = 0;
            for (int j = 1; j < SIZE-1; j++) {
                if (getCell(i, j).getSymbol() == getCell(i, j+1).getSymbol()) {
                    count++;
                    if(count == 4) {
                        checkRighe = true;
                    }
                }
        else break;
            }
        }
        return checkRighe;
    }
}
