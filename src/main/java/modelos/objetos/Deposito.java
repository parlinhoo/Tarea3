package modelos.objetos;

import java.util.ArrayList;
/**
 * Deposito genérico para productos o monedas
 * @author Bastián Ceballos Z.
 * @author Fabián González U.
 */
public class Deposito<type> {
    /** ArrayList que almacena los items*/
    private final ArrayList<type> arrayList;

    /**
     * Agrega un item al deposito
     * @param item item a agregar
     */
    public void add(type item) {this.arrayList.add(item);}

    /**
     * Getter de un item, devuelve el primer item del ArrayList
     * @return Un item si el ArrayList no está vacio, en caso contrario, retorna null
     */
    public type get() {
        if (!this.arrayList.isEmpty()) return this.arrayList.remove(0);
        else return null;
    }

    /**
     * Permite acceder a un elemento sin modificar el deposito
     * @return Un item si el ArrayList no está vacio, en caso contrario, retorna null
     */
    public type ver(int i) {
        if (!this.arrayList.isEmpty()) return this.arrayList.get(i);
        else return null;
    }

    /**Constructor por defecto */
    public Deposito() {this.arrayList = new ArrayList<>();}
}
