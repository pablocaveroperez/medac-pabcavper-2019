package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.Article;

import java.util.List;

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

    List<Article> getTodasArticulo();
}
