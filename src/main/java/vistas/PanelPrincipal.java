package vistas;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    private PanelComprador compradorPanel;
    private PanelExpendedor expendedorPanel;

    public PanelPrincipal(int ancho, int alto){
        this.setSize(ancho, alto);
        compradorPanel = new PanelComprador(ancho/2, alto);
        expendedorPanel = new PanelExpendedor(ancho/2, alto);
        this.setLayout(null);
        this.add(compradorPanel);
        this.add(expendedorPanel);
        UtilsFrame.posicionPorcentual(compradorPanel, 0, 0);
        UtilsFrame.posicionPorcentual(expendedorPanel, 0.5, 0);
        this.setVisible(true);
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        expendedorPanel.paint(g);
        compradorPanel.paint(g);
    }
}