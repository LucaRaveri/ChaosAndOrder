package it.units.sdm.project.gui;

import javax.swing.*;
import java.awt.*;

public class SelectorMovePanel extends JPanel {


    public SelectorMovePanel(){
        super();
        setProperties();
        add(new JLabel("You are the gamer Order"));
        add(new JLabel("select cross"));
        add(new JLabel("select circle"));
    }

    public void setProperties(){
        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(750, 100));
    }

}
