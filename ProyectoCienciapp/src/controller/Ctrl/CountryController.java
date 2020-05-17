package controller.Ctrl;

import controller.ConexionDB;
import model.Ctrl.Country;
import model.SistemaInvestigacion.Department;
import model.SistemaInvestigacion.Faculty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Country> getTodosPaises() {
        List<Country> lCountry = new ArrayList<>();

        String sql = "SELECT name FROM country";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sName = rs.getString(1);
                lCountry.add(new Country(sName));
            }
            stm.close();
        } catch (SQLException exception) {
            lCountry = null;
        }
        return lCountry;
    }
}
