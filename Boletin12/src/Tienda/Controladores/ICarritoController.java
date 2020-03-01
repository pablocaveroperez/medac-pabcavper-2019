package Tienda.Controladores;

import Tienda.Modelos.LineaArticulo;

public interface ICarritoController {
    LineaArticulo[] getaVector();

    byte getbContadorArray();

    boolean add(LineaArticulo oObject, Tienda tienda);

    void vaciarCarrito();

    int comprarCarrito();

    boolean remove(LineaArticulo oObject);

    int search(LineaArticulo oObject);

    String printAll();
}
