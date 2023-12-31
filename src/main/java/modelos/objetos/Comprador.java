package modelos.objetos;

import modelos.NoHayProductoException;
import modelos.PagoIncorrectoException;
import modelos.PagoInsuficienteException;
import modelos.productos.Producto;
import modelos.monedas.Moneda;

/**
 * Comprador usuario de un Expendedor
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */
public class Comprador {
    /** String para almacenar que compró en el expendedor*/
    private String producto;
    /** Entero para almacenar el vuelto que se recibe al comprar en el expendedor */
    private int vuelto = 0;
    private int serie = 0;

    /**
     * Getter del valor del vuelto
     * @return Entero equivalente al valor del uuelto
     */
    public int cuantoVuelto() {return vuelto;}

    /**
     * Getter del String producto
     * @return String propio de lo consumido
     */
    public String queConsumiste() {return producto;}
    public int getSerie() {return this.serie;}

    /**
     * Constructor en el que se intenta comprar en un expendedor con una moneda, si la compra es exitosa, se consume lo comprado, y se recibe el vuelto, guardando ambas varibales
     * @param m Moneda con la que comprar
     * @param cualProducto Producto a comprar
     * @param exp Expendedor en el que comprar
     * @throws PagoInsuficienteException
     * @throws PagoIncorrectoException
     * @throws NoHayProductoException
     * @see Moneda
     * @see Expendedor
     */
    public Comprador(Moneda m, int cualProducto, Expendedor exp) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        exp.comprarProducto(m, cualProducto);
        Producto producto = exp.getProducto();
        if (producto != null) {
            this.producto = producto.consumir();
            this.serie = producto.getSerie();
        }
        Moneda monedaV = exp.getVuelto();
        while (monedaV != null) {
            this.vuelto += monedaV.getValor();
            monedaV = exp.getVuelto();
        }
    }
}
