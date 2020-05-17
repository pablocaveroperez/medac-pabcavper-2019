package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.Category;
import model.Publicadores.Headquarters;
import model.Publicadores.Magazine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryController implements ICategoryController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Category oObject) {
        int iRes = 0;
        if (oObject.checkCategory()) {
            String sql;
            if (oObject.getsDescription() != null) {
                sql = "INSERT INTO category VALUES (\"" + oObject.getsCategoryName() + "\",\"" + oObject.getsDescription() + "\")";
            } else {
                sql = "INSERT INTO category VALUES (\"" + oObject.getsCategoryName() + "\",null)";
            }
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Category oObject) {
        int iRes = 0;
        String sql = "DELETE FROM category WHERE categoryName LIKE \"" + oObject.getsCategoryName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeCategory(Category oObject) {
        int iRes = 0;
        if (oObject.checkCategory()) {
            String sql = "SELECT COUNT(*) FROM category WHERE categoryName LIKE \"" + oObject.getsCategoryName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }

    @Override
    public List<Category> getTodasCategorias(){
        List<Category> lCategorias = new ArrayList<>();

        String sql = "SELECT categoryName, description FROM category";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sCategoryName = rs.getString(1);
                String sDescription = rs.getString(2);
                lCategorias.add(new Category(sCategoryName, sDescription));
            }
            stm.close();
        } catch (SQLException exception) {
            lCategorias = null;
        }
        return lCategorias;
    }
}
