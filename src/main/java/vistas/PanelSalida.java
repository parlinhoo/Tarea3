package vistas;

import modelos.productos.Producto;

import javax.swing.*;
import java.awt.*;

/**
 * PanelSalida muestra lo que ha conseguido el comprador luego de una compra exitosa
 */
public class PanelSalida extends JPanel {

    private JComponent salida;

    /**
     * Setter del componente que representa el producto comprado
     * @param panel El componente que se mostrará en el panel
     */
    public void setSalida(JComponent panel) {
        if (this.salida != null) this.remove(this.salida);
        this.salida = panel;
        this.add(panel, BorderLayout.CENTER);
    }

    /**
     * Getter del componente que representa el producto comprado
     * @return El componente que se mostraba en el panel
     */
    public JComponent getSalida() {
        JComponent aux = this.salida;
        this.salida = null;
        return aux;
    }

    /**
     * Constructor para PanelSalida.
     * Inicializa el panel de salida vacio.
     */
    public PanelSalida(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(this.getWidth(), 150));
    }

    /**
     * Sobrescribe el método paint para personalizar el dibujo del panel de salida.
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.darkGray);
        g.fillRect((int)(0.3*this.getWidth()), (int)(0.2*this.getHeight()), (int)(0.4*this.getWidth()), (int)(0.55*this.getHeight()));
        this.paintComponents(g);
    }
}
