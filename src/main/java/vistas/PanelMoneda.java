package vistas;

import javax.swing.*;
import java.awt.*;

public class PanelMoneda extends JPanel {
    public static int radio = 100;
    private JLabel texto;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(0x424242));
        g.fillOval(Ventana.anchura/2 - radio, Ventana.altura/2 - radio, radio*2, radio*2);
    }

    public PanelMoneda() {
        this.texto = new JLabel("$100", SwingConstants.CENTER);
        this.add(this.texto);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}

class Ventana extends JFrame {
    public static int altura = 500;
    public static int anchura = 500;
    public Ventana(){
        super();
        this.setSize(anchura, altura);
        this.setTitle("nashe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(new PanelMoneda());
    }
}