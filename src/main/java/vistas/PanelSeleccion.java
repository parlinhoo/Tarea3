package vistas;

import javax.swing.*;
import java.awt.*;

public class PanelSeleccion extends JPanel {

    public PanelSeleccion(){
        this.setLayout(new GridLayout(5, 1));
        JButton cocacola = new JButton("1");
        JButton sprite = new JButton("2");
        JButton fanta = new JButton("3");
        JButton snickers = new JButton("4");
        JButton super8 = new JButton("5");
        cocacola.addActionListener((l) -> {
            System.out.println("AAAAAAA");
        });
        this.add(cocacola);
        this.add(sprite);
        this.add(fanta);
        this.add(snickers);
        this.add(super8);

    }
}
