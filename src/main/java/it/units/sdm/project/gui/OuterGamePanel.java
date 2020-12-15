package it.units.sdm.project.gui;

import javax.swing.*;
import java.awt.*;

public class OuterGamePanel extends JPanel {

    public OuterGamePanel() {
        setProperties();
        add(new SelectorMovePanel(), BorderLayout.NORTH);
        add(new GraphicBoard(), BorderLayout.CENTER);
    }

    public void setProperties() {
        setLayout(new BorderLayout());
    }


}
