package view;

import controller.ConexionDB;
import controller.GeneralController;
import model.ArticulosUsuarios.User;
import validaciones.ValidaLibrary;
import view.ArticulosUsuarios.LoginView;
import view.SistemaInvestigacion.SistemaInvestigacionView;

import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) {
        byte bOpcionPrincipal;
        GeneralController controller = new GeneralController("cienciapp");

        // Login
        if (ConexionDB.checkConnectionDatabase()) {
            User oUsuario = LoginView.login(controller);

            while (oUsuario == null) {
                System.out.println("Acceso no autorizado, intentelo de nuevo.");
                oUsuario = LoginView.login(controller);
            }

            System.out.println("¡Bienvenido a la aplicacion, " + oUsuario.getsUsername() + "!");

            do {
                bOpcionPrincipal = menuPrincipal();
                switch (bOpcionPrincipal) {
                    case 1:
                        SistemaInvestigacionView.menuSistemaInvestigacion(controller);
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    default:
                        try {
                            ConexionDB.getConnection().close();
                        }catch (SQLException exception) {
                        // TODO Auto-generated catch block
                            exception.printStackTrace();
                        }
                        System.out.println("Hasta luego maricarmen.");
                }
            } while (bOpcionPrincipal != 5);
        } else
            System.out.println("No se ha podido establecer conexion con la base de datos.");
    }

    public static byte menuPrincipal() {
        byte bOpcion = 0;
        boolean errorControl = true;

        System.out.println("\n\nMENU PRINCIPAL: ");
        System.out.println("1. Gestionar Sistemas de Investigacion.");
        System.out.println("2. Gestionar Paises.");
        System.out.println("3. Gestionar Publicadores.");
        System.out.println("4. Gestionar Articulos Usuarios.");
        System.out.println("5. Salir de la Aplicacion.");

        while (errorControl) {
            try {
                bOpcion = (byte) ValidaLibrary.valida("Introduce una opciom: ", 1, 5, 3);
                errorControl = false;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return bOpcion;
    }
}
