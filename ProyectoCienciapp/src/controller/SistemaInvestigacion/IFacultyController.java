package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.Faculty;

public interface IFacultyController {
    // #########
    // # CRUDS #
    // #########
    int add(Faculty oObject);

    int remove(Faculty oFaculty);

    // ###########
    // # QUERIES #
    // ###########
    int existeFacultad(Faculty oFaculty);
}
