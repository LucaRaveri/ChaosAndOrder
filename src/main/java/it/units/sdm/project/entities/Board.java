package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.TakenCellException;

public class Board {

    public static final int SIZE = 6;
    private final Cell[][] board;

    public Board() {
        board = new Cell[SIZE][SIZE];
        this.build();
    }

    public Cell getCell(int row, int column) {
        return board[row][column];
    }

    public void addSymbol(int x, int y, Symbol symbol) throws TakenCellException {
        if (board[x][y].getSymbol() != null) {
            throw new TakenCellException("trying to modify a non empty cell.");
        }
        board[x][y].setSymbol(symbol);
    }

    public boolean isFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (board[row][column].getSymbol() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private void build() {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                board[row][column] = new Cell();
            }
        }
    }
}
