package Tienda.Vistas;

import Tienda.Controladores.Tienda;

public class TiendaView {
    private Tienda tienda;
    private ArticuloView articuloView;
    private ClienteView clienteView;

    public ArticuloView getArticuloView() {
        return articuloView;
    }

    public ClienteView getClienteView() {
        return clienteView;
    }

    public Tienda getTienda() {
        return tienda;
    }


}
