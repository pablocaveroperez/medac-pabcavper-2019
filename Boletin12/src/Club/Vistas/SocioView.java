package Club.Vistas;

import Club.Controladores.Terminal;
import Club.Modelos.Socio;
import Tienda.Vistas.TiendaView;

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
}
