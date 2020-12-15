package it.units.sdm.project.gui;

import it.units.sdm.project.gui.boardcomponents.GraphicBoard;
import it.units.sdm.project.gui.selectorsymbolcomponents.SelectorSymbolPanel;

import javax.swing.*;
import java.awt.*;

public class OuterGamePanel extends JPanel {

    public OuterGamePanel() {
        setProperties();
        add(new SelectorSymbolPanel(), BorderLayout.NORTH);
        add(new GraphicBoard(), BorderLayout.CENTER);
    }

    public void setProperties() {
        setLayout(new BorderLayout());
    }


}
