package Tienda.Vistas;


import Tienda.Controladores.Tienda;

public class mainTienda {
    public static void main(String[] args) {
        TiendaView tiendaView = new TiendaView();
        Tienda tienda = new Tienda();

        tiendaView.gestionOpcionMenuPrincipal(tienda);
    }
}
