package vistas;

import jdk.jshell.execution.Util;
import modelos.monedas.*;
import modelos.objetos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelGanancias extends JPanel {

    private Expendedor exp;

    public void actualizarGanancias() {
        removeAll();
        Deposito<Moneda> ganancias = exp.getGanancias();
        ArrayList<Moneda> ultimasMonedas = new ArrayList<>();
        int indiceUltimo = Math.max(ganancias.cuantasCosas() - 10, 0);
        for (int i = indiceUltimo; i < ganancias.cuantasCosas(); i++) {
            Moneda moneda = ganancias.ver(i);
            if (moneda != null) {
                ultimasMonedas.add(moneda);
            }
        }
        for (int i = 0; i < ultimasMonedas.size(); i++) {
            PanelMoneda panelMoneda = new PanelMoneda(this.getHeight() / 11, this.getHeight() / 11, ultimasMonedas.get(i).getValor(), "");
            this.add(panelMoneda);
            UtilsFrame.moverConCentroPorcentualAnchorPoint(panelMoneda, 0.5, 1, 0.5,(i+1)*0.1);
        }
        setPreferredSize(new Dimension(50, getHeight()));
        revalidate();
        repaint();
    }

    public PanelGanancias(Expendedor exp) {
        this.exp = exp;
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        actualizarGanancias();
    }
}
