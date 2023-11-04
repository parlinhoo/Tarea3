package vistas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * PanelSeleccion represebta el panel numerico que permite elegir un producto en ele expendedor
 * Contiene botones para cada producto disponible y permite cambiar el producto seleccionado en el expendedor.
 */
public class PanelSeleccion extends JPanel {

    public PanelExpendedor panelExpendedor;

    /**
     * Constructor para la clase PanelSeleccion. Inicializa el panel con botones para seleccionar productos del expendedor.
     */
    public PanelSeleccion(){
        this.setLayout(new GridLayout(5, 1));
        JButton cocacola = new JButton("1");
        JButton sprite = new JButton("2");
        JButton fanta = new JButton("3");
        JButton snickers = new JButton("4");
        JButton super8 = new JButton("5");
        ArrayList<JButton> botones = new ArrayList<>();
        botones.add(cocacola);
        botones.add(sprite);
        botones.add(fanta);
        botones.add(snickers);
        botones.add(super8);
        for (JButton boton : botones) {
            this.add(boton);
            boton.addActionListener((l) -> {
                for (JButton boton2 : botones) {
                    boton2.setBackground(new Color(238, 238, 238));
                }
                boton.setBackground(Color.GREEN);
                panelExpendedor.cambiarProducto(Integer.parseInt(boton.getText()));
            });
        }
        this.setPreferredSize(new Dimension(50, this.getHeight()));
    }
}
