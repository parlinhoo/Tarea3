package vistas;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelComprador extends JPanel {
    private int monedaSelec;
    public int getMonedaSeleccionada() {
        return this.monedaSelec;
    }

    public PanelComprador(int ancho, int alto){
        // PANEL COMPRADOR
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(ancho, alto);
        this.setBackground(new Color(135, 206, 250));

        // PANEL DE MONEDAS
        JPanel panelGeneralMonedas = new JPanel();
        panelGeneralMonedas.setOpaque(false);
        this.add(panelGeneralMonedas);
        UtilsFrame.boundsPorcentual(panelGeneralMonedas, 0, 0, 1, 0.2);
        panelGeneralMonedas.setVisible(true);
        panelGeneralMonedas.setLayout(null);

        // MONEDAS
        int anchoMoneda = (int) (0.15*ancho);
        PanelMoneda m1 = new PanelMoneda(anchoMoneda, anchoMoneda, 100, "");
        PanelMoneda m2 = new PanelMoneda(anchoMoneda, anchoMoneda, 500, "");
        PanelMoneda m3 = new PanelMoneda(anchoMoneda, anchoMoneda, 1000, "");
        PanelMoneda m4 = new PanelMoneda(anchoMoneda, anchoMoneda, 1500, "");
        ArrayList<PanelMoneda> monedas = new ArrayList<>();
        monedas.add(m1);
        monedas.add(m2);
        monedas.add(m3);
        monedas.add(m4);

        // BOTONES DE MONEDAS
        JButton b1 = new JButton("$100");
        JButton b2 = new JButton("$500");
        JButton b3 = new JButton("$1000");
        JButton b4 = new JButton("$1500");
        ArrayList<JButton> botones = new ArrayList<>();
        botones.add(b1);
        botones.add(b2);
        botones.add(b3);
        botones.add(b4);

        // ASIGNACION DE POSICIONES Y ACTION LISTENERS
        for (int i = 0; i < botones.size(); i++) {
            PanelMoneda monedaLocal = monedas.get(i);
            panelGeneralMonedas.add(monedaLocal);
            UtilsFrame.moverConCentroPorcentualAnchorPoint(monedaLocal, 0.5, 0, (double) (i+1)/5.0, 0.05);
            JButton buttonLocal = botones.get(i);
            panelGeneralMonedas.add(buttonLocal);
            UtilsFrame.tamanoPorcentual(buttonLocal, 0.175, 0.25);
            UtilsFrame.moverConCentroPorcentualAnchorPoint(buttonLocal, 0.5, 0, (double) (i+1)/5.0, 0.6);
            buttonLocal.addActionListener((l) -> {
                for (JButton boton : botones) {
                    boton.setBackground(new Color(238, 238, 238));
                }
                buttonLocal.setBackground(Color.GREEN);
                this.monedaSelec = Integer.parseInt(buttonLocal.getText().substring(1));
            });
        }
    }

    public void paint(Graphics g){
        super.paint(g);
    }
}
