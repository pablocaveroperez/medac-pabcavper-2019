package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.Article;
import model.ArticulosUsuarios.ArticleType;
import model.Publicadores.Magazine;
import model.SistemaInvestigacion.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Article> getTodasArticulo(){
        List<Article> lArticulo = new ArrayList<>();

        String sql = "SELECT idArticle, name, pages, magazine, dni, typeName FROM article";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                byte idArticle = rs.getByte(1);
                String sName = rs.getString(2);
                short shPages = rs.getShort(3);
                String sMagazine = rs.getString(4);
                String sDNI = rs.getString(5);
                String sTypeName = rs.getString(6);
                lArticulo.add(new Article(idArticle,shPages,sName,new Magazine(sMagazine), new Member(sDNI), new ArticleType(sTypeName)));
            }
            stm.close();
        } catch (SQLException exception) {
            lArticulo = null;
        }
        return lArticulo;
    }
}
