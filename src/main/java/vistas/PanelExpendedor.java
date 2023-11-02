package vistas;
import modelos.objetos.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {

    private int producto;
    public int getProducto() {
        return producto;
    }
    public void cambiarProducto(int producto) {
        this.producto = producto;
    }
    private Expendedor exp;
    private PanelDepositos DepositosPanel;
    private PanelSeleccion SeleccionPanel;
    private PanelSalida SalidaPanel;

    public PanelExpendedor(int ancho, int alto){
        int cantidadProductos;
        cantidadProductos = 10;
        this.setSize(ancho, alto);
        this.exp = new Expendedor(cantidadProductos);
        this.DepositosPanel = new PanelDepositos(exp, cantidadProductos);
        this.SeleccionPanel = new PanelSeleccion();
        this.SeleccionPanel.panelExpendedor = this;
        this.SalidaPanel = new PanelSalida();
        setLayout(new BorderLayout());
        add(DepositosPanel, BorderLayout.CENTER);
        add(SalidaPanel, BorderLayout.SOUTH);
        add(SeleccionPanel, BorderLayout.EAST);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
    }
}
