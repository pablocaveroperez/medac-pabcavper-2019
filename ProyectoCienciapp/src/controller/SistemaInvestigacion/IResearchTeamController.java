package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.ResearchTeam;

import java.util.List;

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

    List<ResearchTeam> getTodosEquipos();
}
