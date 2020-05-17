package view.ArticulosUsuarios;

import controller.GeneralController;
import model.ArticulosUsuarios.Article;
import model.ArticulosUsuarios.ArticleType;
import model.ArticulosUsuarios.ArticleXCategory;
import model.ArticulosUsuarios.Category;
import model.LimitsDB;
import model.Publicadores.Magazine;
import model.SistemaInvestigacion.Member;
import validaciones.ValidaLibrary;

import java.util.List;

public class ArticleXCategoryView implements LimitsDB {
    public static void menuArticleXCategory(GeneralController controller) {
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
        byte idArticle = 0;
        String sCategoryName = null;
        ArticleXCategory oArticleXCategory = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                idArticle = (byte) ValidaLibrary.valida("Introduce el ID del articulo: ",MINCHAR,MAXCHAR_100,3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sCategoryName = ValidaLibrary.leer("Introduce la categoria: ");
                if (sCategoryName.length() > MINCHAR && sCategoryName.length() < MAXCHAR_60)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oArticleXCategory = new ArticleXCategory(new Article(idArticle), new Category(sCategoryName));

        return controller.addArticleXCategory(oArticleXCategory);
    }

    private static int eliminar(GeneralController controller) {
        byte idArticle = 0;
        String sCategoryName = null;
        ArticleXCategory oArticleXCategory = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                idArticle = (byte) ValidaLibrary.valida("Introduce el ID del articulo: ",MINCHAR,MAXCHAR_100,3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sCategoryName = ValidaLibrary.leer("Introduce la categoria: ");
                if (sCategoryName.length() > MINCHAR && sCategoryName.length() < MAXCHAR_60)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oArticleXCategory = new ArticleXCategory(new Article(idArticle), new Category(sCategoryName));
        return controller.removeArticleXCategory(oArticleXCategory);
    }

    private static void busqueda(GeneralController controller) {
        byte idArticle = 0;
        String sCategoryName = null;
        ArticleXCategory oArticleXCategory = null;
        boolean errorControl = true;
        int iNumArticlesXCategory;

        while (errorControl) {
            try {
                idArticle = (byte) ValidaLibrary.valida("Introduce el ID del articulo: ",MINCHAR,MAXCHAR_100,3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sCategoryName = ValidaLibrary.leer("Introduce la categoria: ");
                if (sCategoryName.length() > MINCHAR && sCategoryName.length() < MAXCHAR_60)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oArticleXCategory = new ArticleXCategory(new Article(idArticle), new Category(sCategoryName));
        iNumArticlesXCategory = controller.existeArticleXCategory(oArticleXCategory);

        if (iNumArticlesXCategory > 0) {
            System.out.println("Existen " + iNumArticlesXCategory + " en la base de datos.");
        }else
            System.out.println("No existe ningun articuloXcategoria con ese ID y categoria.");
    }

    private static void mostrarTodas(GeneralController controller) {
        List<ArticleXCategory> lArticleXCategory;

        lArticleXCategory = controller.getArticulosUsuariosController().getArticleXCategoryController().getTodasArticuloXCategoria();

        if (lArticleXCategory.size() > 0) {
            for (ArticleXCategory oArticleXCategory : lArticleXCategory) {
                System.out.println(oArticleXCategory);
            }
        }else{
            System.out.println("No hay ningun articuloXcategoria en la base de datos.");
        }
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nARTICULO X CATEGORIA: ");
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
