package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.Ctrl.Country;
import model.SistemaInvestigacion.Faculty;
import model.SistemaInvestigacion.University;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FacultyController implements IFacultyController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Faculty oObject) {
        int iRes = 0;
        if (oObject.checkFaculty()) {
            String sql = "INSERT INTO faculty VALUES (\"" + oObject.getsFaculName() + "\",\"" + oObject.getoUniversity().getsUniName() +"\")";
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

    @Override
    public List<Faculty> getTodasFacultades() {
        List<Faculty> lFaculty = new ArrayList<>();

        String sql = "SELECT faculName, uniName FROM faculty";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sFaculNane = rs.getString(1);
                String sUniName = rs.getString(2);
                lFaculty.add(new Faculty(sFaculNane,new University(sUniName)));
            }
            stm.close();
        } catch (SQLException exception) {
            lFaculty = null;
        }
        return lFaculty;
    }
}
