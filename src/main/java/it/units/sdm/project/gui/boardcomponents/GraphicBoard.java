package it.units.sdm.project.gui.boardcomponents;

import it.units.sdm.project.entities.Board;
import it.units.sdm.project.gui.GameScreen;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

public class GraphicBoard extends JPanel {

    private static final GraphicCell[][] graphicCells = new GraphicCell[Board.SIZE][Board.SIZE];

    public GraphicBoard() {
        super();
        setProperties();
        initGraphicCells();
    }

    private void setProperties() {
        setLayout(new GridLayout(Board.SIZE, Board.SIZE));
        setBackground(GameScreen.BACKGROUND_COLOR);
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
