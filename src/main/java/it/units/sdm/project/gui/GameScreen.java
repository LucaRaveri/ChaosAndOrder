package it.units.sdm.project.gui;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {

    private static final int WINDOW_WIDTH = 750;
    private static final int WINDOW_HEIGHT = 750;

    public GameScreen(){
        super();
        setProperties();
        add(new MenuBar(), BorderLayout.NORTH);
        add(new OuterGamePanel(), BorderLayout.CENTER);
    }

    private void setProperties(){
        setTitle("Order and Chaos Game");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



}
