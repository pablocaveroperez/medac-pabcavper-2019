package Tienda.Controladores;

import Tienda.Modelos.LineaArticulo;

public class CarritoController implements ICarritoController {
    private LineaArticulo[] vLineaArticulos;
    private byte contadorCarrito;
    private final byte MAXCARRITO = 100;

    public CarritoController() {
        vLineaArticulos = new LineaArticulo[MAXCARRITO];
        contadorCarrito = 0;
    }

    @Override
    public LineaArticulo[] getaVector() {
        return vLineaArticulos;
    }

    @Override
    public byte getbContadorArray() {
        return contadorCarrito;
    }

    @Override
    public boolean add(LineaArticulo oObject, Tienda tienda) {
        boolean bExito = false;
        if (contadorCarrito < MAXCARRITO && search(oObject) == -1 && )
    }

    @Override
    public boolean remove(LineaArticulo oObject) {
        return false;
    }

    @Override
    public int search(LineaArticulo oObject) {
        return 0;
    }

    @Override
    public String printAll() {
        return null;
    }

    @Override
    public boolean update(LineaArticulo oObjeto, int iPosicion) {
        return false;
    }
}
