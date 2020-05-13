package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.ArticleType;

public class ArticleTypeController implements IArticleTypeController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(ArticleType oObject) {
        int iRes = 0;
        if (oObject.checkArticleType()) {
            String sql = "INSERT INTO articletype VALUES (\"" + oObject.getsTypeName() + "\",\"" + oObject.getsDescription() + "\n)";
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(ArticleType oObject) {
        int iRes = 0;
        String sql = "DELETE FROM articletype WHERE typeName LIKE \"" + oObject.getsTypeName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeArticleType(ArticleType oObject) {
        int iRes = 0;
        if (oObject.checkArticleType()) {
            String sql = "SELECT COUNT(*) FROM articletype WHERE typeName LIKE \"" + oObject.getsTypeName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
