package it.units.sdm.project.gui;

import it.units.sdm.project.Game;
import it.units.sdm.project.entities.Player;
import it.units.sdm.project.entities.Symbol;

public class GUIGame extends Game {

    private Symbol currentSymbol;
    private Player currentPlayer;

    public GUIGame() {
        currentSymbol = null;
        currentPlayer = chaosPlayer;
    }

    @Override
    public void start() {
        GameScreen gameScreen = new GameScreen();
        gameScreen.setLocationRelativeTo(null); //open window in the center of the screen
        gameScreen.setVisible(true);

    }
}
