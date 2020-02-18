package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Cliente;

import static Libreria.LibreriaValida.*;


public class ClienteView {
    public static String altaCliente(Tienda tienda){
        String sDni;
        String sNombre;
        float saldo = 0;
        String sApellidos;
        int idCliente;
        String sResultado;


        sDni = leer("Introduce el DNI del socio: ");
        sNombre = leer("Introduce el nombre del socio: ");
        sApellidos = leer("Introduce los apellidos del socio: ");
        boolean bExito = true;
        try {
            saldo = (float) valida("Introduce el saldo del socio: ",0,2000,2);
            bExito = false;
        }catch (NumberFormatException exc){
            System.out.println(exc.getMessage());
        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }finally {
            if (!bExito)
                System.out.println("Saldo introducido incorrecto");
        }


        idCliente = (int) valida("Introduce el ID del socio",0,-1,1);
        Cliente oCliente = new Cliente(sDni,sNombre,sApellidos,saldo,idCliente);
        if (!(tienda.getClienteController().add(oCliente)))
            sResultado = "El socio no se ha podido registrar correctamente";
        else
            sResultado = "El socio se ha podido registrar correctamente";
        return sResultado;
    }
}
