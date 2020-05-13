package controller.Publicadores;

import controller.ConexionDB;
import model.Publicadores.Headquarters;
import model.Publicadores.Magazine;

public class MagazineController implements IMagazineController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Magazine oObject) {
        int iRes = 0;
        if (oObject.checkMagazine()) {
            String sql = "INSERT INTO magazine VALUES (\"" + oObject.getsName() + "\",\"" + oObject.getoHeadquarters().getsName() +"\n)";
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
    public int existeHQ(Magazine oObject) {
        int iRes = 0;
        if (oObject.checkMagazine()) {
            String sql = "SELECT COUNT(*) FROM magazine WHERE name LIKE \"" + oObject.getsName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
