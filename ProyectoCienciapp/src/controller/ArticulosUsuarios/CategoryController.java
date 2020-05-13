package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.Category;

public class CategoryController implements ICategoryController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Category oObject) {
        int iRes = 0;
        if (oObject.checkCategory()) {
            String sql = "INSERT INTO category VALUES (\"" + oObject.getsCategoryName() + "\",\"" + oObject.getsDescription() + "\n)";
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Category oObject) {
        int iRes = 0;
        String sql = "DELETE FROM category WHERE category LIKE \"" + oObject.getsCategoryName() + "\"";
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
}
