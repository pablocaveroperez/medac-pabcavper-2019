package controller.Ctrl;

import model.Ctrl.Country;

public interface ICountryController {
    // #########
    // # CRUDS #
    // #########
    int add(Country oObject);

    int remove(Country oCounty);

    // ###########
    // # QUERIES #
    // ###########
    int existePais(Country oCountry);
}
