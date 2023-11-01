package vistas;
import modelos.objetos.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {

    private Expendedor exp;
    private PanelDepositos DepositosPanel;
    private PanelSeleccion SeleccionPanel;
    private PanelSalida SalidaPanel;

    public PanelExpendedor(){
        int cantidadProductos;
        cantidadProductos = 10;
        this.exp = new Expendedor(cantidadProductos);
        this.DepositosPanel = new PanelDepositos(exp, cantidadProductos);
        this.SeleccionPanel = new PanelSeleccion();
        this.SalidaPanel = new PanelSalida();
        setLayout(new BorderLayout());
        add(DepositosPanel, BorderLayout.CENTER);
        add(SalidaPanel, BorderLayout.SOUTH);
        add(SeleccionPanel, BorderLayout.EAST);
    }

    public void paint(Graphics g){
        super.paint(g);
    }
}
