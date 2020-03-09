package Tienda.Vistas;


import Tienda.Controladores.Tienda;
import Tienda.Modelos.Empresa;
import Tienda.Modelos.Particular;
import Tienda.Modelos.Proveedor;

public class mainTienda {
    public static void main(String[] args) {
        TiendaView tiendaView = new TiendaView();
        Tienda tienda = new Tienda();

        tiendaView.gestionOpcionMenuPrincipal(tienda);
    	
    }
}
