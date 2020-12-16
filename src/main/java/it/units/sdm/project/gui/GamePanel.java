package it.units.sdm.project.gui;

import it.units.sdm.project.gui.boardcomponents.GraphicBoard;
import it.units.sdm.project.gui.selectorsymbolcomponents.SelectorSymbolPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        setProperties();
        add(new SelectorSymbolPanel(), BorderLayout.NORTH);
        add(new GraphicBoard(), BorderLayout.CENTER);
    }

    public void setProperties() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(GameScreen.BACKGROUND_COLOR);
        setLayout(new BorderLayout());
    }


}
