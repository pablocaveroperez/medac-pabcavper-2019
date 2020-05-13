package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.User;

public interface IUserController {
    // #########
    // # CRUDS #
    // #########
    int add(User oObject);

    int remove(User oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeUser(User oObject);

    int checkLogin(User oUsuario);
}
