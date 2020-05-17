package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.User;

import java.util.List;

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

    List<User> getTodasCategorias();
}
