package it.units.sdm.project.entities;

import java.util.Objects;

public class Move {
    private final int row;
    private final int column;
    private final Symbol symbol;

    public Move(int row, int column, Symbol symbol) {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

}
