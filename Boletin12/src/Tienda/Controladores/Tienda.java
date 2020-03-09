package Tienda.Controladores;


public class Tienda {
    private ClienteController clienteController;
    private ArticuloController articuloController;
    private CarritoController carritoController;

    public Tienda(){
        clienteController = new ClienteController();
        articuloController = new ArticuloController();
        carritoController = new CarritoController();
    }

    public ArticuloController getArticuloController() {
        return articuloController;
    }

    public ClienteController getClienteController() {
        return clienteController;
    }

    public CarritoController getCarritoController() {
        return carritoController;
    }
}
