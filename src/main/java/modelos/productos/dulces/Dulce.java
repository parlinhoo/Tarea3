package modelos.productos.dulces;

import modelos.productos.Producto;
/**
 * Dulces polimorfica
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */
public abstract class Dulce extends Producto {
    /**
     * Constructor por defecto en el que se pasa como parametro la serie del producto
     * @param serie Serie del producto
     */
    public Dulce(int serie) {super(serie);}
}
