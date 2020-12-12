package it.units.sdm.project.entities;

public class Player {

    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum Role {
        CHAOS, ORDER
    }

    public void makeMove(Move move, Board board) {
        board.addSymbol(move.getRow(), move.getColumn(), move.getSymbol());
    }

}


