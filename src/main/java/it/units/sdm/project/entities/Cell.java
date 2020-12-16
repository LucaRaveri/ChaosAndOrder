package it.units.sdm.project.entities;

import java.util.Objects;

public class Cell {

    private Symbol symbol;

    public Cell() {
        symbol = null;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public boolean isEmpty() {
        return symbol!= null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
