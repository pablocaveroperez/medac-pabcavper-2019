package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.Ctrl.Country;
import model.SistemaInvestigacion.University;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UniversityController implements IUniversityController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(University oObject) {
        int iRes = 0;
        if (oObject.checkUniversity()) {
            String sql;
            if (oObject.getsAddres() != null) {
                sql = "INSERT INTO university VALUES (\"" + oObject.getsUniName() + "\",\"" + oObject.getsLocality() + "\",\"" +
                        oObject.getsAddres()+ "\",\""+ oObject.getoCountry().getsName() +"\")";
            }else {
                sql = "INSERT INTO university VALUES (\"" + oObject.getsUniName() + "\",\"" + oObject.getsLocality() + "\",null,\""+ oObject.getoCountry().getsName() +"\")";
            }
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(University oUniversity) {
        int iRes = 0;
        String sql = "DELETE FROM university WHERE uniName LIKE \"" + oUniversity.getsUniName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeUniversidad(University oUniversity) {
        int iRes = 0;
        if (oUniversity.checkUniversity()) {
            String sql = "SELECT COUNT(*) FROM university WHERE uniName LIKE \"" + oUniversity.getsUniName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }


    @Override
    public List<University> getTodasUniversidades() {
        List<University> lUniversity = new ArrayList<>();

        String sql = "SELECT uniName, locality, addres, country FROM university";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sUniName = rs.getString(1);
                String sLocality = rs.getString(2);
                String sAddres = rs.getString(3);
                Country oCountry = new Country(rs.getString(4));
                lUniversity.add(new University(sUniName,sLocality, sAddres, oCountry));
            }
            stm.close();
        } catch (SQLException exception) {
            lUniversity = null;
        }
        return lUniversity;
    }
}
