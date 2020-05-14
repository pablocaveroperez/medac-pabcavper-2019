package controller.Publicadores;

import controller.ConexionDB;
import model.Publicadores.Headquarters;

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
                        oObject.getsLocality()+ "\",\""+ oObject.getoCountry().getsName() +"\n)";
            } else {
                sql = "INSERT INTO headquarters VALUES (\"" + oObject.getsName() + "\",null,\"" +
                        oObject.getsLocality()+ "\",\""+ oObject.getoCountry().getsName() +"\n)";
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
}
