package controller.Ctrl;

import controller.ConexionDB;
import model.University;

public class UniversityController implements IUniversityController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(University oObject) {
        int iRes = 0;
        if (oObject.checkUniversity()) {
            String sql = "INSERT INTO university VALUES (\"" + oObject.getsUniName() + "\")";
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(University oUniversity) {
        int iRes = 0;
        String sql = "DELETE FROM university WHERE uniName LIKE \"" + oUniversity.getsUniName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeUniversidad(University oUniversity) {
        int iRes = 0;
        if (oUniversity.checkUniversity()) {
            String sql = "SELECT COUNT(*) FROM university WHERE uniName LIKE \"" + oUniversity.getsUniName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
