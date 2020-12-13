package it.units.sdm.project.exceptions;

public class TakenCellException extends Exception{

    public TakenCellException(){
        super("the cell has already a symbol");
    }

    public TakenCellException(String message){
        super(message);
    }

}
