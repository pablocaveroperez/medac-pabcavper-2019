package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.ArticleXCategory;

public class ArticleXCategoryController implements IArticleXCategoryController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(ArticleXCategory oObject) {
        int iRes = 0;
        if (oObject.checkArticleXCategory()) {
            String sql = "INSERT INTO article_x_category VALUES (\"" + oObject.getoArticle().getIdArticle()
                    + "\",\"" + oObject.getoCategory().getsCategoryName()
                    + "\n)";
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(ArticleXCategory oObject) {
        int iRes = 0;
        String sql = "DELETE FROM article_x_category WHERE idArticle LIKE \"" + oObject.getoArticle().getIdArticle()
                + "\" AND categoryName LIKE \"" + oObject.getoCategory().getsCategoryName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeArticleXCategoryController(ArticleXCategory oObject) {
        int iRes = 0;
        if (oObject.checkArticleXCategory()) {
            String sql = "SELECT COUNT(*) FROM article_x_category WHERE idArticle LIKE \"" + oObject.getoArticle().getIdArticle()
                    + "\" AND categoryName LIKE \"" + oObject.getoCategory().getsCategoryName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
