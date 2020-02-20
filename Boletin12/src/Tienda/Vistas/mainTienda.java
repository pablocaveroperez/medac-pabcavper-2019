package Tienda.Vistas;

import Tienda.Controladores.ClienteController;
import Tienda.Controladores.Tienda;
import Tienda.Modelos.Cliente;

public class mainTienda {
    public static void main(String[] args) {
        TiendaView tiendaView = new TiendaView();
        Tienda tienda = new Tienda();

        tiendaView.gestionOpcionMenuPrincipal(tienda);
    }
}
