package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.Specialization;

public interface ISpecializationController {
    // #########
    // # CRUDS #
    // #########
    int add(Specialization oObject);

    int remove(Specialization oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeEspecializacion(Specialization oObject);
}
