package vistas;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    private PanelComprador compradorPanel;
    private PanelExpendedor expendedorPanel;

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