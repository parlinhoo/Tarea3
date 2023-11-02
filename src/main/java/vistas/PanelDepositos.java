package vistas;

import modelos.objetos.*;
import modelos.productos.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelDepositos extends JPanel {
    private ArrayList<ArrayList<VistaProducto>> depositos;

    public void borrarUnProducto(int deposito) {
        ArrayList<VistaProducto> dep = this.depositos.get(deposito-1);
        if (dep == null) return;
        VistaProducto vista = dep.remove(dep.size()-1);
        vista.setVisible(false);
    }

    public PanelDepositos(Expendedor exp, int cantidad) {
        this.setLayout(new GridLayout(0, cantidad));
        this.setBackground(Color.DARK_GRAY);
        int numColumnas = cantidad;
        ArrayList<Deposito<?>> productos = exp.getDepositos();
        this.depositos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            this.depositos.add(new ArrayList<>());
            Deposito<?> productoDeposito = productos.get(i);
            InfoProducto info = InfoProducto.values()[i];
            for (int j = 0; j < numColumnas; j++){
                if (productoDeposito.ver(j) != null){
                    Producto producto = (Producto) productoDeposito.ver(j);
                    int serie = producto.getSerie();
                    VistaProducto vistaProducto = new VistaProducto(info, serie);
                    add(vistaProducto);
                    this.depositos.get(i).add(vistaProducto);
                } else{
                    add(new JPanel());
                }
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
