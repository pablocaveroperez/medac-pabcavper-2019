package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Cliente;
import medac.validaciones.LibFrontend;

public class ClienteView {
    public static String altaCliente(Tienda tienda){
        String sDni;
        String sNombre;
        float saldo;
        String sApellidos;
        int idCliente;
        String sResultado;

        sDni = LibFrontend.leer("Introduce el DNI del socio: ");
        sNombre = LibFrontend.leer("Introduce el nombre del socio: ");
        sApellidos = LibFrontend.leer("Introduce los apellidos del socio: ");
        saldo = (float) LibFrontend.valida("Introduce el saldo del socio: ",0,2000,2);
        idCliente = (int) LibFrontend.valida("Introduce el ID del socio",0,-1,1);
        Cliente oCliente = new Cliente(sDni,sNombre,sApellidos,saldo,idCliente);
        if (!(tienda.getClienteController().add(oCliente)))
            sResultado = "El socio no se ha podido registrar correctamente";
        else
            sResultado = "El socio se ha podido registrar correctamente";
        return sResultado;
    }
}