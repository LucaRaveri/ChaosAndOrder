package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.TakenCellException;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public static final int SIZE = 6;
    // TODO: set? list? Cell[][]?
    private final List<Cell> cells;

    public Board() {
        cells = new ArrayList<>();
        this.build();
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Cell getCell(int row, int column) {
        return cells.stream().filter(cell -> cell.getRow() == row && cell.getColumn() == column).findFirst().get();
    }

    //TODO: rename method?
    public void insert(Move move) throws TakenCellException {
        if (getCell(move.getRow(), move.getColumn()).getSymbol() != null) {
            throw new TakenCellException("Trying to modify a non empty cell.");
        }
        getCell(move.getRow(), move.getColumn()).setSymbol(move.getSymbol());
    }

    public boolean isFull() {
        return cells.stream().noneMatch(Cell::isEmpty);
    }

    private void build() {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                cells.add(new Cell(row, column));
            }
        }
    }

    /*TODO: check if it can be done
    private void build(){
        cells.stream().forEach(cells.add(Cell::new));
    }*/


}
