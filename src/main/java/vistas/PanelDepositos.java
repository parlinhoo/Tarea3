package vistas;

import modelos.objetos.*;
import modelos.productos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * PanelDepositos es la representación de la parte "interna" del Expendedor, lo que se ve detrás de la vitrina
 * Permite ver los productos en los depositos y las ganancias
 * Los depósitos pueden rellenarse haciendo clic en el panel.
 */
public class PanelDepositos extends JPanel {
    private ArrayList<ArrayList<VistaProducto>> depositos;

    /**
     * Elimina un producto del depósito especificado.
     *
     * @param deposito El número del depósito del que se eliminará el producto.
     */
    public void borrarUnProducto(int deposito) {
        ArrayList<VistaProducto> dep = this.depositos.get(deposito-1);
        if (dep == null) return;
        VistaProducto vista = dep.remove(dep.size()-1);
        vista.setVisible(false);
    }

    /**
     * Constructor para PanelDepositos.
     * @param exp      El expendedor del que se mostrarán los depósitos.
     * @param cantidad La cantidad de columnas en el panel de depósitos.
     */
    public PanelDepositos(Expendedor exp, int cantidad) {
        this.setLayout(new GridLayout(0, cantidad));
        this.setBackground(Color.DARK_GRAY);
        int numColumnas = cantidad;
        ArrayList<Deposito<?>> productos = exp.getDepositos();
        this.depositos = new ArrayList<>();

        // Creación y llenado de la representacion de los depósitos en el panel
        for (int i = 0; i < 5; i++) {
            this.depositos.add(new ArrayList<>());
            Deposito<?> productoDeposito = productos.get(i);
            InfoProducto info = InfoProducto.values()[i];
            for (int j = 0; j < numColumnas; j++){
                if (productoDeposito.ver(j) != null){
                    Producto producto = (Producto) productoDeposito.ver(j);
                    VistaProducto vistaProducto = new VistaProducto(info);
                    add(vistaProducto);
                    this.depositos.get(i).add(vistaProducto);
                } else{
                    add(new JPanel());
                }
            }
        }

        // Manejador de eventos para recargar depósitos al hacer clic en el panel
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                exp.reabastecerDepositos();
                removeAll();
                depositos = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    depositos.add(new ArrayList<>());
                    Deposito<?> productoDeposito = productos.get(i);
                    InfoProducto info = InfoProducto.values()[i];
                    // Recarga de los depósitos en el panel
                    for (int j = 0; j < numColumnas; j++){
                        if (productoDeposito.ver(j) != null){
                            Producto producto = (Producto) productoDeposito.ver(j);
                            VistaProducto vistaProducto = new VistaProducto(info);
                            add(vistaProducto);
                            depositos.get(i).add(vistaProducto);
                        } else{
                            add(new JPanel() {
                                {
                                    setBackground(Color.DARK_GRAY);
                                }
                            });
                        }
                    }
                }
                revalidate();
                repaint();
                System.out.println("Depósitos vacíos reabastecidos");
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
