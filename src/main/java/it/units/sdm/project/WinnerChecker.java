package it.units.sdm.project;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Player;

public class WinnerChecker {
    private Board board;

    public static boolean thereIsAWinner(){
        return false;
    }

    public static Player.Role getWinner(){
        //TODO: fixa
        return Player.Role.CHAOS;
    }
}
