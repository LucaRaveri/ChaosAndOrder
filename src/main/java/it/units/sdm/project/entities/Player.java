package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.TakenCellException;

public class Player {

    private Role role;

    public Player(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public void makeMove(Move move, Board board) throws TakenCellException {
        board.addSymbol(move.getRaw(), move.getColumn(), move.getSymbol());
    }

}


