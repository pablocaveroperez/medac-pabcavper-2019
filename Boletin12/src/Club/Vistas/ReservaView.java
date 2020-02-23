package Club.Vistas;

import Club.Controladores.Terminal;
import Club.Modelos.Instalacion;
import Club.Modelos.Reserva;
import Club.Modelos.Socio;
import Tienda.Vistas.TiendaView;

import java.util.Calendar;

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

    private static boolean altaReserva(Terminal terminal) {
        boolean bExito = false;
        Socio socio;
        Instalacion instalacion;
        Calendar fecha;
        byte hora;
        byte minutos;

    }
}
