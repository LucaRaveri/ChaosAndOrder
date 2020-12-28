package sdm.project.core.entities;

public class Cell {

    private Symbol symbol;
    private final int row;
    private final int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.symbol = null;
    }


    public void setSymbol(Symbol symbol) {
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

    public boolean isEmpty() {
        return symbol == null;
    }

}
