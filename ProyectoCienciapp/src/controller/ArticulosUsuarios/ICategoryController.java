package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.Category;

public interface ICategoryController {
    // #########
    // # CRUDS #
    // #########
    int add(Category oObject);

    int remove(Category oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeCategory(Category oObject);
}
