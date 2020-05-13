package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.ArticleRatingUser;

public class ArticleRatingUserController implements IArticleRatingUserController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(ArticleRatingUser oObject) {
        int iRes = 0;
        if (oObject.checkArticleRatingUser()) {
            String sql = "INSERT INTO articleratinguser VALUES (\"" + oObject.getoUser().getsUsername()
                    + "\",\"" + oObject.getoArticle().getIdArticle()
                    + "\",\"" + oObject.getsComment() + "\",\"" + oObject.getbRating()
                    + "\n)";
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(ArticleRatingUser oObject) {
        int iRes = 0;
        String sql = "DELETE FROM articleratinguser WHERE username LIKE \"" + oObject.getoUser().getsUsername()
                + "\" AND idArticle LIKE \"" + oObject.getoArticle().getIdArticle() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeArticleRatingUser(ArticleRatingUser oObject) {
        int iRes = 0;
        if (oObject.checkArticleRatingUser()) {
            String sql = "SELECT COUNT(*) FROM articleratinguser WHERE username LIKE \"" + oObject.getoUser().getsUsername()
                    + "\" AND idArticle LIKE \"" + oObject.getoArticle().getIdArticle() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
