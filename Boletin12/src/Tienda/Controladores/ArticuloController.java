package Tienda.Controladores;

import Tienda.Modelos.Articulo;

public class ArticuloController implements ICrud<Articulo> {
    private Articulo[] vArticulos;
    private byte contadorArticulos;
    private final byte MAXARTICULOS = 60;

    public ArticuloController(){
        vArticulos = new Articulo[MAXARTICULOS];
        contadorArticulos = 0;
    }

    @Override
    public Articulo[] getaVector() {
        return vArticulos;
    }

    @Override
    public byte getbContadorArray() {
        return contadorArticulos;
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

    @Override
    public boolean add(Articulo oObject) {
        boolean bExito = false;
        if (oObject.getId() != 0 && contadorArticulos < MAXARTICULOS && search(oObject) == -1){
            vArticulos[contadorArticulos] = oObject;
            contadorArticulos++;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean remove(Articulo oObject) {
        boolean bExito = false;
        int iPosicion = search(oObject);
        if (iPosicion != -1){
            for (int i = iPosicion; i < contadorArticulos; i++)
                vArticulos[i-1] = vArticulos[i];
            vArticulos[contadorArticulos] = null;
            contadorArticulos--;
            bExito = true;
        }
        return bExito;
    }
}
