package it.units.sdm.project.utils;

import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import it.units.sdm.project.exceptions.IllegalSymbolException;
import it.units.sdm.project.exceptions.WrongNumberOfArgumentsException;

//TODO: keep it static?
public class MoveParser {

    private static int column;
    private static int row;
    private static Symbol symbol;

    public static void setMoveLine(String moveLine) throws IllegalSymbolException, BoardIndexOutOfBoundsException, WrongNumberOfArgumentsException {

        String[] tokens = moveLine.trim().split(" ");

        if (tokens.length != 2 || tokens[0].length() < 2)
            throw new WrongNumberOfArgumentsException("Move bad syntax");

        checkMoveLineFormat(tokens);

        column = retrieveColumn(tokens[0].toLowerCase().charAt(0));
        row = retrieveRaw(Integer.parseInt(tokens[0].substring(1)));
        symbol = retrieveSymbol(tokens[1]);

    }

    public static int getRow() {
        return row;
    }

    public static Symbol getSymbol() {
        return symbol;
    }


    public static int getColumn() {
        return column;
    }

    private static void checkMoveLineFormat(String[] tokens) throws BoardIndexOutOfBoundsException, IllegalSymbolException {

        if (!tokens[0].substring(0, 1).matches("[a-fA-F]")) {
            throw new BoardIndexOutOfBoundsException("Bad column value");
        } else if (!tokens[0].substring(1).matches("[1-6]")) {
            throw new BoardIndexOutOfBoundsException("Bad raw value");
        } else if (!tokens[1].matches("[oOxX]")) {
            throw new IllegalSymbolException("Bad symbol value");
        }
    }


    private static int retrieveRaw(int raw){

        return raw - 1;

    }

    private static int retrieveColumn(char column){

        //converting the character in the corrent column value
        return column - 'a';

    }

    private static Symbol retrieveSymbol(String symbol) throws IllegalSymbolException {

        return (symbol.equalsIgnoreCase("X")) ? Symbol.CROSS : Symbol.CIRCLE;

    }


}
