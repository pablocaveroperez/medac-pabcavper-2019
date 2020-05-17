package view.ArticulosUsuarios;

import controller.GeneralController;
import model.ArticulosUsuarios.ArticleType;
import model.ArticulosUsuarios.User;
import model.LimitsDB;
import validaciones.ValidaLibrary;

import java.util.List;

public class ArticleTypeView implements LimitsDB {
    public static void menuArticleType(GeneralController controller) {
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
        String sTypeName = null;
        String sDescription = null;
        ArticleType oType = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sTypeName = ValidaLibrary.leer("Introduce el username: ");
                if (sTypeName.length() < MAXCHAR_50 && sTypeName.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sDescription = ValidaLibrary.leer("Introduce la descripcion(Puede ser nulo): ");
                if (sDescription.equals("") || (sDescription.length() < MAXCHAR_250 && sDescription.length() > MINCHAR))
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oType = new ArticleType(sTypeName, sDescription);
        return controller.removeArticleType(oType);
    }

    private static int eliminar(GeneralController controller) {
        String sTypeName = null;
        ArticleType oType = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sTypeName = ValidaLibrary.leer("Introduce el username: ");
                if (sTypeName.length() < MAXCHAR_50 && sTypeName.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oType = new ArticleType(sTypeName);
        return controller.removeArticleType(oType);
    }

    private static void busqueda(GeneralController controller) {
        String sTypeName = null;
        ArticleType oType = null;
        boolean errorControl = true;
        int iNumTypes;

        while (errorControl) {
            try {
                sTypeName = ValidaLibrary.leer("Introduce el username: ");
                if (sTypeName.length() < MAXCHAR_50 && sTypeName.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oType = new ArticleType(sTypeName);
        iNumTypes = controller.existeArticleType(oType);

        if (iNumTypes > 0) {
            System.out.println("Existen " + iNumTypes + " en la base de datos.");
        }else
            System.out.println("No existe ningun tipo de articulo con ese nombre.");
    }

    private static void mostrarTodas(GeneralController controller) {
        List<ArticleType> lArticleType;

        lArticleType = controller.getArticulosUsuariosController().getArticleTypeController().getTodasTipoArticulo();

        if (lArticleType.size() > 0) {
            for (ArticleType oArticleType : lArticleType) {
                System.out.println(oArticleType);
            }
        }else{
            System.out.println("No hay ningun tipo de articulo en la base de datos.");
        }
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nTIPO DE ARTICULO: ");
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
