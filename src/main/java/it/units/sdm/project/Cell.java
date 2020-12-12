package it.units.sdm.project;

public class Cell {

    private Symbol symbol;

    public Cell() {
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public boolean isEmpty() {
        if (symbol == null) {
            return false;
        } else {
            return true;
        }
    }

}
