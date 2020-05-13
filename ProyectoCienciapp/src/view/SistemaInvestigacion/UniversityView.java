package view.SistemaInvestigacion;

import controller.GeneralController;
import validaciones.ValidaLibrary;

public class UniversityView {
    public static void menuUniversidades(GeneralController controller) {

    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nUNIVERSIDADES: ");
        System.out.println("1. Anadir.");
        System.out.println("2. Eliminar.");
        System.out.println("3. Volver.");

        while (errorControl) {
            try {
                bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 3, 3);
                errorControl = true;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        return bOpcion;
    }
}
