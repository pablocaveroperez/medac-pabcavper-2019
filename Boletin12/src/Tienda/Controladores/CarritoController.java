package Tienda.Controladores;

import Tienda.Modelos.Carrito;

public class CarritoController implements ICrud<Carrito> {
    private Carrito[] carritos;
    private byte contadorCarritos;
    private final byte MAXCARRITOS = 50;

    public CarritoController(){
        carritos = new Carrito[MAXCARRITOS];
        contadorCarritos = 0;
    }

    @Override
    public Carrito[] getaVector() {
        return carritos;
    }

    @Override
    public byte getbContadorArray() {
        return contadorCarritos;
    }

    @Override
    public boolean add(Carrito oObject) {
        boolean bExito = false;

    }

    @Override
    public boolean remove(Carrito oObject) {
        return false;
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
