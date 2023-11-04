package vistas;
import modelos.objetos.Expendedor;

import javax.swing.*;
import java.awt.*;

/**
 * PanelExpendedor representa el expendedor.
 * Permite la visualización y la interacción del usuario con el expendedor y gestiona los paneles de depósitos, selección, salida y ganancias.
 */
public class PanelExpendedor extends JPanel {

    private int producto = 0;
    private Expendedor exp;
    private PanelDepositos DepositosPanel;
    private PanelSeleccion SeleccionPanel;
    private PanelSalida SalidaPanel;
    private PanelGanancias GananciasPanel;

    /**
     * Getter del numero producto seleccionado
     * @return El número del producto seleccionado
     */
    public int getProducto() {
        return producto;
    }

    /**
     * Setter del numero producto seleccionado
     * @param producto El número del nuevo producto seleccionado
     */
    public void cambiarProducto(int producto) {
        this.producto = producto;
    }

    /**
     * Getter del expendedor asociado
     * @return Expendedor asociado
     */
    public Expendedor getExpendedor() {
        return this.exp;
    }

    /**
     * Getter del panel de depósitos asociado al panel expendedor
     * @return El panel de depósitos
     */

    public PanelDepositos getDepositosPanel() {
        return this.DepositosPanel;
    }
    /**
     * Getter del panel de ganancias asociado al panel expendedor
     * @return El panel de ganancias
     */
    public PanelGanancias getGananciasPanel() {
        return this.GananciasPanel;
    }

    /**
     * Coloca un componente en el panel de salida
     * @param panel El componente que se colocará en el panel de salida
     */
    public void ponerPanelEnSalida(JComponent panel) {
        this.SalidaPanel.setSalida(panel);
    }

    /**
     * Obtiene el componente mostrado en el panel de salida y lo quita del panel
     * @return El componente que estaba en el panel de salida
     */
    public JComponent obtenerPanelEnSalida() {
        return this.SalidaPanel.getSalida();
    }

    /**
     * Constructor para PanelExpendedor. Inicializa el panel expendedor con el ancho y alto dados
     * @param ancho El ancho del panel expendedor
     * @param alto  El alto del panel expendedor
     */
    public PanelExpendedor(int ancho, int alto){
        int cantidadProductos;
        cantidadProductos = 10;
        this.setSize(ancho, alto);
        this.exp = new Expendedor(cantidadProductos);
        this.DepositosPanel = new PanelDepositos(exp, cantidadProductos);
        this.SeleccionPanel = new PanelSeleccion();
        this.SeleccionPanel.panelExpendedor = this;
        this.SalidaPanel = new PanelSalida();
        this.GananciasPanel = new PanelGanancias(exp);
        setLayout(new BorderLayout());
        add(DepositosPanel, BorderLayout.CENTER);
        add(SalidaPanel, BorderLayout.SOUTH);
        add(SeleccionPanel, BorderLayout.WEST);
        add(GananciasPanel, BorderLayout.EAST);
        this.setVisible(true);
    }
}
