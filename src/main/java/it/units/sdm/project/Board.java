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

    public void setCellSymbol(int x, int y, Cell.Symbol symbol) {
        board[x][y].setSymbol(symbol);
    }

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

    public boolean existsQuintuple() {

        boolean check=false;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i + 4 < SIZE && getCell(i, j).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i + 1, j).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i + 2, j).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i + 3, j).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i + 4, j).getSymbol() == Cell.Symbol.CIRCLE) {
                            return true;
                } else if (j + 4 < SIZE && getCell(i, j).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i, j+1).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i, j+2).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i, j+3).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i, j+4).getSymbol() == Cell.Symbol.CIRCLE){
                    return true;
                } else if(j + 4 < SIZE && i+4<SIZE &&
                        getCell(i, j).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i+1, j+1).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i+2, j+2).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i+3, j+3).getSymbol() == Cell.Symbol.CIRCLE &&
                        getCell(i+4, j+4).getSymbol() == Cell.Symbol.CIRCLE){
                    return true;
                }
            }
        }
        return false;


    }
}
