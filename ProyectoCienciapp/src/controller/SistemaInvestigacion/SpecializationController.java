package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.SistemaInvestigacion.Department;
import model.SistemaInvestigacion.ResearchTeam;
import model.SistemaInvestigacion.Specialization;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecializationController implements ISpecializationController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Specialization oObject) {
        int iRes = 0;
        if (oObject.checkSpecialization()) {
            String sql;
            if (oObject.getsDescription() != null) {
                sql = "INSERT INTO specialization VALUES (\"" + oObject.getsName() + "\",\"" + oObject.getsDescription() + "\")";
            } else {
                sql = "INSERT INTO specialization VALUES (\"" + oObject.getsName() + "\",null)";
            }
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Specialization oObject) {
        int iRes = 0;
        String sql = "DELETE FROM specialization WHERE name LIKE \"" + oObject.getsName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeEspecializacion(Specialization oObject) {
        int iRes = 0;
        if (oObject.checkSpecialization()) {
            String sql = "SELECT COUNT(*) FROM specialization WHERE name LIKE \"" + oObject.getsName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }

    @Override
    public List<Specialization> getTodosEspecializaciones() {
        List<Specialization> lEspecializaciones = new ArrayList<>();

        String sql = "SELECT name, description FROM specialization";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sName = rs.getString(1);
                String sDescription = rs.getString(2);
                lEspecializaciones.add(new Specialization(sName, sDescription));
            }
            stm.close();
        } catch (SQLException exception) {
            lEspecializaciones = null;
        }
        return lEspecializaciones;
    }
}
