package controller.Ctrl;

import controller.ConexionDB;
import model.Country;

public class CountryController implements ICountryController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Country oObject) {
        int iRes = 0;
        if (oObject.checkCountry()) {
            String sql = "INSERT INTO country VALUES (\"" + oObject.getsName() + "\")";
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Country oCounty) {
        int iRes = 0;
        String sql = "DELETE FROM country WHERE name LIKE \"" + oCounty.getsName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existePais(Country oCountry) {
        int iRes = 0;
        if (oCountry.checkCountry()) {
            String sql = "SELECT COUNT(*) FROM pais WHERE nombre LIKE \"" + oCountry.getsName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
