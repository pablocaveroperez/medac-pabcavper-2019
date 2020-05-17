package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleRatingUserController implements IArticleRatingUserController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(ArticleRatingUser oObject) {
        int iRes = 0;
        if (oObject.checkArticleRatingUser()) {
            String sql;
            if (oObject.getsComment() != null) {
                sql = "INSERT INTO articleratinguser VALUES (\"" + oObject.getoUser().getsUsername()
                        + "\",\"" + oObject.getoArticle().getIdArticle()
                        + "\",\"" + oObject.getsComment() + "\",\"" + oObject.getbRating()
                        + "\")";
            } else {
                sql = "INSERT INTO articleratinguser VALUES (\"" + oObject.getoUser().getsUsername()
                        + "\",\"" + oObject.getoArticle().getIdArticle()
                        + "\",null,\"" + oObject.getbRating()
                        + "\")";
            }
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

    @Override
    public List<ArticleRatingUser> getTodasCalificaciones(){
        List<ArticleRatingUser> lArticuloRatingUser = new ArrayList<>();

        String sql = "SELECT username, idArticle, comment, rating FROM articleratinguser";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sUsername = rs.getString(1);
                byte idArticle = rs.getByte(2);
                String sComment = rs.getString(3);
                byte bRating = rs.getByte(4);
                lArticuloRatingUser.add(new ArticleRatingUser(new User(sUsername), new Article(idArticle), sComment, bRating));
            }
            stm.close();
        } catch (SQLException exception) {
            lArticuloRatingUser = null;
        }
        return lArticuloRatingUser;
    }
}
