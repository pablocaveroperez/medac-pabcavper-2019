package view.SistemaInvestigacion;

import controller.GeneralController;
import model.LimitsDB;
import model.SistemaInvestigacion.Faculty;
import model.SistemaInvestigacion.University;
import validaciones.ValidaLibrary;

public class FacultyView implements LimitsDB {
    public static void menuFacultades(GeneralController controller) {
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
                default:
                    System.out.println("Volviendo...");
            }
        } while (bOpcion != 4);
    }

    private static int alta(GeneralController controller) {
        String sFaculName = null;
        String sUniName = null;
        boolean errorControl = true;
        Faculty oFaculty;

        while (errorControl) {
            try {
                sFaculName = ValidaLibrary.leer("Introduce el nombre de la facultad: ");
                if (sFaculName.length() > MINCHAR && sFaculName.length() <= MAXCHAR_50)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sUniName = ValidaLibrary.leer("Introduce el nombre de la universidad a la que pertenece: ");
                if (sUniName.length() <= MAXCHAR_65 && sUniName.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oFaculty = new Faculty(sFaculName, new University(sUniName));

        return controller.addFaculty(oFaculty);
    }

    private static int eliminar(GeneralController controller) {
        return 0;
    }

    private static void busqueda(GeneralController controller) {

    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nFACULTADES: ");
        System.out.println("1. Anadir.");
        System.out.println("2. Eliminar.");
        System.out.println("3. Busqueda.");
        System.out.println("4. Volver.");

        while (errorControl) {
            try {
                bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 4, 3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        return bOpcion;
    }
}
