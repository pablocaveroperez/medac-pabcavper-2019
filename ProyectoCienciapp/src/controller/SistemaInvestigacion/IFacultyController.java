package controller.SistemaInvestigacion;

import model.SistemaInvestigacion.Faculty;

import java.util.List;

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

    List<Faculty> getTodasFacultades();
}
