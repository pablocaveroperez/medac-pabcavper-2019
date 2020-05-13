package view.ArticulosUsuarios;

import controller.GeneralController;
import model.ArticulosUsuarios.User;
import validaciones.ValidaLibrary;

public class LoginView {
    public static User login(GeneralController controller) {
        boolean errorControl = true;
        String sUsername = null;
        String sPassword = null;
        String sEmail = null;
        User oLoginUser = null;

        System.out.println("Por favor, introduzca sus credenciales para acceder.");
        while (errorControl) {
            try {
                sUsername = ValidaLibrary.leer("Introduce el nombre de usuario: ");
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error en el nombre de usuario: " + exception.getMessage());
            }
        }

        errorControl = true;
        while (errorControl) {
            try {
                sPassword = ValidaLibrary.leer("Introduce la contrasena: ");
                errorControl = false;
            } catch (Exception exception) {
                System.out.println("Error en la contrasena: " + exception.getMessage());
            }
        }

        User oUsuario = new User(sUsername, sPassword);

        if (controller.getArticulosUsuariosController().getUserController().checkLogin(oUsuario) > 0)
            oLoginUser = oUsuario;

        return oLoginUser;
    }
}
