package it.units.sdm.project.gui;

import it.units.sdm.project.entities.Symbol;
import it.units.sdm.project.gui.symbols.CircleImage;
import it.units.sdm.project.gui.symbols.CrossImage;

import javax.swing.*;
import java.awt.*;

public class GraphicCell extends JLabel {


    public GraphicCell() {
        super();
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
    }

//    public GraphicCell(ImageIcon imageIcon){
//        super(imageIcon);
//        setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
//    }

}
