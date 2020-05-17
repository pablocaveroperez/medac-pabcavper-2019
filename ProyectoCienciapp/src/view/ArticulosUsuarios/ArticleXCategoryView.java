package view.ArticulosUsuarios;

import controller.GeneralController;
import model.ArticulosUsuarios.Article;
import model.ArticulosUsuarios.ArticleType;
import model.ArticulosUsuarios.ArticleXCategory;
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

        oArticleXCategory = new ArticleXCategory();

        return controller.addArticle(oArticleXCategory);
    }

    private static int eliminar(GeneralController controller) {
        byte idArticle = 0;
        Article oArticle = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                idArticle = (byte) ValidaLibrary.valida("Introduce el ID del articulo: ",MINCHAR,MAXCHAR_100,3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oArticle = new Article(idArticle);
        return controller.removeArticle(oArticle);
    }

    private static void busqueda(GeneralController controller) {
        byte idArticle = 0;
        Article oArticle = null;
        boolean errorControl = true;
        int iNumArticles;

        while (errorControl) {
            try {
                idArticle = (byte) ValidaLibrary.valida("Introduce el ID del articulo: ",MINCHAR,MAXCHAR_100,3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oArticle = new Article(idArticle);
        iNumArticles = controller.existeArticle(oArticle);

        if (iNumArticles > 0) {
            System.out.println("Existen " + iNumArticles + " en la base de datos.");
        }else
            System.out.println("No existe ningun articulo con ese ID.");
    }

    private static void mostrarTodas(GeneralController controller) {
        List<Article> lArticle;

        lArticle = controller.getArticulosUsuariosController().getArticleController().getTodasArticulo();

        if (lArticle.size() > 0) {
            for (Article oArticle : lArticle) {
                System.out.println(oArticle);
            }
        }else{
            System.out.println("No hay ningun articulo en la base de datos.");
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
