package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.Article;

public class ArticleController implements IArticleController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Article oObject) {
        int iRes = 0;
        if (oObject.checkArticle()) {
            String sql;
            if (!oObject.isPageNull()) {
                sql = "INSERT INTO article VALUES (\"" + oObject.getIdArticle() + "\",\"" + oObject.getsName()
                        + "\",\"" + oObject.getShPages() + "\",\"" + oObject.getoMagazine().getsName()
                        + "\",\"" + oObject.getoMember().getsDNI() +  "\",\"" + oObject.getoArticleType().getsTypeName()
                        + "\n)";
            } else {
                sql = "INSERT INTO article VALUES (\"" + oObject.getIdArticle() + "\",\"" + oObject.getsName()
                        + "\",null,\"" + oObject.getoMagazine().getsName()
                        + "\",\"" + oObject.getoMember().getsDNI() +  "\",\"" + oObject.getoArticleType().getsTypeName()
                        + "\n)";
            }
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Article oObject) {
        int iRes = 0;
        String sql = "DELETE FROM article WHERE idArticle LIKE \"" + oObject.getIdArticle() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeArticle(Article oObject) {
        int iRes = 0;
        if (oObject.checkArticle()) {
            String sql = "SELECT COUNT(*) FROM article WHERE idArticle LIKE \"" + oObject.getIdArticle() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
