package Tienda.Controladores;

import Tienda.Modelos.Articulo;
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
        int iPosicion = tienda.getArticuloController().search(oObject.getArticulo());
        Articulo[] aux = tienda.getArticuloController().getaVector();

        if (contadorCarrito < MAXCARRITO && search(oObject) == -1 && aux[iPosicion].getStock() >= oObject.getCantidad()){
            aux[iPosicion].setStock((short) (aux[iPosicion].getStock() - oObject.getCantidad()));
            vLineaArticulos[contadorCarrito] = oObject;
            contadorCarrito++;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public void vaciarCarrito(){
        LineaArticulo[] lineaArticulosAux = new LineaArticulo[MAXCARRITO];
        contadorCarrito = 0;
    }

    @Override
    public int comprarCarrito(){
        int iImporteCarrito = 0;
        for (int i = 0; i < contadorCarrito; i++){
            iImporteCarrito += vLineaArticulos[i].getCantidad() * vLineaArticulos[i].getArticulo().getPrecio();
        }
        vaciarCarrito();
        return iImporteCarrito;
    }

    @Override
    public boolean remove(LineaArticulo oObject) {
        boolean bExito = false;
        int iPosicion = search(oObject);
        if (iPosicion != -1) {
            for (int i = iPosicion; i < contadorCarrito; i++)
                vLineaArticulos[i] = vLineaArticulos[i+1];
            vLineaArticulos[contadorCarrito] = null;
            contadorCarrito--;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int search(LineaArticulo oObject) {
        int iPosicion = -1;
        int iContador = 0;
        while (iPosicion == -1 && iContador < contadorCarrito) {
            if (oObject.getArticulo().equals(vLineaArticulos[iContador].getArticulo()))
                iPosicion = iContador;
            iContador++;
        }
        return iPosicion;
    }

    @Override
    public String printAll() {
        String salida = "";
        if (contadorCarrito == 0)
            salida = "No hay nada en el carrito";
        else {
            for (int i = 0; i < contadorCarrito; i++)
                salida += vLineaArticulos[i]+"\n";
        }
        return salida;
    }
}
