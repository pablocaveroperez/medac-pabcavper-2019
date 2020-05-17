package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.Category;

import java.util.List;

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

    List<Category> getTodasCategorias();
}
