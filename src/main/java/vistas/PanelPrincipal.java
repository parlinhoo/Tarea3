package vistas;
import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {

    private PanelComprador compradorPanel;
    private PanelExpendedor expendedorPanel;

    public PanelPrincipal () {
        compradorPanel = new PanelComprador();
        expendedorPanel = new PanelExpendedor();
        this.setLayout(new GridLayout(1, 2));
        this.add(compradorPanel);
        this.add(expendedorPanel);
        this.setBackground(Color.white);
    }

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        expendedorPanel.paint(g);
        compradorPanel.paint(g);
    }
}