package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.TakenCellException;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int SIZE = 6;
    private final List<Cell> cells;

    public Board() {
        cells = new ArrayList<>();
        this.build();
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Cell getCell(int row, int column) {
        return cells.stream()
                .filter(c -> c.getRow() == row && c.getColumn() == column)
                .findFirst().get();
    }

    public void addSymbol(int x, int y, Symbol symbol) throws TakenCellException {
        if (getCell(x,y).getSymbol() != null) {
            throw new TakenCellException("Trying to modify a non empty cell.");
        }
        getCell(x,y).setSymbol(symbol);
    }

    public boolean isFull() {
        return !cells.stream()
                .anyMatch(Cell::isEmpty);
    }

    private void build() {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                cells.add( new Cell(row, column));
            }
        }
    }

}
