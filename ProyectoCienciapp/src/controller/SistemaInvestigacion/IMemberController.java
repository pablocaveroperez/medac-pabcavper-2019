package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.Member;

public interface IMemberController {
    // #########
    // # CRUDS #
    // #########
    int add(Member oObject);

    int remove(Member oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeMember(Member oObject);
}
