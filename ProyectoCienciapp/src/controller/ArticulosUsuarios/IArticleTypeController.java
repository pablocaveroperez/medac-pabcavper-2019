package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.ArticleType;

import java.util.List;

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

    List<ArticleType> getTodasTipoArticulo();
}
