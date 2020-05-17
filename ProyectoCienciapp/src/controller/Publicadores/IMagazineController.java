package controller.Publicadores;

import model.Publicadores.Magazine;

import java.util.List;

public interface IMagazineController {
    // #########
    // # CRUDS #
    // #########
    int add(Magazine oObject);

    int remove(Magazine oObject);

    // ###########
    // # QUERIES #
    // ###########
    int existeMagazine(Magazine oObject);

    List<Magazine> getTodasRevistas();
}
