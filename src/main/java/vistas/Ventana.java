package vistas;
import modelos.objetos.Comprador;
import modelos.objetos.Expendedor;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    public static int altura = 800;
    public static int anchura = 1000;

    public Expendedor expendedor;

    private PanelPrincipal panelPrincipal;

    public Ventana(){
        super("Tarea 3");
        this.expendedor = new Expendedor(10);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Ventana.anchura, Ventana.altura);
        panelPrincipal = new PanelPrincipal(Ventana.anchura - 20, Ventana.altura - 20);
        this.add(panelPrincipal);
        this.setVisible(true);
    }
}