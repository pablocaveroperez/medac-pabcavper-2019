package Tienda.Controladores;

import Tienda.Modelos.Carrito;

public class CarritoController implements ICrud<Carrito> {
    private Carrito[] vCarritos;
    private byte contadorCarritos;
    private final byte MAXCARRITOS = 50;

    public CarritoController(){
        vCarritos = new Carrito[MAXCARRITOS];
        contadorCarritos = 0;
    }

    @Override
    public Carrito[] getaVector() {
        return vCarritos;
    }

    @Override
    public byte getbContadorArray() {
        return contadorCarritos;
    }

    @Override
    public boolean add(Carrito oObject) {
        boolean bExito = false;
        if (oObject.getIdCarrito() != 0 && contadorCarritos < MAXCARRITOS && search(oObject) == -1){
            vCarritos[contadorCarritos] = oObject;
            contadorCarritos++;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean remove(Carrito oObject) {
        boolean bExito = false;
        int iPosicion = search(oObject);
        if (iPosicion != -1){
            for (int i = iPosicion; i < contadorCarritos; i++)
                vCarritos[i] = vCarritos[i+1];
            vCarritos[contadorCarritos] = null;
            contadorCarritos--;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int search(Carrito oObject) {
        int iPosicion = -1;
        int iContador = 0;
        while (iPosicion == -1 && iContador < contadorCarritos){
            if (oObject.equals(vCarritos[iContador]))
                iPosicion = iContador;
            iContador++;
        }
        return iPosicion;
    }

    @Override
    public String printAll() {
        String salida = "";
        if (contadorCarritos == 0)
            salida = "No hay carritos registrados";
        else {
            for (int i = 0; i < contadorCarritos;i++)
                salida += vCarritos[i]+"\n";
        }
        return salida;
    }

    @Override
    public boolean update(Carrito oObjeto, int iPosicion) {
        boolean bExito = false;
        if (iPosicion != -1){
            vCarritos[iPosicion] = oObjeto;
            bExito = true;
        }
        return bExito;
    }
}
