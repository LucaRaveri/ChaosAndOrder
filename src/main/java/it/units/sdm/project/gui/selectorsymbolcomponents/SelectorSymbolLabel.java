package it.units.sdm.project.gui.selectorsymbolcomponents;

import javax.swing.JLabel;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class SelectorSymbolLabel extends JLabel {

    public SelectorSymbolLabel() {
        super();
        setProperties();
    }

    private void setProperties() {
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setText("<html>You are the player ORDER! Select your next symbol: </html>");
        setForeground(Color.WHITE);
        setFont(new Font("MV Boli", Font.PLAIN, 20));
    }

}
