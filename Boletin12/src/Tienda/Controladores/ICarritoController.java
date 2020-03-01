package Tienda.Controladores;

import Tienda.Modelos.LineaArticulo;

public interface ICarritoController {
    LineaArticulo[] getaVector();

    byte getbContadorArray();

    boolean add(LineaArticulo oObject, Tienda tienda);

    boolean remove(LineaArticulo oObject);

    int search(LineaArticulo oObject);

    String printAll();

    boolean update(LineaArticulo oObjeto, int iPosicion);
}
