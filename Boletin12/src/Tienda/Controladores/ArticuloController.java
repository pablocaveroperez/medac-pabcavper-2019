package Tienda.Controladores;

import Tienda.Modelos.Articulo;

public class ArticuloController implements ICrud<Articulo> {
    private Articulo[] vArticulos;
    private byte contadorArticulos;
    private final byte MAXARTICULOS = 60;

    @Override
    public Articulo[] getaVector() {
        return vArticulos;
    }

    @Override
    public byte getbContadorArray() {
        return contadorArticulos;
    }

    @Override
    public boolean add(Articulo oObject) {
        boolean bExito = false;
        if (oObject.getId() != null && contadorArticulos < MAXARTICULOS && search(oObject) == -1){
            vArticulos[contadorArticulos] = oObject;
            contadorArticulos++;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean remove(Articulo oObject) {
        return false;
    }

    @Override
    public int search(Articulo oObject) {
        int iPosicion = -1;
        int iContador = 0;
        while(iPosicion == -1 && iContador < contadorArticulos){
            if (oObject.equals(vArticulos[iContador]))
                iPosicion = iContador;
            iContador++;
        }
        return iPosicion;
    }
}
