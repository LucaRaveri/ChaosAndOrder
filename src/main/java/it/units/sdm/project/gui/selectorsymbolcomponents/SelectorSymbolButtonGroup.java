package it.units.sdm.project.gui.selectorsymbolcomponents;

import it.units.sdm.project.gui.GameScreen;
import it.units.sdm.project.gui.symbols.CircleImage;
import it.units.sdm.project.gui.symbols.CrossImage;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorSymbolButtonGroup extends ButtonGroup implements ActionListener {

    JRadioButton crossButton = new JRadioButton(new CrossImage());
    JRadioButton circleButton = new JRadioButton(new CircleImage());

    public SelectorSymbolButtonGroup() {

        crossButton.setHorizontalAlignment(SwingConstants.CENTER);
        circleButton.setHorizontalAlignment(SwingConstants.CENTER);

        crossButton.addActionListener(this);
        circleButton.addActionListener(this);

        add(crossButton);
        add(circleButton);

        crossButton.setBackground(new Color(0x4D4D4D));
        circleButton.setBackground(new Color(0x4D4D4D));
        //TODO: find a better solution to lay out the components on SelectorSymbolPanel
        circleButton.setPreferredSize(new Dimension(GameScreen.WINDOW_WIDTH / 4, 30));
        crossButton.setPreferredSize(new Dimension(GameScreen.WINDOW_WIDTH / 4, 30));
    }

    public JRadioButton getCrossButton() {
        return crossButton;
    }

    public JRadioButton getCircleButton() {
        return circleButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == circleButton) {
            crossButton.setBorderPainted(false);
            circleButton.setBorderPainted(true);
            circleButton.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
//            System.out.println("circle button clicked");
        } else {
            circleButton.setBorderPainted(false);
            crossButton.setBorderPainted(true);
            crossButton.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
//            System.out.println("cross button clicked");
        }
    }
}
