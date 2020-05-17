package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.ArticleXCategory;

import java.util.List;

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

    List<ArticleXCategory> getTodasArticuloXCategoria();
}
