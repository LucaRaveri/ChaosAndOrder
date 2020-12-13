package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.TakenCellException;

public class Player {

    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum Role {
        CHAOS, ORDER
    }

    public void makeMove(Move move, Board board) throws TakenCellException {
        board.addSymbol(move.getRow(), move.getColumn(), move.getSymbol());
    }

}


