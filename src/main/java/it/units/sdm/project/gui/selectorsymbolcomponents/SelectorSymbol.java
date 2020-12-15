package it.units.sdm.project.gui.selectorsymbolcomponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectorSymbol extends JLabel implements MouseListener {

    public SelectorSymbol(ImageIcon imageIcon) {
        super(imageIcon);
        setBorder(BorderFactory.createLineBorder(new Color(0x4D4D4D), 3));
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        setBorder(BorderFactory.createLineBorder(Color.green, 3));

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBorder(BorderFactory.createLineBorder(Color.red, 3));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBorder(BorderFactory.createLineBorder(new Color(0x4D4D4D), 3));
    }
}
