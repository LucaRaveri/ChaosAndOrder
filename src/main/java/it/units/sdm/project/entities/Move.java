package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import it.units.sdm.project.exceptions.IllegalSymbolException;
import it.units.sdm.project.exceptions.WrongNumberOfArgumentsException;

public class Move {
    private final int row;
    private final int column;
    private final Symbol symbol;

    public Move(String command) throws IllegalSymbolException, BoardIndexOutOfBoundsException, WrongNumberOfArgumentsException {

        if (command.trim().split("[ \t]+").length != 3)
            throw new WrongNumberOfArgumentsException("Wrong number of parameters: " + command.split(" ").length);

        String[] tokens = command.trim().split("[ \t]+");
        row = parseRow(tokens[0]);
        column = parseColumn(tokens[1]);
        symbol = parseSymbol(tokens[2]);
    }

    private int parseColumn(String column) throws BoardIndexOutOfBoundsException {
        if (Integer.parseInt(column) > 0 && Integer.parseInt(column) <= Board.SIZE) {
            return Integer.parseInt(column);
        } else {
            throw new BoardIndexOutOfBoundsException("the column number inserted doesn't exist.");
        }
    }

    private int parseRow(String row) throws BoardIndexOutOfBoundsException {
        if (Integer.parseInt(row) > 0 && Integer.parseInt(row) <= Board.SIZE) {
            return Integer.parseInt(row);
        } else {
            throw new BoardIndexOutOfBoundsException("the row number inserted doesn't exist.");
        }
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


    private Symbol parseSymbol(String symbol) throws IllegalSymbolException {
        if (symbol.trim().equalsIgnoreCase("CROSS")) {
            return Symbol.CROSS;
        } else if (symbol.trim().equalsIgnoreCase("CIRCLE")) {
            return Symbol.CIRCLE;
        } else {
            throw new IllegalSymbolException("Illegal symbol inserted");
        }
    }
}
