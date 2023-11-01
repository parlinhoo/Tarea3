package vistas;

import modelos.productos.Producto;

import javax.swing.*;
import java.awt.*;

public class PanelSalida extends JPanel {

    private Producto compra;

    public PanelSalida(){
        compra = null;
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(this.getWidth(), 150));
    }
}
