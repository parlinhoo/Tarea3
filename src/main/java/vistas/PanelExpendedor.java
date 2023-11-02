package vistas;
import modelos.objetos.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {

    private int producto = 0;
    public int getProducto() {
        return producto;
    }
    public void cambiarProducto(int producto) {
        this.producto = producto;
    }
    private Expendedor exp;

    public Expendedor getExpendedor() {
        return this.exp;
    }
    private PanelDepositos DepositosPanel;

    public PanelDepositos getDepositosPanel() {
        return this.DepositosPanel;
    }
    private PanelSeleccion SeleccionPanel;
    private PanelSalida SalidaPanel;

    public void ponerPanelEnSalida(JComponent panel) {
        this.SalidaPanel.setSalida(panel);
    }
    public JComponent obtenerPanelEnSalida() {
        return this.SalidaPanel.getSalida();
    }

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
}
