package view.ArticulosUsuarios;

import controller.GeneralController;
import validaciones.ValidaLibrary;

public class ArticulosUsuariosView {
    public static void menuArticulosUsuarios(GeneralController controller) {
        byte bOpcion = 0;
        do {
            bOpcion = opcionMenu();
            switch (bOpcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Volviendo...");
            }
        } while (bOpcion != 7);
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nPUBLICADORES: ");
        System.out.println("1. Gestionar Categorias.");
        System.out.println("2. Gestionar Usuarios.");
        System.out.println("3. Gestionar Tipos de articulo.");
        System.out.println("4. Gestionar Articulos.");
        System.out.println("5. Gestionar Categoria por articulo.");
        System.out.println("6. Gestionar Rating de articulo por Usuario.");
        System.out.println("7. Volver.");

        while (errorControl) {
            try {
                bOpcion = (byte) ValidaLibrary.valida("Introduce una opcion: ", 1, 7, 3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        return bOpcion;
    }
}