package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.Article;

public interface IArticleController {
    // #########
    // # CRUDS #
    // #########
    int add(Article oObject);

    int remove(Article oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeArticle(Article oObject);
}
