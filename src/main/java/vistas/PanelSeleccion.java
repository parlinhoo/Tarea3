package vistas;

import javax.swing.*;
import java.awt.*;

public class PanelSeleccion extends JPanel {

    public PanelSeleccion(){
        this.setLayout(new GridLayout(5, 1));
        this.add(new JButton("1"));
        this.add(new JButton("2"));
        this.add(new JButton("3"));
        this.add(new JButton("4"));
        this.add(new JButton("5"));

    }
}
