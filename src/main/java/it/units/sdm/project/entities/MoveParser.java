package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.BoardIndexOutOfBoundsException;
import it.units.sdm.project.exceptions.IllegalSymbolException;
import it.units.sdm.project.exceptions.WrongNumberOfArgumentsException;

public class MoveParser {

    private char character;
    private int raw;
    private final Symbol symbol;

    public MoveParser(String moveLine) throws IllegalSymbolException, BoardIndexOutOfBoundsException, WrongNumberOfArgumentsException {

        String[] tokens = moveLine.trim().split(" ");

        if (tokens.length != 2 || tokens[0].length() < 2)
            throw new WrongNumberOfArgumentsException("parameters inserted differents from two");

        character = retrieveCharacter(tokens[0].charAt(0));
        raw = retrieveRaw(Integer.parseInt(tokens[0].substring(1)));
        symbol = retrieveSymbol(tokens[1]);

    }

    private int retrieveRaw(int raw) throws BoardIndexOutOfBoundsException {
        if (raw < 1 || raw > 6) {
            throw new BoardIndexOutOfBoundsException("invalid raw inserted");
        } else {
            return raw;
        }
    }

    private char retrieveCharacter(char character) throws BoardIndexOutOfBoundsException {
        if (character < 'a' || character > 'f') {
            throw new BoardIndexOutOfBoundsException("invalid column inserted");
        } else {
            return character;
        }
    }

    private Symbol retrieveSymbol(String symbol) throws IllegalSymbolException {

        if (symbol.equalsIgnoreCase("X")) {
            return Symbol.CROSS;
        } else if (symbol.equalsIgnoreCase("O")) {
            return Symbol.CIRCLE;
        } else {
            throw new IllegalSymbolException("Illegal symbol inserted");
        }
    }


    public int getRaw() {
        return raw;
    }

    public Symbol getSymbol() {
        return symbol;
    }


    public int getColumn() {
        return character;
    }


}
