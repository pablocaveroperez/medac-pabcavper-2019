package Club.Vistas;

import Club.Controladores.Terminal;
import Club.Modelos.Instalacion;
import Club.Modelos.Socio;
import Tienda.Vistas.TiendaView;

import static Libreria.LibreriaValida.*;

public class InstalacionView {
    public static void menuInstalaciones(Terminal terminal) {
        byte opcion;
        boolean bExito;

        do {
            opcion = TiendaView.subMenu();
            bExito = gestionMenuInstalacion(terminal, opcion);
        }while(opcion != 6);
    }

    private static boolean gestionMenuInstalacion(Terminal terminal, byte opcion) {
        boolean bExito = false;
        switch (opcion) {
            case 1: // ADD INSTALACION
                bExito = altaInstalacion(terminal);
                break;
            case 2: // MODIFICAR INSTALACION
                bExito = modificarInstalacion(terminal);
                break;
            case 3: // ELIMINAR INSTALACION
                bExito = eliminarInstalacion(terminal);
                break;
            case 4: // BUSCAR INSTALACION
                Socio socio = buscarInstalacion(terminal);
                if (socio != null)
                    System.out.println(socio);
                else
                    System.out.println("No se ha encontrado ninguna instalacion con esa id");
                break;
            case 5: // MOSTRAR INSTALACION
                System.out.println(mostrarInstalaciones(terminal));
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

    public static boolean altaInstalacion(Terminal terminal) {
        byte bTipo = -1, bUbicacion = -1;
        boolean bExito = false;

        do {
            try {
                bTipo = (byte) valida("Introduce un número de tipo de instalacion (1-3): ", 1, 3, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Tipo introducido incorrecto.");
            }
        }while (!bExito);

        do {
            bExito = false;
            try {
                bUbicacion = (byte) valida("Introduce un número de ubicaicon: ", 0, -1, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Ubicaicon introducido incorrecto.");
            }
        }while (!bExito);

        Instalacion instalacion = new Instalacion(bUbicacion, bTipo);
        bExito = terminal.getInstalacionController().add(instalacion);
        if (bExito)
            System.out.println("Instalacion aniadida con exito");
        else
            System.out.println("Instalacion aniadida sin exito");
        return bExito;
    }
}
