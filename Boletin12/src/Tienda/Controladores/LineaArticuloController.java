package Tienda.Controladores;

import Tienda.Modelos.Articulo;
import Tienda.Modelos.LineaArticulo;

public class LineaArticuloController implements ICrud<LineaArticulo> {
    private LineaArticulo[] vLineaArticulos;
    private byte contadorLineaArticulos;
    private final byte MAXLINEAARTICULOS = 100;

    public LineaArticuloController(){
        vLineaArticulos = new LineaArticulo[MAXLINEAARTICULOS];
        contadorLineaArticulos = 0;
    }

    @Override
    public LineaArticulo[] getaVector() {
        return vLineaArticulos;
    }

    @Override
    public byte getbContadorArray() {
        return contadorLineaArticulos;
    }

    @Override
    public boolean add(LineaArticulo oObject) {
        boolean bExito = false;
        if (oObject.getIdCarrito() != 0 && contadorCarritos < MAXCARRITOS && search(oObject) == -1){
            vCarritos[contadorCarritos] = oObject;
            contadorCarritos++;
            bExito = true;
        }
        return bExito;
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
