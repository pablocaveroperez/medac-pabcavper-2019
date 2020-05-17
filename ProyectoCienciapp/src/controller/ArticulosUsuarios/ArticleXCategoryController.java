package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.Article;
import model.ArticulosUsuarios.ArticleType;
import model.ArticulosUsuarios.ArticleXCategory;
import model.ArticulosUsuarios.Category;
import model.Publicadores.Magazine;
import model.SistemaInvestigacion.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                    + "\")";
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

    @Override
    public List<ArticleXCategory> getTodasArticuloXCategoria(){
        List<ArticleXCategory> lArticuloXCategory = new ArrayList<>();

        String sql = "SELECT idArticle, categoryName FROM article_x_category";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                byte idArticle = rs.getByte(1);
                String sCategoryName = rs.getString(2);
                lArticuloXCategory.add(new ArticleXCategory(new Article(idArticle), new Category(sCategoryName)));
            }
            stm.close();
        } catch (SQLException exception) {
            lArticuloXCategory = null;
        }
        return lArticuloXCategory;
    }
}
