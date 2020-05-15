package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.SistemaInvestigacion.Department;
import model.SistemaInvestigacion.Faculty;
import model.SistemaInvestigacion.University;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentController implements IDepartmentController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Department oObject) {
        int iRes = 0;
        if (oObject.checkDepartment()) {
            String sql;
            if (oObject.getsName() != null) {
                sql = "INSERT INTO department VALUES (\"" + oObject.getIdDepartment() + "\",\"" + oObject.getoFaculty().getsFaculName() + "\",\"" + oObject.getsName() + "\")";
            } else {
                sql = "INSERT INTO department VALUES (\"" + oObject.getIdDepartment() + "\",\"" + oObject.getoFaculty().getsFaculName() + "\",null)";
            }
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
    public int existeDepartamento(Department oObject) {
        int iRes = 0;
        if (oObject.checkDepartment()) {
            String sql = "SELECT COUNT(*) FROM department WHERE idDepartment LIKE \"" + oObject.getIdDepartment() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }

    @Override
    public List<Department> getTodosDepartamentos() {
        List<Department> lDepartment = new ArrayList<>();

        String sql = "SELECT idDepartment, faculName, name FROM department";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                byte idDepartment = (byte) rs.getInt(1);
                String sFaculNane = rs.getString(2);
                String sName = rs.getString(3);
                lDepartment.add(new Department(idDepartment,new Faculty(sFaculNane),sName));
            }
            stm.close();
        } catch (SQLException exception) {
            lDepartment = null;
        }
        return lDepartment;
    }
}
