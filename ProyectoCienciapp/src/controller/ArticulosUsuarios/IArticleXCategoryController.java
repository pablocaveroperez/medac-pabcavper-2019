package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.ArticleXCategory;

public interface IArticleXCategoryController {
    // #########
    // # CRUDS #
    // #########
    int add(ArticleXCategory oObject);

    int remove(ArticleXCategory oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeArticleXCategoryController(ArticleXCategory oObject);
}
