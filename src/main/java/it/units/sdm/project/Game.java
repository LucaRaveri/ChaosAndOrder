package it.units.sdm.project;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.entities.Player;
import it.units.sdm.project.entities.Role;

public abstract class Game {

    protected final Board board;
    protected final Player chaosPlayer;
    protected final Player orderPlayer;

    protected Game() {
        board = new Board();
        chaosPlayer = new Player(Role.CHAOS);
        orderPlayer = new Player(Role.ORDER);
    }

    public abstract void start();

}
