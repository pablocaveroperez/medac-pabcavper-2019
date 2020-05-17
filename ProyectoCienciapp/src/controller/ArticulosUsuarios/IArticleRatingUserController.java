package controller.ArticulosUsuarios;

import model.ArticulosUsuarios.ArticleRatingUser;

import java.util.List;

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

    List<ArticleRatingUser> getTodasCalificaciones();
}
