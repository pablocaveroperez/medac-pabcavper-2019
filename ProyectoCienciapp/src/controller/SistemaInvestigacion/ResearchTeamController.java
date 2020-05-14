package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.SistemaInvestigacion.ResearchTeam;

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
}
