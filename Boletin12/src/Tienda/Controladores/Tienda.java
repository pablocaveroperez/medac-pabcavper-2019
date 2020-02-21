package Tienda.Controladores;


public class Tienda {
    private ClienteController clienteController;
    private ArticuloController articuloController;

    public Tienda(){
        clienteController = new ClienteController();
        articuloController = new ArticuloController();
    }

    public ArticuloController getArticuloController() {
        return articuloController;
    }

    public ClienteController getClienteController() {
        return clienteController;
    }
}
