package it.units.sdm.project.entities;

import it.units.sdm.project.exceptions.TakenCellException;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return role == player.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}


