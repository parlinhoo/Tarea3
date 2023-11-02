package vistas;

import modelos.productos.Producto;

import javax.swing.*;
import java.awt.*;

public class PanelSalida extends JPanel {

    private JComponent salida;
    private Producto compra;

    public void setSalida(JComponent panel) {
        if (this.salida != null) this.remove(this.salida);
        this.salida = panel;
        this.add(panel, BorderLayout.CENTER);
    }

    public JComponent getSalida() {
        JComponent aux = this.salida;
        this.salida = null;
        return aux;
    }

    public PanelSalida(){
        compra = null;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(this.getWidth(), 150));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.darkGray);
        g.fillRect((int)(0.3*this.getWidth()), (int)(0.2*this.getHeight()), (int)(0.4*this.getWidth()), (int)(0.55*this.getHeight()));
        this.paintComponents(g);
    }
}
