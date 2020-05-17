package view.Publicaciones;

import controller.GeneralController;
import model.LimitsDB;
import model.Publicadores.Headquarters;
import model.Publicadores.Magazine;
import validaciones.ValidaLibrary;

import java.util.List;

public class MagazineView implements LimitsDB {
    public static void menuMagazine(GeneralController controller) {
        byte bOpcion = 0;
        do {
            bOpcion = opcionMenu();
            switch (bOpcion) {
                case 1:
                    if (alta(controller) != 0)
                        System.out.println("Ha sido anadida con exito.");
                    else
                        System.out.println("Ya se encuentra en el sistema.");
                    break;
                case 2:
                    if (eliminar(controller) != 0)
                        System.out.println("Ha sido eliminado con existo.");
                    else
                        System.out.println("No existe en el sistema.");
                    break;
                case 3:
                    busqueda(controller);
                    break;
                case 4:
                    mostrarTodas(controller);
                    break;
                default:
                    System.out.println("Volviendo...");
            }
        } while (bOpcion != 5);
    }

    private static void busqueda(GeneralController controller) {
        String sName = null;
        boolean errorControl = true;
        Magazine oMagazine = null;
        int iNumRevistas;

        while (errorControl) {
            try {
                sName = ValidaLibrary.leer("Introduce el nombre de la revista: ");
                if (sName.length() > MINCHAR && sName.length() < MAXCHAR_100)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oMagazine = new Magazine(sName);
        iNumRevistas = controller.existeMagazine(oMagazine);

        if (iNumRevistas > 0) {
            System.out.println("Existen " + iNumRevistas + " en la base de datos");
        }else {
            System.out.println("No existe ninguna revista con ese nombre en la base de datos.");
        }
    }

    private static void mostrarTodas(GeneralController controller) {
        List<Magazine> lMagazine;

        lMagazine = controller.getPublicadoresController().getMagazineController().getTodasRevistas();

        if (lMagazine.size() != 0) {
            for (Magazine oMagazine: lMagazine) {
                System.out.println(oMagazine);
            }
        }else
            System.out.println("No hay ninguna revista en la base de datos.");
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nPAISES: ");
        System.out.println("1. Anadir.");
        System.out.println("2. Eliminar.");
        System.out.println("3. Busqueda.");
        System.out.println("4. Mostrar todas.");
        System.out.println("5. Volver.");

        while (errorControl) {
            try {
                bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 5, 3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        return bOpcion;
    }
}
