package it.units.sdm.project;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Player;

public abstract class Game {

    private final Board board;
    private final Player chaosPlayer;
    private final Player orderPlayer;

    protected Game() {
        board = new Board();
        chaosPlayer = new Player(Player.Role.CHAOS);
        orderPlayer = new Player(Player.Role.ORDER);
    }

    public abstract void start();

}
