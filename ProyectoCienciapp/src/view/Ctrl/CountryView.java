package view.Ctrl;

import controller.GeneralController;
import model.Ctrl.Country;
import model.LimitsDB;
import model.SistemaInvestigacion.University;
import validaciones.ValidaLibrary;

import java.util.List;

public class CountryView implements LimitsDB {
    public static void menuPais(GeneralController controller) {
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

    private static int alta(GeneralController controller) {
        String sPais = null;
        boolean errorControl = true;
        Country oCountry = null;

        while (errorControl) {
            try {
                sPais = ValidaLibrary.leer("Introduce el Pais: ");
                if (sPais.length() > MINCHAR && sPais.length() < MAXCHAR_70)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oCountry = new Country(sPais);

        return controller.getCountryController().add(oCountry);
    }

    private static int eliminar(GeneralController controller) {
        String sPais = null;
        boolean errorControl = true;
        Country oCountry = null;

        while (errorControl) {
            try {
                sPais = ValidaLibrary.leer("Introduce el Pais: ");
                if (sPais.length() > MINCHAR && sPais.length() < MAXCHAR_70)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oCountry = new Country(sPais);

        return controller.getCountryController().add(oCountry);
    }

    private static void busqueda(GeneralController controller) {
        String sPais = null;
        boolean errorControl = true;
        Country oCountry = null;
        int iNumPaises;

        while (errorControl) {
            try {
                sPais = ValidaLibrary.leer("Introduce el Pais: ");
                if (sPais.length() > MINCHAR && sPais.length() < MAXCHAR_70)
                    errorControl = false;
            }catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oCountry = new Country(sPais);
        iNumPaises = controller.getCountryController().existePais(oCountry);

        if (iNumPaises > 0) {
            System.out.println("Existen " + iNumPaises + " en la base de datos");
        }else {
            System.out.println("No existe ningun pais con ese nombre en la base de datos.");
        }
    }

    private static void mostrarTodas(GeneralController controller) {
        List<Country> lPais;

        lPais = controller.getCountryController().getTodosPaises();

        if (lPais.size() != 0) {
            for (Country oCountry : lPais) {
                System.out.println(oCountry);
            }
        }else
            System.out.println("No hay ningun pais en la base de datos.");
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
