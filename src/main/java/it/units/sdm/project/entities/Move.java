package it.units.sdm.project.entities;

import it.units.sdm.project.entities.Symbol;

public class Move {
    private final int row;
    private final int column;
    private final Symbol symbol;

    public Move(String command) {
        String[] tokens = command.split(" ");
        row = Integer.parseInt(tokens[0]);
        column = Integer.parseInt(tokens[1]);
        symbol = parseSymbol(tokens[2]);
    }

    public Symbol getSymbol(){
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }



    private Symbol parseSymbol(String symbol) {
        if(symbol.trim().equalsIgnoreCase("CROSS")){
            return Symbol.CROSS;
        } else if (symbol.trim().equalsIgnoreCase("CIRCLE")){
            return Symbol.CIRCLE;
        } else{
            return null;
        }
    }
}
