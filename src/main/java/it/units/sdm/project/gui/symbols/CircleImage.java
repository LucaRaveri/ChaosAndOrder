package it.units.sdm.project.gui.symbols;

import javax.swing.*;
import java.awt.*;

public class CircleImage extends ImageIcon {

    private static final String filename = "src\\main\\resources\\circle.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;


    public CircleImage() {
        super(new ImageIcon(filename).getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));
    }

}
