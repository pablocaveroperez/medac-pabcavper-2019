package Tienda.Controladores;

import Tienda.Modelos.Cliente;

public class ClienteController implements ICrud<Cliente> {
    private byte contadorClientes;
    private Cliente[] vClientes;
    private final byte MAXCLIENTES = 20;

    public ClienteController(){
        vClientes = new Cliente[MAXCLIENTES];
        contadorClientes = 0;
    }

    @Override
    public Cliente[] getaVector() {
        return vClientes;
    }

    @Override
    public byte getbContadorArray() {
        return contadorClientes;
    }

    @Override
    public int search(Cliente oObject) {
        int iPosicion = -1;
        int iContador = 0;

        while(iPosicion == -1 && iContador < contadorClientes){
            if (oObject.equals(vClientes[iContador]))
                iPosicion = iContador;
            iContador++;
        }
        return iPosicion;
    }

    @Override
    public boolean add(Cliente oObject) {
        boolean bExito = false;
        if (oObject.getIdCliente() != 0 && oObject.getsDni() != null && contadorClientes < MAXCLIENTES && search(oObject) == -1){
            vClientes[contadorClientes] = oObject;
            contadorClientes++;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean remove(Cliente oObject) {
        boolean bExito = false;
        int iPosicion = search(oObject);
        if (iPosicion != -1){
            for (int i = iPosicion; i < contadorClientes; i++)
                vClientes[i-1] = vClientes[i];
            vClientes[contadorClientes] = null;
            contadorClientes--;
            bExito = true;
        }
        return bExito;
    }


}
