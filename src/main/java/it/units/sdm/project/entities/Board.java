package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.TakenCellException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Board {

    public static final int SIZE = 6;
    private final List<Cell> board;

    public Board() {
        board = new ArrayList<>();
        this.build();
    }

    public Cell getCell(int row, int column) {
        return board.stream()
                .filter(c -> c.getRow() == row && c.getColumn() == column)
                .findFirst().get();
    }

    public void addSymbol(int x, int y, Symbol symbol) throws TakenCellException {
        if (getCell(x,y).getSymbol() != null) {
            throw new TakenCellException("Trying to modify a non empty cell.");
        }
        getCell(x,y).setSymbol(symbol);
    }

//    public boolean isFull() {
//        for (int row = 0; row < SIZE; row++) {
//            for (int column = 0; column < SIZE; column++) {
//                if (board[row][column].getSymbol() == null) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public boolean isFull() {
        return !board.stream()
                .anyMatch(Cell::isEmpty);
    }

    private void build() {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                board.add( new Cell(row, column));
            }
        }
    }

}
