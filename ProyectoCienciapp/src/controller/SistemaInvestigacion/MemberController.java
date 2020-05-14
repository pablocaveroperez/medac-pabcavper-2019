package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.SistemaInvestigacion.Member;

public class MemberController implements IMemberController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(Member oObject) {
        int iRes = 0;
        if (oObject.checkMember()) {
            String sql;
            if (oObject.getBirthDate() == null) {
                sql = "INSERT INTO member VALUES (\"" + oObject.getsDNI()
                        + "\",null,\"" + oObject.getsName()
                        + "\",\"" + oObject.getsSurname() + "\",\"" + oObject.getoSpecialization().getsName()
                        + "\",\"" + oObject.getoResearchTeam().getIdResearchTeam() + "\",\"" + oObject.getoUser().getsUsername()
                        +"\n)";
            } else {
                sql = "INSERT INTO member VALUES (\"" + oObject.getsDNI()
                        + "\",\"" + oObject.getBirthDate() + "\",\"" + oObject.getsName()
                        + "\",\"" + oObject.getsSurname() + "\",\"" + oObject.getoSpecialization().getsName()
                        + "\",\"" + oObject.getoResearchTeam().getIdResearchTeam() + "\",\"" + oObject.getoUser().getsUsername()
                        +"\n)";
            }
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(Member oObject) {
        int iRes = 0;
        String sql = "DELETE FROM member WHERE dni LIKE \"" + oObject.getsDNI() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeMember(Member oObject) {
        int iRes = 0;
        if (oObject.checkMember()) {
            String sql = "SELECT COUNT(*) FROM member WHERE dni LIKE \"" + oObject.getsDNI() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }
}
