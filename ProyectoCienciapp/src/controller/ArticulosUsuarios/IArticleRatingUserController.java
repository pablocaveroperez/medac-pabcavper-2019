package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.ArticleRatingUser;

public interface IArticleRatingUserController {
    // #########
    // # CRUDS #
    // #########
    int add(ArticleRatingUser oObject);

    int remove(ArticleRatingUser oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeArticleRatingUser(ArticleRatingUser oObject);
}
