package modelos.productos;

import java.awt.*;

/** Enumeración con los datos de los productos disponibles en un expendedor */
public enum InfoProducto {
    /** Datos de una CocaCola, con numero 1 en el expendedor y precio 800 (Color rojo y letras blancas) */
    COCACOLA(1, 800, Color.RED, Color.WHITE),
    /** Datos de una Sprite, con numero 2 en el expendedor y precio 800 (Color verde) */
    SPRITE(2, 800, new Color(7, 148, 57), Color.WHITE),
    /** Datos de una Fanta, con numero 3 en el expendedor y precio 800 (Color naranjo) */
    FANTA(3, 800, new Color(255, 104, 17), Color.BLUE),
    /** Datos de un Snickers con numero 4 en el expendedor y precio 1200 (Color cafe) */
    SNICKERS(4,1200, new Color(56, 20, 9), Color.BLUE),
    /** Datos de un Snickers con numero 5 en el expendedor y precio 600 (Color negro) */
    SUPER8(5,600, Color.BLACK, Color.ORANGE);

    /** Entero que representa el precio del producto */
    private final int precio;
    /** Entero que representa el numero del producto en el expendedor*/
    private final int numMaquina;
    /** Color que representa a un producto*/
    private final Color color;
    /** Color de las letras del producto*/
    private final Color letras;

    /**
     * Constructor por defecto, recibe el numero del producto en el expendedor y su precio
     * @param numMaquina Numero del producto en el expendedor
     * @param precio Precio del producto
     */
    private InfoProducto(int numMaquina, int precio, Color color, Color letras) {
        this.numMaquina = numMaquina;
        this.precio = precio;
        this.color = color;
        this.letras = letras;
    }

    /**
     * Getter del precio del producto
     * @return Entero equivalente al precio del producto
     */
    public int getPrecio() {
        return precio;
    }
    /**
     * Getter del numero del producto en el expendedor
     * @return Entero que representa el numero del producto en el expendedor
     */
    public int getNum() {return numMaquina;}
    /**
     * Getter del color del producto
     * @return Color del producto en el expendedor
     */
    public Color getColor() {return color;}
    /**
     * Getter del color de las letras
     * @return Color de las letras del producto
     */
    public Color getLetras() {return letras;}
}
