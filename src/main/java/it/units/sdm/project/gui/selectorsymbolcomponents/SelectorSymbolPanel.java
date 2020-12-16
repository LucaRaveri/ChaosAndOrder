package it.units.sdm.project.gui.selectorsymbolcomponents;

import it.units.sdm.project.gui.GameScreen;
import it.units.sdm.project.gui.symbols.CircleImage;
import it.units.sdm.project.gui.symbols.CrossImage;

import javax.swing.*;
import java.awt.*;

public class SelectorSymbolPanel extends JPanel {


    public SelectorSymbolPanel(){
        super();
        setProperties();
        add(new SelectorSymbolLabel());
//        add(new SelectorSymbol(new CircleImage()));
//        add(new SelectorSymbol(new CrossImage()));
        SelectorSymbolButtonGroup ssg = new SelectorSymbolButtonGroup();
        add(ssg.getCircleButton());
        add(ssg.getCrossButton());

    }

    public void setProperties(){
        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(GameScreen.getWindowWidth(), 100));
        setBackground(new Color(0x4D4D4D));
        setBorder(BorderFactory.createLineBorder(new Color(0x4D4D4D), 10));
    }

}
