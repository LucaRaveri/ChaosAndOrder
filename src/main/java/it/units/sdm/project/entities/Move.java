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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return row == move.row &&
                column == move.column &&
                symbol == move.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, symbol);
    }

    @Override
    public String toString() {
        return row + " " + column + " " + symbol.name();
    }
}
