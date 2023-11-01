package vistas;

import modelos.productos.*;

import javax.swing.*;
import java.awt.*;

public class VistaProducto extends JComponent {

    private InfoProducto info;
    private int serie;

    public VistaProducto(InfoProducto info, int serie) {
        this.info = info;
        this.serie = serie;
        this.setPreferredSize(new Dimension(40, 70));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(info.getColor());
        int alto;
        int ancho;
        int grados;
        if (info.getPrecio() == 800) {
            alto = 55;
            ancho = 35;
            grados = 60;
        } else {
            alto = 75;
            ancho = 20;
            grados = 90;
        }
        g.fillRect((this.getWidth()-ancho)/2, (this.getHeight()-alto)/2, ancho, alto);

        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(Math.toRadians(grados), getWidth() / 2, getHeight() / 2);
        g2d.setFont(new Font("Tahoma", Font.BOLD, 7));
        g2d.setColor(info.getLetras());
        String texto = info.name();
        g2d.drawString(texto, getWidth() / 2 - g2d.getFontMetrics().stringWidth(texto) / 2, getHeight() / 2);
    }

}
