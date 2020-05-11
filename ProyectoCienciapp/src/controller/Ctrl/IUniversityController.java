package controller.Ctrl;

import model.University;

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
}
