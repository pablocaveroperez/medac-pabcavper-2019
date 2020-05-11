package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.Department;

public interface IDepartmentController {
    // #########
    // # CRUDS #
    // #########
    int add(Department oObject);

    int remove(Department oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeFacultad(Department oObject);
}
