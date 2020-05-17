package view.ArticulosUsuarios;

import controller.GeneralController;
import model.ArticulosUsuarios.User;
import model.LimitsDB;
import validaciones.ValidaLibrary;

import java.util.List;

public class UserView implements LimitsDB {
    public static void menuUser(GeneralController controller) {
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
        String sUsername = null;
        boolean errorControl = true;
        User oUser = null;

        while (errorControl) {
            try {
                sUsername = ValidaLibrary.leer("Introduce el username: ");
                if (sUsername.length() < MAXCHAR_50 && sUsername.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oUser = new User(sUsername);

        return controller.removeUser(oUser);
    }

    private static void busqueda(GeneralController controller) {
        String sUsername = null;
        User oUser = null;
        boolean errorControl = true;
        int iNumUsers;

        while (errorControl) {
            try {
                sUsername = ValidaLibrary.leer("Introduce el username: ");
                if (sUsername.length() < MAXCHAR_50 && sUsername.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oUser = new User(sUsername);
        iNumUsers = controller.existeUser(oUser);

        if (iNumUsers > 0) {
            System.out.println("Existen " + iNumUsers + " en la base de datos.");
        }else
            System.out.println("No existe ningun usuario con ese username.");
    }

    private static void mostrarTodas(GeneralController controller) {
        List<User> lUser;

        lUser = controller.getArticulosUsuariosController().getUserController().getTodasUsuarios();

        if (lUser.size() > 0) {
            for (User oUser : lUser) {
                System.out.println(oUser);
            }
        }else{
            System.out.println("No hay ningun usuario en la base de datos.");
        }
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nUSUARIO: ");
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
