package sdm.project.core.entities;

import sdm.project.core.exceptions.TakenCellException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        return cells.stream().filter(cell -> cell.getRow() == row && cell.getColumn() == column).findFirst().get();
    }

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
        IntStream.range(0, Board.SIZE).forEach(row -> {
            IntStream.range(0, Board.SIZE).forEach(column -> {
                cells.add(new Cell(row, column));
            });
        });
    }
}
