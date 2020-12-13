package it.units.sdm.project.exceptions;

public class BoardIndexOutOfBoundsException extends Exception {

    public BoardIndexOutOfBoundsException() {
        super("trying to access to a non existing cell");
    }

    public BoardIndexOutOfBoundsException(String message) {
        super(message);
    }

}
