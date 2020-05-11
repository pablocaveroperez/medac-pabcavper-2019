package controller.Ctrl;

import controller.ConexionDB;
import model.Department;
import model.Faculty;

public class DepartmentController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Department oObject) {
        int iRes = 0;
        if (oObject.checkDepartment()) {
            String sql = "INSERT INTO faculty VALUES (\"" + oObject.getIdDepartment() + "\")";
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Faculty oFaculty) {
        int iRes = 0;
        String sql = "DELETE FROM faculty WHERE faculName LIKE \"" + oFaculty.getsFaculName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeFacultad(Faculty oFaculty) {
        int iRes = 0;
        if (oFaculty.checkFaculty()) {
            String sql = "SELECT COUNT(*) FROM faculty WHERE faculName LIKE \"" + oFaculty.getsFaculName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
