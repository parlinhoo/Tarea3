package vistas;

import javax.swing.*;
import java.awt.*;

/**
 * PanelMoneda representa una moneda con su valor y serie.
 */
public class PanelMoneda extends JPanel {
    public static Font font = new Font("customDialog", Font.PLAIN, 10);
    private final int valor;
    public final JLabel labelValor;
    public final JLabel labelSerie;

    /**
     * Constructor para PanelMoneda. Inicializa el panel con el ancho, alto, valor y serie dados
     * @param ancho El ancho del panel de moneda.
     * @param alto  El alto del panel de moneda.
     * @param valor El valor de la moneda.
     * @param serie La serie de la moneda.
     */
    public PanelMoneda(int ancho, int alto, int valor, String serie) {
        super();
        this.valor = valor;
        this.setLayout(null);
        this.setSize(ancho, alto);
        this.labelValor = new JLabel(String.format("$%d", valor));
        this.labelValor.setFont(font.deriveFont(alto * (float) 0.3));
        this.labelValor.setHorizontalAlignment(SwingConstants.CENTER);
        this.labelValor.setVerticalAlignment(SwingConstants.CENTER);
        this.add(this.labelValor);
        UtilsFrame.boundsPorcentual(this.labelValor, 0.05, 0.3, 0.9, 0.3);
        this.labelSerie = new JLabel(serie);
        this.labelSerie.setFont(font.deriveFont(alto * (float) 0.15));
        this.labelSerie.setHorizontalAlignment(SwingConstants.CENTER);
        this.labelSerie.setVerticalAlignment(SwingConstants.CENTER);
        this.add(this.labelSerie);
        UtilsFrame.boundsPorcentual(this.labelSerie, 0.1, 0.6, 0.8, 0.2);
        this.setOpaque(false);
    }

    /**
     * Sobrescribe el método paint para personalizar el dibujo del panel de moneda.
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        double offsetScale = 0.03;
        super.paint(g);
        Color color = new Color(0xCD7F32);
        switch (this.valor) {
            case 500 -> color = Color.lightGray;
            case 1000 -> color = Color.ORANGE;
            case 1500 -> color = new Color(0xEEEEEE);
        }
        g.setColor(color);
        g.fillOval(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.DARK_GRAY);
        g.drawOval(0, 0, this.getWidth(), this.getHeight());
        g.drawOval((int)(this.getWidth()*offsetScale), (int)(this.getHeight()*offsetScale), (int)(this.getWidth()*(1-2*(offsetScale))), (int)(this.getHeight()*(1-2*(offsetScale))));
        this.paintComponents(g);
    }
}

