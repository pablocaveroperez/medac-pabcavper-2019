package Tienda.Controladores;

import Tienda.Modelos.Carrito;

public class CarritoController {
    private Carrito[] carritos;
    private byte contadorCarritos;
    private final byte MAXCARRITOS = 50;

    public CarritoController(){
        carritos = new Carrito[MAXCARRITOS];
        setContadorCarritos((byte) 0);
    }

    public byte getContadorCarritos() {
        return contadorCarritos;
    }

    public void setContadorCarritos(byte contadorCarritos) {
        this.contadorCarritos = contadorCarritos;
    }

    public Carrito[] getCarritos() {
        return carritos;
    }


}
