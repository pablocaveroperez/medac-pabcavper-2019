package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.Member;

import java.util.List;

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

    List<Member> getTodosMiembros();
}
