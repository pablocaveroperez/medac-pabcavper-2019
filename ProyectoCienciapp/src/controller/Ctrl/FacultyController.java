package controller.Ctrl;

import controller.ConexionDB;
import model.Faculty;

public class FacultyController implements IFacultyController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Faculty oObject) {
        int iRes = 0;
        if (oObject.checkFaculty()) {
            String sql = "INSERT INTO faculty VALUES (\"" + oObject.getsFaculName() + "\")";
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
