package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Cliente;

import java.text.SimpleDateFormat;

import static Libreria.LibreriaValida.*;


public class ClienteView {

    public static void menuClientes(Tienda tienda) {
        byte opcion;
        boolean bExito;

        do {
            opcion = TiendaView.subMenu();
            bExito = gestionMenuCliente(tienda, opcion);
        }while(opcion != 6);

    }

    private static boolean gestionMenuCliente(Tienda tienda, byte opcion) {
        boolean bExito = false;
        switch (opcion){
            case 1: // ADD CLIENTE
                bExito = altaCliente(tienda);
                break;
            case 2:// MODIFICAR CLIENTE
                bExito = modificarCliente(tienda);
                break;
            case 3: // ELIMINAR CLIENTE
                bExito = eliminarCliente(tienda);
                break;
            case 4: // BUSCAR CLIENTE
                Cliente oCliente = buscarCliente(tienda);
                if (oCliente != null)
                    System.out.println(oCliente);
                else
                    System.out.println("No se ha encontrado ningun cliente con esa ID.");
                break;
            case 5: // MOSTRAR CLIENTES
                System.out.println(mostrarClientes(tienda));
                break;
            case 6:
                System.out.println("Volviendo al menus principal");
                break;
            default:
                System.out.println("Opcion introducida incorrecta");
                break;
        }
        return bExito;
    }

    private static String mostrarClientes(Tienda tienda){
        return tienda.getClienteController().printAll();
    }

    private static Cliente buscarCliente(Tienda tienda){
        int id = (int) valida("Introduce el id del cliente que desea buscar: ",0,-1,1);
        return tienda.getClienteController().getaVector()[tienda.getClienteController().search(new Cliente(id))];
    }

    private static boolean eliminarCliente(Tienda tienda){
        int id = (int) valida("Introduce el id del cliente que desea eliminar: ",0,-1,1);
        boolean bExito = tienda.getClienteController().remove(new Cliente(id));
        if (bExito)
            System.out.println("Cliente eliminado con exito.");
        else
            System.out.println("Cliente eliminado sin exito.");

        return bExito;
    }

    private static boolean modificarCliente(Tienda tienda) {
        int id;
        boolean bExito = false;
        id = (int) valida("Introduce el ID del cliente que desees modificar: ",0,-1,1);
        int iPosicion = tienda.getClienteController().search(new Cliente(id));
        if (iPosicion != -1) {
            tienda.getClienteController().getaVector()[iPosicion].setsNombre(leer("Introduce el nuevo nombre del cliente: "));
            tienda.getClienteController().getaVector()[iPosicion].setsApellidos(leer("Introduce los nuevos apellidos del cliente: "));
            tienda.getClienteController().getaVector()[iPosicion].setsDni(leer("Introduce el nuevo DNI del cliente: "));
            tienda.getClienteController().getaVector()[iPosicion].setSaldo((float) valida("Introduce el nuevo saldo del cliente(0-2000): ",0,2000,2));
            bExito = true;
        }

        if (bExito)
            System.out.println("Cliente modificado con exito.");
        else
            System.out.println("Cliente modificado sin exito.");
        return bExito;
    }

    public static boolean altaCliente(Tienda tienda){
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

        bExito = tienda.getClienteController().add(oCliente);
        if (bExito)
            System.out.println("Cliente aniadido con exito.");
        else
            System.out.println("Cliente aniadido sin exito.");

        return bExito;
    }
}
