package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import medac.validaciones.LibFrontend;

public class ClienteView {
    public static String altaSocio(Tienda tienda){
        String sDni;
        String sNombre;
        double saldo;
        String sApellidos;
        int idCliente;
        String sResultado;

        sDni = LibFrontend.leer("Introduce el DNI del socio: ");
        sNombre = LibFrontend.leer("Introduce el nombre del socio: ");
        sApellidos = LibFrontend.leer("Introduce los apellidos del socio: ");
        saldo = LibFrontend.valida("Introduce el saldo del socio: ",0,2000,)
    }
}
