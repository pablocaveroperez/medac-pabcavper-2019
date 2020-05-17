package controller.Publicadores;

import controller.ConexionDB;
import model.Ctrl.Country;
import model.Publicadores.Headquarters;
import model.Publicadores.Magazine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MagazineController implements IMagazineController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Magazine oObject) {
        int iRes = 0;
        if (oObject.checkMagazine()) {
            String sql = "INSERT INTO magazine VALUES (\"" + oObject.getsName() + "\",\"" + oObject.getoHeadquarters().getsName() +"\")";
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Magazine oObject) {
        int iRes = 0;
        String sql = "DELETE FROM magazine WHERE name LIKE \"" + oObject.getsName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeMagazine(Magazine oObject) {
        int iRes = 0;
        if (oObject.checkMagazine()) {
            String sql = "SELECT COUNT(*) FROM magazine WHERE name LIKE \"" + oObject.getsName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }

    @Override
    public List<Magazine> getTodosRevistas() {
        List<Magazine> lRevistas = new ArrayList<>();

        String sql = "SELECT name, headQuarters FROM magazine";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sName = rs.getString(1);
                String sHQ = rs.getString(2);
                lRevistas.add(new Magazine(sName, new Headquarters(sHQ)));
            }
            stm.close();
        } catch (SQLException exception) {
            lRevistas = null;
        }
        return lRevistas;
    }
}
