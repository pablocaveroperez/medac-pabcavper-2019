package controller.Ctrl;

import model.Faculty;

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
