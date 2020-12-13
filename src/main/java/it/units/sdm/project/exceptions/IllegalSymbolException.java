package it.units.sdm.project.exceptions;

public class IllegalSymbolException extends Exception {

    public IllegalSymbolException(){
        super("illegal symbol");
    }

    public IllegalSymbolException(String message){
        super(message);
    }

}
