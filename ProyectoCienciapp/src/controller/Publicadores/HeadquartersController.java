package controller.Publicadores;

import controller.ConexionDB;
import model.Ctrl.Country;
import model.Publicadores.Headquarters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HeadquartersController implements IHeadquartersController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Headquarters oObject) {
        int iRes = 0;
        if (oObject.checkHeadquarters()) {
            String sql;
            if (oObject.getsAddres() != null) {
                sql = "INSERT INTO headquarters VALUES (\"" + oObject.getsName() + "\",\"" + oObject.getsAddres() + "\",\"" +
                        oObject.getsLocality()+ "\",\""+ oObject.getoCountry().getsName() +"\")";
            } else {
                sql = "INSERT INTO headquarters VALUES (\"" + oObject.getsName() + "\",null,\"" +
                        oObject.getsLocality()+ "\",\""+ oObject.getoCountry().getsName() +"\")";
            }
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Headquarters oObject) {
        int iRes = 0;
        String sql = "DELETE FROM headquarters WHERE name LIKE \"" + oObject.getsName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeHQ(Headquarters oObject) {
        int iRes = 0;
        if (oObject.checkHeadquarters()) {
            String sql = "SELECT COUNT(*) FROM headquarters WHERE name LIKE \"" + oObject.getsName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }

    @Override
    public List<Headquarters> getTodosHQ() {
        List<Headquarters> lHeadquarters = new ArrayList<>();

        String sql = "SELECT name, addres, locality, country FROM headquarters";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sName = rs.getString(1);
                String sAddres = rs.getString(2);
                String sLocality = rs.getString(3);
                Country oCountry = new Country(rs.getString(4));
                lHeadquarters.add(new Headquarters(sName, sAddres, sLocality, oCountry));
            }
            stm.close();
        } catch (SQLException exception) {
            lHeadquarters = null;
        }
        return lHeadquarters;
    }
}
