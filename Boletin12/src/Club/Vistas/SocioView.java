package Club.Vistas;

import Club.Controladores.Terminal;
import Club.Modelos.Socio;
import Tienda.Vistas.TiendaView;

import static Libreria.LibreriaValida.*;

public class SocioView {

    public static void menuSocios(Terminal terminal) {
        byte opcion;
        boolean bExito;

        do {
            opcion = TiendaView.subMenu();
            bExito = gestionMenuSocio(terminal, opcion);
        }while(opcion != 6);
    }

    private static boolean gestionMenuSocio(Terminal terminal, byte opcion) {
        boolean bExito = false;
        switch (opcion) {
            case 1: // ADD SOCIO
                bExito = altaSocio(terminal);
                break;
            case 2: // MODIFICAR SOCIO
                bExito = modificarSocio(terminal);
                break;
            case 3: // ELIMINAR SOCIO
                bExito = eliminarSocio(terminal);
                break;
            case 4: // BUSCAR SOCIO
                Socio socio = buscarSocio(terminal);
                if (socio != null)
                    System.out.println(socio);
                else
                    System.out.println("No se ha encontrado ningun cliente con esa id");
                break;
            case 5: // MOSTRAR SOCIOS
                System.out.println(mostrarSocios(terminal));
                bExito = true;
                break;
            case 6:
                System.out.println("Volviendo al menus principal");
                bExito = true;
                break;
            default:
                System.out.println("Opcion introducida incorrecta");
                bExito = false;
                break;
        }
        return bExito;
    }

    private static boolean altaSocio(Terminal terminal) {
        String sDni, sNombre, sApellidos, sTelefono, sEmail;
        int id;

        boolean bExito = false;
        do {
            try {
                id = (int) valida("Introduce el ID del socio",0,-1,1);
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

        do {
            bExito = false;
            try {
                sDni = leer("Introduce el DNI del socio: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("DNI introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                sNombre = leer("Introduce el nombre del socio: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Nombre introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                sApellidos = leer("Introduce los apellidos del socio: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Apellidos introducido incorrecto");
            }
        }while(!bExito);
    }
}
