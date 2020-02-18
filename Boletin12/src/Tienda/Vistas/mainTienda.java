package Tienda.Vistas;

import Tienda.Controladores.ClienteController;
import Tienda.Controladores.Tienda;
import Tienda.Modelos.Cliente;

public class mainTienda {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();

        // ADD CLIENTE
        System.out.println(ClienteView.altaCliente(tienda));
        System.out.println("Numero de socios registrados en la tienda: "+ tienda.getClienteController().getbContadorArray());

        // ADD ARTICULO
        System.out.println(ArticuloView.altaArticulo(tienda));
        System.out.println("Numero de articulos registrados en la tienda: "+ tienda.getArticuloController().getbContadorArray());

        System.out.println("Estos son todos los clientes registrados: \n" + tienda.getClienteController().printAll());
        System.out.println("Estos son todos los articulos registrados: \n" + tienda.getArticuloController().printAll());
    }
}
