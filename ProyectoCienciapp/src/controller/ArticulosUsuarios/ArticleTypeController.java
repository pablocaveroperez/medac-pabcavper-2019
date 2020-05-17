package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.ArticleType;
import model.ArticulosUsuarios.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleTypeController implements IArticleTypeController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(ArticleType oObject) {
        int iRes = 0;
        if (oObject.checkArticleType()) {
            String sql;
            if (oObject.getsDescription() != null) {
                sql = "INSERT INTO articletype VALUES (\"" + oObject.getsTypeName() + "\",\"" + oObject.getsDescription() + "\")";
            } else {
                sql = "INSERT INTO articletype VALUES (\"" + oObject.getsTypeName() + "\",null)";
            }
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

    @Override
    public List<ArticleType> getTodasTipoArticulo(){
        List<ArticleType> lTipoArticulo = new ArrayList<>();

        String sql = "SELECT typeName, description FROM articletype";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sTypeName = rs.getString(1);
                String sDescription = rs.getString(2);
                lTipoArticulo.add(new ArticleType(sTypeName, sDescription));
            }
            stm.close();
        } catch (SQLException exception) {
            lTipoArticulo = null;
        }
        return lTipoArticulo;
    }
}
