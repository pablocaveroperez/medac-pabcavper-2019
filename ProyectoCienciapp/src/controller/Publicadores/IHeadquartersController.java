package controller.Publicadores;

import model.Publicadores.Headquarters;

public interface IHeadquartersController {
    // #########
    // # CRUDS #
    // #########
    int add(Headquarters oObject);

    int remove(Headquarters oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeHQ(Headquarters oObject);
}
