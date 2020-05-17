package view.ArticulosUsuarios;

import controller.GeneralController;
import model.ArticulosUsuarios.Article;
import model.ArticulosUsuarios.ArticleRatingUser;
import model.ArticulosUsuarios.User;
import model.LimitsDB;
import validaciones.ValidaLibrary;

import java.util.List;

public class ArticleRatingUserView implements LimitsDB {
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
        String sUsername = null;
        byte idArticle = 0;
        String sComment = null;
        byte bRating = 0;
        ArticleRatingUser oArticleRatingUser = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sUsername = ValidaLibrary.leer("Introduce el nombre de usuario: ");
                if (sUsername.length() < MAXCHAR_50 && sUsername.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
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
                sComment = ValidaLibrary.leer("Introduce el comentario(Puede ser nulo): ");
                if (sComment.equals("") || (sComment.length() > MINCHAR && sComment.length() < MAXCHAR_255))
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                bRating = (byte) ValidaLibrary.valida("Introduce la valoracion del articulo(Sobre 10): ", MINCHAR, MAXRATING,3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oArticleRatingUser = new ArticleRatingUser(new User(sUsername), new Article(idArticle), sComment, bRating);
        return controller.addArticleRatingUser(oArticleRatingUser);
    }

    private static int eliminar(GeneralController controller) {
        String sUsername = null;
        byte idArticle = 0;
        ArticleRatingUser oArticleRatingUser = null;
        boolean errorControl = true;

        while (errorControl) {
            try {
                sUsername = ValidaLibrary.leer("Introduce el nombre de usuario: ");
                if (sUsername.length() < MAXCHAR_50 && sUsername.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                idArticle = (byte) ValidaLibrary.valida("Introduce el ID del articulo: ",MINCHAR,MAXCHAR_100,3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oArticleRatingUser = new ArticleRatingUser(new User(sUsername), new Article(idArticle));
        return controller.removeArticleRatingUser(oArticleRatingUser);
    }

    private static void busqueda(GeneralController controller) {
        String sUsername = null;
        byte idArticle = 0;
        ArticleRatingUser oArticleRatingUser = null;
        boolean errorControl = true;
        int iNumArticleRatingUser;

        while (errorControl) {
            try {
                sUsername = ValidaLibrary.leer("Introduce el nombre de usuario: ");
                if (sUsername.length() < MAXCHAR_50 && sUsername.length() > MINCHAR)
                    errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                idArticle = (byte) ValidaLibrary.valida("Introduce el ID del articulo: ",MINCHAR,MAXCHAR_100,3);
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }

        oArticleRatingUser = new ArticleRatingUser(new User(sUsername), new Article(idArticle));
        iNumArticleRatingUser = controller.existeArticleRatingUser(oArticleRatingUser);

        if (iNumArticleRatingUser > 0) {
            System.out.println("Existen " + iNumArticleRatingUser + " en la base de datos.");
        } else
            System.out.println("No hay ninguna calificacion de ese usuario a ese articulo.");
    }

    private static void mostrarTodas(GeneralController controller) {
        List<ArticleRatingUser> lArticleRatingUsers;

        lArticleRatingUsers = controller.getArticulosUsuariosController().getArticleRatingUserController().getTodasCalificaciones();

        if (lArticleRatingUsers.size() > 0) {
            for (ArticleRatingUser oArticleRatingUser: lArticleRatingUsers) {
                System.out.println(oArticleRatingUser);
            }
        }else
            System.out.println("No hay ninguna calificacion en la base de datos.");
    }

    private static byte opcionMenu() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nPUNTUACION DE ARTICULO: ");
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
