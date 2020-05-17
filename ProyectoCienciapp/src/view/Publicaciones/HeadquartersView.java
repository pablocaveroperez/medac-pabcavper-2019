package view.Publicaciones;

import controller.GeneralController;
import model.LimitsDB;
import model.Publicadores.Headquarters;
import validaciones.ValidaLibrary;

import java.util.List;

public class HeadquartersView implements LimitsDB {
    public static void menuHeadquarters(GeneralController controller) {
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

    private static int eliminar(GeneralController controller) {
        String sName = null;
        boolean errorControl = true;
        Headquarters oHeadquarters = null;

        while (errorControl) {
            try {
                sName = ValidaLibrary.leer("Introduce el nombre del HQ: ");
                if (sName.length() > MINCHAR && sName.length() < MAXCHAR_40)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oHeadquarters = new Headquarters(sName);

        return controller.removeHeadquarters(oHeadquarters);
    }

    private static void busqueda(GeneralController controller) {
        String sName = null;
        boolean errorControl = true;
        Headquarters oHeadquarters = null;
        int iNumHQs;

        while (errorControl) {
            try {
                sName = ValidaLibrary.leer("Introduce el nombre del HQ: ");
                if (sName.length() > MINCHAR && sName.length() < MAXCHAR_40)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oHeadquarters = new Headquarters(sName);
        iNumHQs = controller.existeHeadquarters(oHeadquarters);

        if (iNumHQs > 0) {
            System.out.println("Existen " + iNumHQs + " en la base de datos");
        }else {
            System.out.println("No existe ningun HQ con ese nombre en la base de datos.");
        }
    }

    private static void mostrarTodas(GeneralController controller) {
        List<Headquarters> lHQ;

        lHQ = controller.getPublicadoresController().getHeadquartersController().getTodosHQ();

        if (lHQ.size() != 0) {
            for (Headquarters oHeadquartes: lHQ) {
                System.out.println(oHeadquartes);
            }
        }else
            System.out.println("No hay ninguna oficina central en la base de datos.");
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
