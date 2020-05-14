package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.SistemaInvestigacion.University;

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
}
