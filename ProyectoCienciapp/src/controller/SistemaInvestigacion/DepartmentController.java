package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.SistemaInvestigacion.Department;

public class DepartmentController implements IDepartmentController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Department oObject) {
        int iRes = 0;
        if (oObject.checkDepartment()) {
            String sql = "INSERT INTO department VALUES (\"" + oObject.getIdDepartment() + "\",\"" + oObject.getoFaculty().getsFaculName() + "\",\"" + oObject.getsName() + "\")";
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Department oObject) {
        int iRes = 0;
        String sql = "DELETE FROM department WHERE idDepartment LIKE \"" + oObject.getIdDepartment() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeFacultad(Department oObject) {
        int iRes = 0;
        if (oObject.checkDepartment()) {
            String sql = "SELECT COUNT(*) FROM department WHERE idDepartment LIKE \"" + oObject.getIdDepartment() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
