package vistas;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    private PanelComprador compradorPanel;
    private PanelExpendedor expendedorPanel;

    public PanelPrincipal(){
        this.setSize(Ventana.anchura, Ventana.altura);
        compradorPanel = new PanelComprador();
        expendedorPanel = new PanelExpendedor();
        this.setLayout(null);
        this.add(compradorPanel);
        this.add(expendedorPanel);
        UtilsFrame.boundsPorcentual(compradorPanel, 0.0035, 0, 0.5-0.0035, 1);
        UtilsFrame.boundsPorcentual(expendedorPanel, 0.5, 0, 0.5-0.01, 1);

        JPanel panelFlow = new JPanel();
        panelFlow.setLayout(null);
        PanelMoneda a1 = new PanelMoneda(50, 50, 100, "AAA");
        PanelMoneda a2 = new PanelMoneda(50, 50, 100, "AAA2");
        PanelMoneda a3 = new PanelMoneda(50, 50, 100, "AAA3");
        PanelMoneda a4 = new PanelMoneda(50, 50, 100, "AAA4");
        PanelMoneda a5 = new PanelMoneda(50, 50, 100, "AAA5");
        panelFlow.add(a1);
        panelFlow.add(a2);
        panelFlow.add(a3);
        panelFlow.add(a4);
        panelFlow.add(a5);
        UtilsFrame.boundsPorcentual(panelFlow, compradorPanel,0, 0, 1, 0.5);
        UtilsFrame.moverConCentroPorcentualAnchorPoint(a1, 0.5, 0, 0.1, 0);
        UtilsFrame.moverConCentroPorcentualAnchorPoint(a2, 0.5, 0, 0.3, 0);
        UtilsFrame.moverConCentroPorcentualAnchorPoint(a3, 0.5, 0, 0.5, 0);
        UtilsFrame.moverConCentroPorcentualAnchorPoint(a4, 0.5, 0, 0.7, 0);
        UtilsFrame.moverConCentroPorcentualAnchorPoint(a5, 0.5, 0, 0.9, 0);
        compradorPanel.add(panelFlow);
        panelFlow.setVisible(true);
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        expendedorPanel.paint(g);
        compradorPanel.paint(g);

    }
}