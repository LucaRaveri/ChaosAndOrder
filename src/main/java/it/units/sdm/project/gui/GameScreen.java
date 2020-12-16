package it.units.sdm.project.gui;

import it.units.sdm.project.gui.menucomponents.MenuBar;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {

    public static final Color BACKGROUND_COLOR = new Color(0x4D4D4D);
    public static final int WINDOW_WIDTH = 750;
    public static final int WINDOW_HEIGHT = 750;

    public GameScreen() {
        super();
        setProperties();
        add(new MenuBar(), BorderLayout.NORTH);
        add(new GamePanel(), BorderLayout.CENTER);
    }


    private void setProperties() {
        setTitle("Order and Chaos Game");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
