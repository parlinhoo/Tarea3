package modelos.objetos;

import modelos.*;
import modelos.monedas.*;
import modelos.productos.*;
import modelos.productos.bebidas.*;
import modelos.productos.dulces.*;

import java.util.ArrayList;

/**
 * Expendedor en el que se puede comprar un producto entre 5 variedaes
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */

public class Expendedor {
    /** Deposito Especial de salida */
    private Producto DepositoSalida;
    /** Deposito de CocaCola */
    private Deposito<Bebida> coca;
    /** Deposito de Sprite */
    private Deposito<Bebida> sprite;
    /** Deposito de Fanta */
    private Deposito<Bebida> fanta;
    /** Deposito de Snickers */
    private Deposito<Dulce> snickers;
    /** Deposito de Super8 */
    private Deposito<Dulce> super8;
    /** Deposito de monedas */
    private Deposito<Moneda> monVu;
    /** Deposito de ganancias */
    private Deposito<Moneda> ganancias;
    /** Entero que almacena la cantidad inicial de producto en cada deposito */
    private int cantidadProd;

    /**
     * Devuelve el vuelto de la compra
     * @return La misma moneda si no se pudo comprar o una moneda de 100 como sencillo de cambio
     */
    public Moneda getVuelto() {return monVu.get();}

    /**
     * Intenta comprar un producto con una moneda
     * @param moneda Moneda con la que comprar
     * @param producto Producto a comprar
     * @return Un producto si se pudo comprar, de lo contario, null
     * @throws PagoIncorrectoException
     * @throws PagoInsuficienteException
     * @throws NoHayProductoException
     * @see Moneda
     */
    public void comprarProducto(Moneda moneda, int producto) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        if (moneda == null) {
            throw new PagoIncorrectoException("Se esperaba una moneda, se obtuvo null");
        }
        int valor = moneda.getValor();
        InfoProducto info = null;
        for (InfoProducto prod : InfoProducto.values()) {
            if (producto == prod.getNum()) {
                info = prod;
                break;
            }
        }
        if (info == null) {
            this.monVu.add(moneda);
            throw new NoHayProductoException("Número de producto no existe");
        }
        if (info.getPrecio() > valor) {
            this.monVu.add(moneda);
            throw new PagoInsuficienteException("Dinero insuficiente");
        }
        Producto selProducto;
        switch (info) {
            case COCACOLA -> {selProducto = coca.get();}
            case FANTA -> {selProducto = fanta.get();}
            case SPRITE -> {selProducto = sprite.get();}
            case SUPER8 -> {selProducto = super8.get();}
            case SNICKERS -> {selProducto = snickers.get();}
            default -> {selProducto = null;}
        }
        if (selProducto == null) {
            this.monVu.add(moneda);
            throw new NoHayProductoException(String.format("No queda más %s en el depósito", info.name()));
        }
        int vuelto = valor - info.getPrecio();
        for (int i = 0; i < vuelto; i += 100) {
            monVu.add(new Moneda100());
        }
        ganancias.add(moneda);
        DepositoSalida = selProducto;
    }

    /**
     * Saca el producto comprado de la bandeja de salida
     * @return El porducto en la  bandeja de salida
     * @see Producto
     */
    public Producto getProducto(){
        Producto aux = DepositoSalida;
        DepositoSalida = null;
        return aux;
    }

    /**
     * Getter de los depositos de producto
     * @return un ArrayList con todos los depositos de productos
     * @see Deposito
     */
    public ArrayList<Deposito<?>> getDepositos() {
        ArrayList<Deposito<?>> Depositos = new ArrayList<>();
        Depositos.add(coca);
        Depositos.add(sprite);
        Depositos.add(fanta);
        Depositos.add(snickers);
        Depositos.add(super8);
        return Depositos;
    }

    /**
     * Permite aceder al deposito de ganancias
     * @return El deposito de ganancias
     * @see Deposito
     */
    public Deposito<Moneda> getGanancias() {
        return ganancias;
    }

    /**
     * Rellena los depositos de producto que estén vacíos, si un deposito no está vacio ni lleno, se rellena con null por conveniencia
     * @see Deposito
     */
    public void reabastecerDepositos() {
        if (coca.ver(0) == null) {
            coca.vaciar();
            coca.setVecesReabastecido(coca.getVecesReabastecido() + 1);
            for (int i = 0; i < cantidadProd; i++) {
                coca.add(new CocaCola(100 + i + cantidadProd*coca.getVecesReabastecido()));
            }
        }else{
            for (int i = coca.cuantasCosas()-1; i < cantidadProd; i++) {
                coca.add(null);
            }
        }
        if (sprite.ver(0) == null) {
            sprite.vaciar();
            sprite.setVecesReabastecido(sprite.getVecesReabastecido() + 1);
            for (int i = 0; i < cantidadProd; i++) {
                sprite.add(new Sprite(100 + i + cantidadProd*sprite.getVecesReabastecido()));
            }
        }else{
            for (int i = sprite.cuantasCosas(); i < cantidadProd; i++) {
                sprite.add(null);
            }
        }
        if (fanta.ver(0) == null) {
            fanta.vaciar();;
            fanta.setVecesReabastecido(fanta.getVecesReabastecido() + 1);
            for (int i = 0; i < cantidadProd; i++) {
                fanta.add(new Fanta(100 + i + cantidadProd*fanta.getVecesReabastecido()));
            }
        }else{
            for (int i = fanta.cuantasCosas(); i < cantidadProd; i++) {
                fanta.add(null);
            }
        }
        if (super8.ver(0) == null) {
            super8.vaciar();
            super8.setVecesReabastecido(super8.getVecesReabastecido() + 1);
            for (int i = 0; i < cantidadProd; i++) {
                super8.add(new Super8(100 + i + cantidadProd*super8.getVecesReabastecido()));
            }
        }else{
            for (int i = super8.cuantasCosas(); i < cantidadProd; i++) {
                super8.add(null);
            }
        }
        if (snickers.ver(0) == null) {
            snickers.vaciar();;
            snickers.setVecesReabastecido(snickers.getVecesReabastecido() + 1);
            for (int i = 0; i < cantidadProd; i++) {
                snickers.add(new Snickers(100 + i + cantidadProd*snickers.getVecesReabastecido()));
            }
        }else{
            for (int i = snickers.cuantasCosas(); i < cantidadProd; i++) {
                snickers.add(null);
            }
        }
    }

    /**
     * Constructor en que se llenan los depositos de cada producto con la cantidad pasada como parametro
     * @param cantidadProd
     */
    public Expendedor(int cantidadProd) {
        this.cantidadProd = cantidadProd;
        this.DepositoSalida = null;
        this.ganancias = new Deposito<Moneda>();
        this.coca = new Deposito<Bebida>();
        this.fanta = new Deposito<Bebida>();
        this.sprite = new Deposito<Bebida>();
        this.super8 = new Deposito<Dulce>();
        this.snickers = new Deposito<Dulce>();
        this.monVu = new Deposito<Moneda>();
        for (int i = 0; i < cantidadProd; i++) {
            coca.add(new CocaCola(100+i));
            sprite.add(new Sprite(200+i));
            fanta.add(new Fanta(300+i));
            super8.add(new Super8(400+i));
            snickers.add(new Snickers(500+i));
        }
    }
}
