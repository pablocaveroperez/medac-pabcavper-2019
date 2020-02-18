package Tienda.Vistas;

import Tienda.Controladores.ClienteController;
import Tienda.Modelos.Cliente;

public class mainTienda {
    public static void main(String[] args) {
        int iPosicion = 3;
        ClienteController clienteController = new ClienteController();

        clienteController.add(new Cliente(1));
        clienteController.add(new Cliente(2));
        clienteController.add(new Cliente(3));
        clienteController.add(new Cliente(4));
        clienteController.add(new Cliente(5));

        clienteController.remove(new Cliente(3));

    }
}
