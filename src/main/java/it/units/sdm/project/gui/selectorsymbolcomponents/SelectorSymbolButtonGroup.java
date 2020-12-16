package it.units.sdm.project.gui.selectorsymbolcomponents;

import it.units.sdm.project.gui.symbols.CircleImage;
import it.units.sdm.project.gui.symbols.CrossImage;

import javax.swing.*;
import java.awt.*;
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
    }

    public JRadioButton getCrossButton() {
        return crossButton;
    }

    public JRadioButton getCircleButton(){
        return circleButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==circleButton){
            crossButton.setBorderPainted(false);
            circleButton.setBorderPainted(true);
            circleButton.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
            System.out.println("circle button clicked");
        } else{
            circleButton.setBorderPainted(false);
            crossButton.setBorderPainted(true);
            crossButton.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
            System.out.println("cross button clicked");
        }
    }
}
