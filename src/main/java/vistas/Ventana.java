package vistas;
import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    public static int altura = 800;
    public static int anchura = 1000;

    private PanelPrincipal panelPrincipal;

    public Ventana(){
        super("Tarea 3");
        this.setLayout(new BorderLayout());
        panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Ventana.anchura,Ventana.altura);
        this.setVisible(true);
    }
}