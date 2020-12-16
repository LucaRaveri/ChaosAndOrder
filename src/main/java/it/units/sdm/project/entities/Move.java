package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import it.units.sdm.project.exceptions.IllegalSymbolException;

import java.util.Objects;

public class Move {
    private final int raw;
    private final int column;
    private final Symbol symbol;

    public Move(int raw, int column, Symbol symbol) {
        this.raw = raw;
        this.column = column;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getRaw() {
        return raw;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return raw == move.raw &&
                column == move.column &&
                symbol == move.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(raw, column, symbol);
    }

    @Override
    public String toString() {
        return raw + " " + column + " " + symbol.name();
    }
}
