package vistas;
import modelos.monedas.*;
import modelos.objetos.Comprador;
import modelos.objetos.Expendedor;
import modelos.productos.InfoProducto;
import modelos.productos.Producto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelComprador extends JPanel {
    private int monedaSelec = 0;

    private InfoProducto productoEnMaquina = null;
    private PanelExpendedor expendedorActual;
    public void setExpendedorActual(PanelExpendedor exp) {
        this.expendedorActual = exp;
    }
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
        //panelGeneralMonedas.setOpaque(false);
        this.add(panelGeneralMonedas);
        UtilsFrame.boundsPorcentual(panelGeneralMonedas, 0, 0, 1, 0.2);
        panelGeneralMonedas.setLayout(null);
        panelGeneralMonedas.setOpaque(false);

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
                this.repaint();
                for (JButton boton : botones) {
                    boton.setBackground(new Color(238, 238, 238));
                }
                buttonLocal.setBackground(Color.GREEN);
                this.monedaSelec = Integer.parseInt(buttonLocal.getText().substring(1));
            });
        }

        // PANEL DE INTERACCIONES
        JPanel panelInterraciones = new JPanel();
        this.add(panelInterraciones);
        UtilsFrame.boundsPorcentual(panelInterraciones, 0, 0.2, 1, 0.1);
        panelInterraciones.setLayout(null);
        panelInterraciones.setOpaque(false);

        // BOTONES DE COMPRAR Y RETIRAR PRODUCTO
        JButton comprar = new JButton("Comprar producto");
        JButton retirar = new JButton("Retirar producto de máquina");
        panelInterraciones.add(comprar);
        panelInterraciones.add(retirar);
        UtilsFrame.tamanoPorcentual(comprar, 0.4, 0.5);
        UtilsFrame.tamanoPorcentual(retirar, 0.4, 0.5);
        UtilsFrame.moverConCentroPorcentual(comprar, 0.275, 0.5);
        UtilsFrame.moverConCentroPorcentual(retirar, 0.725, 0.5);
        comprar.setVisible(true);
        retirar.setVisible(true);

        // ACCION DE BOTON DE COMPRAR
        comprar.addActionListener((l) -> {
            if (this.monedaSelec == 0 || this.expendedorActual.getProducto() == 0) return;
            Moneda moneda;
            switch (monedaSelec) {
                case 100 -> moneda = new Moneda100();
                case 500 -> moneda = new Moneda500();
                case 1000 -> moneda = new Moneda1000();
                case 1500 -> moneda = new Moneda1500();
                default -> {return;}
            }
            if (this.productoEnMaquina != null) return;
            try {
                System.out.println("Intentando comprar la opción " + this.expendedorActual.getProducto() + " con una moneda de " + moneda.getSerie() + "...");
                Comprador comp = new Comprador(moneda, this.expendedorActual.getProducto(), this.expendedorActual.getExpendedor());
                this.expendedorActual.getDepositosPanel().borrarUnProducto(this.expendedorActual.getProducto());
                InfoProducto prod = null;
                for (InfoProducto producto : InfoProducto.values()) {
                    if (producto.name().toLowerCase().equals(comp.queConsumiste())) {
                        prod = producto;
                    }
                }
                VistaProducto vista = new VistaProducto(prod, comp.getSerie());
                this.expendedorActual.ponerPanelEnSalida(vista);
                this.productoEnMaquina = prod;
                this.expendedorActual.getGananciasPanel().actualizarGanancias();
                System.out.println("Compra exitosa: " + prod.name() + "(Serie " + comp.getSerie() + ")");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // PANTALLA DE CANTIDAD DE PRODUCTOS COMPRADOS
        JLabel tituloBolsillo = new JLabel("Productos comprados:");
        this.add(tituloBolsillo);
        UtilsFrame.boundsPorcentual(tituloBolsillo, 0, 0.3, 1, 0.03);
        tituloBolsillo.setVerticalAlignment(SwingConstants.CENTER);
        tituloBolsillo.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel panelBolsillo = new JPanel();
        panelBolsillo.setOpaque(false);
        panelBolsillo.setLayout(new GridLayout(2, 0));
        this.add(panelBolsillo);
        UtilsFrame.boundsPorcentual(panelBolsillo, 0, 0.33, 1, 0.2);


        retirar.addActionListener((l) -> {
            if (this.productoEnMaquina == null) return;
            JComponent panel = this.expendedorActual.obtenerPanelEnSalida();
            panel.getParent().remove(panel);
            panelBolsillo.add(new VistaProducto(this.productoEnMaquina, 1));
            this.productoEnMaquina = null;
            this.expendedorActual.repaint();
            this.repaint();
            panelBolsillo.revalidate();
        });
    }
}
