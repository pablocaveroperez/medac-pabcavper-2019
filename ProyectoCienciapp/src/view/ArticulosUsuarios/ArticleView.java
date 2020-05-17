package view.ArticulosUsuarios;

import controller.GeneralController;
import model.ArticulosUsuarios.Article;
import model.ArticulosUsuarios.ArticleType;
import model.LimitsDB;
import model.Publicadores.Magazine;
import model.SistemaInvestigacion.Member;
import validaciones.ValidaLibrary;

import java.util.List;

public class ArticleView implements LimitsDB {
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
        String sName = null;
        String sMagazine = null;
        String sDNI = null;
        String sTypeName = null;
        byte idArticle = 0;
        short shPages = 1;
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

        errorControl = true;
        while (errorControl) {
            try {
                sName = ValidaLibrary.leer("Introduce el nombre del articulo: ");
                if (sName.length() > MINCHAR && sName.length() < MAXCHAR_55)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                shPages = (short) ValidaLibrary.valida("Introduce el numero de paginas(Pon 1 si no se quiere introducir): )",MINCHAR,MAXCHAR_1000,4);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sMagazine = ValidaLibrary.leer("Introduce el nombre de la revista: ");
                if (sMagazine.length() > MINCHAR && sMagazine.length() < MAXCHAR_100)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sDNI = ValidaLibrary.leer("Introduce el dni del autor: ");
                if (sDNI.length() == DNILENGTH)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sTypeName = ValidaLibrary.leer("Introduce el tipo de articulo: ");
                if (sTypeName.length() < MAXCHAR_50 && sTypeName.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oArticle = new Article(idArticle,shPages,sName,new Magazine(sMagazine),new Member(sDNI),new ArticleType(sTypeName));

        return controller.addArticle(oArticle);
    }

    private static int eliminar(GeneralController controller) {
        String sTypeName = null;
        ArticleType oType = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sTypeName = ValidaLibrary.leer("Introduce el nombre: ");
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
                sTypeName = ValidaLibrary.leer("Introduce el nombre: ");
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

        System.out.println("\n\nARTICULO: ");
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
