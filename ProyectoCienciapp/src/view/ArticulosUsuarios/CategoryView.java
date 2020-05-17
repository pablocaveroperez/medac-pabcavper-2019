package view.ArticulosUsuarios;

import controller.GeneralController;
import model.ArticulosUsuarios.Category;
import model.LimitsDB;
import validaciones.ValidaLibrary;

import java.util.List;

public class CategoryView implements LimitsDB {
    public static void menuCategory(GeneralController controller) {
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
        String sName = null;
        String sDescription = null;
        Category oCategory = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sName = ValidaLibrary.leer("Introduce el nombre de la categoria: ");
                if (sName.length() > MINCHAR && sName.length() < MAXCHAR_60)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sDescription = ValidaLibrary.leer("Introduce la descripcion: ");
                if (sDescription.equals("") || (sDescription.length() > MINCHAR && sDescription.length() < MAXCHAR_200))
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oCategory = new Category(sName, sDescription);

        return controller.addCategory(oCategory);
    }

    private static int eliminar(GeneralController controller) {
        String sName = null;
        boolean errorControl = true;
        Category oCategory = null;

        while (errorControl) {
            try {
                sName = ValidaLibrary.leer("Introduce el nombre de la categoria: ");
                if (sName.length() > MINCHAR && sName.length() < MAXCHAR_60)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oCategory = new Category(sName);

        return controller.removeCategory(oCategory);
    }

    private static void busqueda(GeneralController controller) {
        String sName = null;
        boolean errorControl = true;
        Category oCategory = null;
        int iNumCategorias;

        while (errorControl) {
            try {
                sName = ValidaLibrary.leer("Introduce el nombre de la categoria: ");
                if (sName.length() > MINCHAR && sName.length() < MAXCHAR_60)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oCategory = new Category(sName);
        iNumCategorias = controller.existeCategory(oCategory);

        if (iNumCategorias > 0) {
            System.out.println("Existen " + iNumCategorias + " en la base de datos.");
        }else
            System.out.println("No existe ninguna categoria con ese nombre.");
    }

    private static void mostrarTodas(GeneralController controller) {
        List<Category> lCategoria;

        lCategoria = controller.getArticulosUsuariosController().getCategoryController().getTodasCategorias();

        if (lCategoria.size() != 0) {
            for (Category oCategory: lCategoria) {
                System.out.println(oCategory);
            }
        }else
            System.out.println("No hay ninguna categoria en la base de datos.");
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nCATEGORIA: ");
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