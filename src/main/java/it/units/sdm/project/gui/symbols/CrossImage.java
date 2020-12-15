package it.units.sdm.project.gui.symbols;

import javax.swing.*;
import java.awt.*;

public class CrossImage extends ImageIcon {

    private static final String filename = "src\\main\\resources\\cross.png";
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    public CrossImage() {
        super(new ImageIcon(filename).getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));
    }

}
