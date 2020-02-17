package Tienda.Controladores;

import Tienda.Modelos.Cliente;

public class ClienteController implements ICrud<Cliente> {
    private byte contadorClientes;
    private Cliente[] vClientes;
    private final byte MAXCLIENTES = 20;

    @Override
    public Cliente[] getaVector() {
        return vClientes;
    }

    @Override
    public byte getbContadorArray() {
        return contadorClientes;
    }

    @Override
    public boolean add(Cliente oObject) {
        return false;
    }

    @Override
    public boolean remove(Cliente oObject) {
        return false;
    }

    @Override
    public int search(Cliente oObject) {
        return 0;
    }
}
