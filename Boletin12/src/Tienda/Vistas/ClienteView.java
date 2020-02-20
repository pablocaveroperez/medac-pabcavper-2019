package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Cliente;

import static Libreria.LibreriaValida.*;


public class ClienteView {

    public void menuClientes(Tienda tienda) {
        byte opcion;
        boolean bExito;

        do {
            opcion = TiendaView.subMenu();
            bExito = gestionMenuCliente(tienda, opcion);
        }while(opcion != 6);

    }

    private boolean gestionMenuCliente(Tienda tienda, byte opcion) {
        boolean bExito = false;
        switch (opcion){
            case 1: // ADD CLIENTE
                bExito = altaCliente(tienda);
                break;
            case 2:// MODIFICAR CLIENTE
                bExito = modificarCliente(tienda);
        }
        return bExito;
    }

    private boolean modificarCliente(Tienda tienda) {
        return false;
    }

    public boolean altaCliente(Tienda tienda){
        String sDni;
        String sNombre;
        float saldo = 0;
        String sApellidos;
        int idCliente = 0;
        String sResultado;

        boolean bExito = false;
        do {
            try {
                idCliente = (int) valida("Introduce el ID del socio",0,-1,1);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID introducido incorrecto");
            }
        }while(!bExito);

        sDni = leer("Introduce el DNI del socio: ");
        sNombre = leer("Introduce el nombre del socio: ");
        sApellidos = leer("Introduce los apellidos del socio: ");

        do {
            bExito = false;
            try {
                saldo = (float) valida("Introduce el saldo del socio: ",0,2000,2);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Saldo introducido incorrecto");
            }
        }while(!bExito);

        Cliente oCliente = new Cliente(sDni,sNombre,sApellidos,saldo,idCliente);

        return tienda.getClienteController().add(oCliente);
    }
}
