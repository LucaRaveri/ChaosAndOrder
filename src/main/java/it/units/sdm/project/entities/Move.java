package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import it.units.sdm.project.exceptions.IllegalSymbolException;

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

}
