package it.units.sdm.project;

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
}
