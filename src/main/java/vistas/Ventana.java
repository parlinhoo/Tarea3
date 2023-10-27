package vistas;
import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {

    private PanelPrincipal panelPrincipal;

    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        panelPrincipal = new PanelPrincipal();
        this.add(panelPrincipal, BorderLayout.CENTER);
        this.setTitle("Tarea 3");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setVisible(true);
    }
}