package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.University;

import java.util.List;

public interface IUniversityController {
    // #########
    // # CRUDS #
    // #########
    int add(University oObject);

    int remove(University oUniversity);

    // ###########
    // # QUERIES #
    // ###########
    int existeUniversidad(University oUniversity);

    List<University> getTodasUniversidades();
}
