package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.SistemaInvestigacion.Department;
import model.SistemaInvestigacion.Faculty;
import model.SistemaInvestigacion.ResearchTeam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResearchTeamController implements IResearchTeamController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(ResearchTeam oObject) {
        int iRes = 0;
        if (oObject.checkResearchTeam()) {
            String sql;
            if (oObject.getsName() != null) {
                sql = "INSERT INTO researchteam VALUES (\"" + oObject.getIdResearchTeam() + "\",\"" + oObject.getsName() + "\",\"" + oObject.getiBudget() + "\",\"" + oObject.getoDepartment().getIdDepartment() + "\")";
            } else {
                sql = "INSERT INTO researchteam VALUES (\"" + oObject.getIdResearchTeam() + "\",null,\"" + oObject.getiBudget() + "\",\"" + oObject.getoDepartment().getIdDepartment() + "\")";
            }
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(ResearchTeam oObject) {
        int iRes = 0;
        String sql = "DELETE FROM researchteam WHERE idResearchTeam LIKE \"" + oObject.getIdResearchTeam() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeEquipoInvestigacion(ResearchTeam oObject) {
        int iRes = 0;
        if (oObject.checkResearchTeam()) {
            String sql = "SELECT COUNT(*) FROM researchteam WHERE idResearchTeam LIKE \"" + oObject.getIdResearchTeam() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }

    @Override
    public List<ResearchTeam> getTodosEquipos() {
        List<ResearchTeam> lEquipos = new ArrayList<>();

        String sql = "SELECT idResearchTeam, name, budget, idDepartment FROM researchteam";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                byte idResearchTeam = (byte) rs.getInt(1);
                String sName = rs.getString(2);
                int budget = rs.getInt(3);
                byte idDepartment = (byte) rs.getInt(4);
                lEquipos.add(new ResearchTeam(idResearchTeam, new Department(idDepartment),sName, budget));
            }
            stm.close();
        } catch (SQLException exception) {
            lEquipos = null;
        }
        return lEquipos;
    }
}
