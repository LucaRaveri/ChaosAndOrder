package it.units.sdm.project.gui.boardcomponents;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.gui.boardcomponents.GraphicCell;

import javax.swing.*;
import java.awt.*;

public class GraphicBoard extends JPanel {

    private static final GraphicCell[][] graphicCells = new GraphicCell[Board.SIZE][Board.SIZE];
    private static final Color backgroundColor = new Color(0x4D4D4D);

    public GraphicBoard() {
        super();
        setProperties();
        initGraphicCells();
    }

    private void setProperties() {
        setLayout(new GridLayout(Board.SIZE, Board.SIZE));
        setBackground(backgroundColor);
    }

    private void initGraphicCells() {
        //initialize components and adding them to the panel
        for (int i = 0; i < Board.SIZE; i++) {
            for (int j = 0; j < Board.SIZE; j++) {
                graphicCells[i][j] = new GraphicCell();
                graphicCells[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
                add(graphicCells[i][j]);
            }
        }


    }

}
