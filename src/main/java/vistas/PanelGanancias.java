package vistas;

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
        for (Moneda moneda : ultimasMonedas) {
            PanelMoneda panelMoneda = new PanelMoneda(50, this.getHeight() / 10, moneda.getValor(), "");
            add(panelMoneda);
        }
        setPreferredSize(new Dimension(50, getHeight()));
        revalidate();
        repaint();
    }

    public PanelGanancias(Expendedor exp) {
        this.exp = exp;
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new GridLayout(10, 1));
        actualizarGanancias();
    }
}
