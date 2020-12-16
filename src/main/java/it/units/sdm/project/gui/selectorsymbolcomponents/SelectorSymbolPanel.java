package it.units.sdm.project.gui.selectorsymbolcomponents;

import it.units.sdm.project.gui.GameScreen;

import javax.swing.*;
import java.awt.*;

public class SelectorSymbolPanel extends JPanel {


    public SelectorSymbolPanel(){
        super();
        setProperties();
        add(new SelectorSymbolLabel());

        SelectorSymbolButtonGroup ssg = new SelectorSymbolButtonGroup();
        add(ssg.getCircleButton());
        add(ssg.getCrossButton());

    }

    public void setProperties(){
//        setLayout(new GridLayout(1, 3));
//        setLayout(new FlowLayout());
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(GameScreen.WINDOW_WIDTH, 80));
        setBackground(GameScreen.BACKGROUND_COLOR);
    }

}
