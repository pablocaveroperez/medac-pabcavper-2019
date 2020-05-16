package view.SistemaInvestigacion;

import controller.GeneralController;
import model.LimitsDB;
import model.SistemaInvestigacion.Member;
import model.SistemaInvestigacion.Specialization;
import validaciones.ValidaLibrary;

import java.util.List;

public class SpecializationView implements LimitsDB {
    public static void menuEspecializacion(GeneralController controller) {
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

    private static void mostrarTodas(GeneralController controller) {
        List<Specialization> lEspecializacion;

        lEspecializacion = controller.getSistemaInvestigacionController().getSpecializationController().getTodosEspecializaciones();

        if (lEspecializacion.size() != 0) {
            for (Specialization oEspecializacion : lEspecializacion) {
                System.out.println(oEspecializacion);
            }
        }else
            System.out.println("No hay ningun miembro en la base de datos.");
    }

    private static int alta(GeneralController controller) {
        String sSpecialization = null;
        String sDescription = null;
        boolean errorControl = true;
        Specialization oSpecialization = null;

        while (errorControl) {
            try {
                sSpecialization = ValidaLibrary.leer("Introduce la especializacion: ");
                if (sSpecialization.length() > MINCHAR && sSpecialization.length() < MAXCHAR_50)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sDescription = ValidaLibrary.leer("Introduce la descripcion: ");
                if (sDescription.equals("") || (sDescription.length() < MAXCHAR_200 && sDescription.length() > MINCHAR))
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        if (sDescription.equals(""))
            oSpecialization = new Specialization(sSpecialization);
        else
            oSpecialization = new Specialization(sSpecialization, sDescription);

        return controller.addSpecialization(oSpecialization);
    }

    private static int eliminar(GeneralController controller) {
        String sSpecialization = null;
        boolean errorControl = true;
        Specialization oSpecialization = null;

        while (errorControl) {
            try {
                sSpecialization = ValidaLibrary.leer("Introduce la especializacion: ");
                if (sSpecialization.length() > MINCHAR && sSpecialization.length() < MAXCHAR_50)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oSpecialization = new Specialization(sSpecialization);

        return controller.removeSpecialization(oSpecialization);
    }

    private static void busqueda(GeneralController controller) {
        String sSpecialization = null;
        boolean errorControl = true;
        Specialization oSpecialization = null;
        int iNumSpecializaciones;

        while (errorControl) {
            try {
                sSpecialization = ValidaLibrary.leer("Introduce la especializacion: ");
                if (sSpecialization.length() > MINCHAR && sSpecialization.length() < MAXCHAR_50)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oSpecialization = new Specialization(sSpecialization);
        iNumSpecializaciones = controller.existeSpecialization(oSpecialization);

        if (iNumSpecializaciones > 0)
            System.out.println("Existe " + iNumSpecializaciones + " en la base de datos.");
        else
            System.out.println("No existe ninguna especializacion con ese nombre en la base de datos.");
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nESPECIALIZACION: ");
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
