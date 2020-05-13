package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.ArticleType;

public interface IArticleTypeController {
    // #########
    // # CRUDS #
    // #########
    int add(ArticleType oObject);

    int remove(ArticleType oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeArticleType(ArticleType oObject);
}
