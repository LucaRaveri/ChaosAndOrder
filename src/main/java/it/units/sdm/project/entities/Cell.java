package it.units.sdm.project.entities;

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

}
