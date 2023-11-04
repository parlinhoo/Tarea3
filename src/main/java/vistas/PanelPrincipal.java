package vistas;
import javax.swing.*;
import java.awt.*;

/**
 * PanelPrincipal representa el panel principal en la interfaz gráfica, contiene el panel de comprador y el panel de expendedor
 * Permite la visualización y la interacción del comprador con el expendedor de productos.
 */
public class PanelPrincipal extends JPanel {

    private PanelComprador compradorPanel;
    private PanelExpendedor expendedorPanel;

    /**
     * Constructor para la clase PanelPrincipal. Inicializa el panel principal con el ancho y alto dados
     * @param ancho El ancho del panel principal.
     * @param alto  El alto del panel principal.
     */
    public PanelPrincipal(int ancho, int alto){
        this.setSize(ancho, alto);
        expendedorPanel = new PanelExpendedor(ancho/2, alto);
        compradorPanel = new PanelComprador(ancho/2, alto);
        compradorPanel.setExpendedorActual(expendedorPanel);
        this.setLayout(null);
        this.add(compradorPanel);
        this.add(expendedorPanel);
        UtilsFrame.posicionPorcentual(compradorPanel, 0, 0);
        UtilsFrame.posicionPorcentual(expendedorPanel, 0.5, 0);
        this.setVisible(true);
    }
}