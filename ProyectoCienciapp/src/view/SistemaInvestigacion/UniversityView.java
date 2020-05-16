package view.SistemaInvestigacion;

import controller.GeneralController;
import model.Ctrl.Country;
import model.LimitsDB;
import model.SistemaInvestigacion.University;
import validaciones.ValidaLibrary;

import java.util.List;

public class UniversityView implements LimitsDB {
    public static void menuUniversidades(GeneralController controller) {
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
        List<University> lUniversity;

        lUniversity = controller.getSistemaInvestigacionController().getUniversityController().getTodasUniversidades();

        if (lUniversity.size() != 0) {
            for (University oUniversity : lUniversity) {
                System.out.println(oUniversity);
            }
        }else
            System.out.println("No hay ninguna universidad en la base de datos.");
    }

    private static void busqueda(GeneralController controller) {
        String sUniName = null;
        boolean errorControl = true;
        University oUniversity;
        int iNumUniversidades;

        while (errorControl) {
            try {
                sUniName = ValidaLibrary.leer("Introduce el nombre: ");
                if (sUniName.length() <= MAXCHAR_65 && sUniName.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        oUniversity = new University(sUniName);
        iNumUniversidades = controller.existeUniversity(oUniversity);

        if (iNumUniversidades > 0)
            System.out.println("Existe " + iNumUniversidades + " en la base de datos.");
        else
            System.out.println("No existe ninguna universidad con ese nombre en la base de datos.");
    }

    private static int eliminar(GeneralController controller) {
        String sUniName = null;
        University oUniversity = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sUniName = ValidaLibrary.leer("Introduce el nombre: ");
                if (sUniName.length() <= MAXCHAR_65 && sUniName.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        oUniversity = new University(sUniName);

        return controller.removeUniversidad(oUniversity);
    }

    private static int alta(GeneralController controller) {
        String sUniName = null;
        String sLocality = null;
        String sAddres = null;
        String sCountry = null;
        University oUniversity = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sUniName = ValidaLibrary.leer("Introduce el nombre: ");
                if (sUniName.length() <= MAXCHAR_65 && sUniName.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sLocality = ValidaLibrary.leer("Introduce la localidad: ");
                if (sLocality.length() <= MAXCHAR_70 && sLocality.length() > MINCHAR)
                    errorControl = false;
            }catch (Exception exception){
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sAddres = ValidaLibrary.leer("Introduce la direccion: ");
                if (sAddres.equals("") || (sAddres.length() <= MAXCHAR_100 && sAddres.length() > MINCHAR))
                    errorControl = false;
            }catch (Exception exception){
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sCountry = ValidaLibrary.leer("Introduce el nombre del pais: ");
                if (sCountry.length() <= MAXCHAR_70 && sCountry.length() > MINCHAR)
                    errorControl = false;
            }catch (Exception exception){
                System.out.println("Error: " + exception.getMessage());
            }
        }

        if (sAddres.equals("")){
            oUniversity = new University(sUniName, sLocality, new Country(sCountry));
        }else{
            oUniversity = new University(sUniName, sLocality, sAddres, new Country(sCountry));
        }

        return controller.addUniversidad(oUniversity);
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nUNIVERSIDADES: ");
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
