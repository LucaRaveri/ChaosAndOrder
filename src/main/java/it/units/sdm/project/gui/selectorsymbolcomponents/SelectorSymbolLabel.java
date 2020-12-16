package it.units.sdm.project.gui.selectorsymbolcomponents;

import it.units.sdm.project.entities.Role;

import javax.swing.*;
import java.awt.*;

public class SelectorSymbolLabel extends JLabel {

    private Role role;

    public SelectorSymbolLabel() {
        super();
        setProperties();
        role = Role.ORDER;
    }

    private void setRole(Role role) {
        this.role = role;
    }

    private Role getRole() {
        return role;
    }

    private void setProperties() {
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setText("<html><p>You are the player " + Role.toString(getRole()) + " !</p> <p> Select your next symbol:</p> </html>");
        setForeground(Color.WHITE);
        setFont(new Font("MV Boli", Font.PLAIN, 20));
    }

}
