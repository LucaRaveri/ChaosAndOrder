package it.units.sdm.project.gui;

import it.units.sdm.project.Game;
import it.units.sdm.project.entities.Symbol;

public class GUIGame extends Game {

    Symbol currentSymbol;

    public GUIGame() {
        currentSymbol = null;
    }

    @Override
    public void start() {
        GameScreen gameScreen = new GameScreen();
        gameScreen.setLocationRelativeTo(null); //open window in the center of the screen
        gameScreen.setVisible(true);

    }
}
