package Club.Vistas;

import Club.Controladores.Terminal;
import Club.Modelos.Instalacion;
import Club.Modelos.Reserva;
import Club.Modelos.Socio;
import Tienda.Vistas.TiendaView;

import java.util.Calendar;

import static Libreria.LibreriaValida.*;

public class ReservaView {
    public static void menuReservas(Terminal terminal) {
        byte opcion;
        boolean bExito;

        do {
            opcion = TiendaView.subMenu();
            bExito = gestionMenuReserva(terminal,opcion);
        }while(opcion != 6);
    }

    private static boolean gestionMenuReserva(Terminal terminal, byte opcion) {
        boolean bExito = false;
        switch (opcion) {
            case 1: // ADD RESERVA
                bExito = altaReserva(terminal);
                break;
            case 2: // MODIFICAR RESERVA
                bExito = modificarReserva(terminal);
                break;
            case 3: // ELIMINAR RESERVA
                bExito = eliminarReserva(terminal);
                break;
            case 4: // BUSCAR RESERVA
                Reserva reserva = buscarReserva(terminal);
                if (reserva != null)
                    System.out.println(reserva);
                else
                    System.out.println("No se ha encontrado ninguna reserva con esa id");
                break;
            case 5: // MOSTRAR RESERVA
                System.out.println(mostrarReserva(terminal));
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

    private static String mostrarReserva(Terminal terminal) {
        return null;
    }

    private static Reserva buscarReserva(Terminal terminal) {
    }

    private static boolean eliminarReserva(Terminal terminal) {
    }

    private static boolean modificarReserva(Terminal terminal) {
    }

    private static boolean altaReserva(Terminal terminal) {
        boolean bExito = false;
        Socio socio;
        Instalacion instalacion;
        Calendar fecha;
        byte hora;
        byte minutos;

        do {
            try {
                socio = terminal.getSocioController().getaVector()[terminal.getSocioController().search(new Socio((int) valida("Introduce la id del socio: ",0,-1,1)))];
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID del socio introducido incorrecto");
            }
        }while(!bExito);

        byte ubicacion = 0, tipo = 0;
        do {
            bExito = false;
            try {
                ubicacion = (byte) valida("Introduce la ubicacion de la instalacion: ",0,-1,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Ubicacion de la instalacion introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                ubicacion = (byte) valida("Introduce el tipo de la instalacion: ",1,3,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Tipo de la instalacion introducido incorrecto");
            }
        }while(!bExito);

        instalacion= terminal.getInstalacionController().getaVector()[terminal.getInstalacionController().search(new Instalacion(ubicacion,tipo))];

    }
}
