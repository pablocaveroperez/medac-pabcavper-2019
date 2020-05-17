package controller.Publicadores;

import model.Publicadores.Headquarters;

import java.util.List;

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

    List<Headquarters> getTodosHQ();
}
