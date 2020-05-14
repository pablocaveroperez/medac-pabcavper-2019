package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.SistemaInvestigacion.Specialization;

public class SpecializationController implements ISpecializationController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Specialization oObject) {
        int iRes = 0;
        if (oObject.checkSpecialization()) {
            String sql;
            if (oObject.getsDescription() != null) {
                sql = "INSERT INTO specialization VALUES (\"" + oObject.getsName() + "\",\"" + oObject.getsDescription() + "\")";
            } else {
                sql = "INSERT INTO specialization VALUES (\"" + oObject.getsName() + "\",null)";
            }
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Specialization oObject) {
        int iRes = 0;
        String sql = "DELETE FROM specialization WHERE name LIKE \"" + oObject.getsName() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeEspecializacion(Specialization oObject) {
        int iRes = 0;
        if (oObject.checkSpecialization()) {
            String sql = "SELECT COUNT(*) FROM specialization WHERE name LIKE \"" + oObject.getsName() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
