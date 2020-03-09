package Tienda.Controladores;

import Tienda.Modelos.Cliente;
import Tienda.Modelos.LineaArticulo;

public interface ICrud<T> {
    public T[] getaVector();
    public byte getbContadorArray();
    public boolean add(T oObject);
    public boolean remove(T oObject);
    public int search(T oObject);
    public String printAll();

    boolean update(T oObjeto, int iPosicion);
}
