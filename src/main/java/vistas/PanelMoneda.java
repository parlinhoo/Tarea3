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
        g.fillOval((Ventana.anchura / 2) - radio, (Ventana.altura / 2) - radio, radio*2, radio*2);
    }

    public PanelMoneda() {
        this.setLayout(new BorderLayout());
        this.setSize(Ventana.anchura, Ventana.altura);
        this.texto = new JLabel("$100");
        this.texto.setBounds((Ventana.anchura / 2) - radio, (Ventana.altura / 2) - radio, radio*2, radio*2);
        this.add(this.texto, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setVisible(true);
        ventana.setSize(Ventana.anchura, Ventana.altura);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PanelMoneda testpanel = new PanelMoneda();
        ventana.add(testpanel);
    }
}

