package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.ResearchTeam;

public interface IResearchTeamController {
    // #########
    // # CRUDS #
    // #########
    int add(ResearchTeam oObject);

    int remove(ResearchTeam oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeEquipoInvestigacion(ResearchTeam oObject);
}
