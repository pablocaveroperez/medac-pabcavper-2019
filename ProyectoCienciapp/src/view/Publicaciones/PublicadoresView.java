package view.Publicaciones;

import controller.GeneralController;
import model.LimitsDB;
import validaciones.ValidaLibrary;

public class PublicadoresView implements LimitsDB {
    public static void menuPublicadores(GeneralController controller) {
        byte bOpcion = 0;
        do {
            bOpcion = opcionMenu();
            switch (bOpcion) {
                case 1:
                    HeadquartersView.menuHeadquarters(controller);
                    break;
                case 2:
                    MagazineView.menuMagazine(controller);
                    break;
                default:
                    System.out.println("Volviendo...");
            }
        } while (bOpcion != 3);
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nPUBLICADORES: ");
        System.out.println("1. Gestionar Oficinas centrales.");
        System.out.println("2. Gestionar Revistas.");
        System.out.println("3. Volver.");

        while (errorControl) {
            try {
                bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 3, 3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        return bOpcion;
    }
}
