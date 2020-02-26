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
        return 0;
    }

    @Override
    public String printAll() {
        return null;
    }

    @Override
    public boolean update(Carrito oObjeto, int iPosicion) {
        return false;
    }
}
