package controller.SistemaInvestigacion;

import controller.ConexionDB;
import model.ArticulosUsuarios.User;
import model.SistemaInvestigacion.Member;
import model.SistemaInvestigacion.ResearchTeam;
import model.SistemaInvestigacion.Specialization;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
                        +"\")";
            } else {
                sql = "INSERT INTO member VALUES (\"" + oObject.getsDNI()
                        + "\",\"" + oObject.getBirthDate() + "\",\"" + oObject.getsName()
                        + "\",\"" + oObject.getsSurname() + "\",\"" + oObject.getoSpecialization().getsName()
                        + "\",\"" + oObject.getoResearchTeam().getIdResearchTeam() + "\",\"" + oObject.getoUser().getsUsername()
                        +"\")";
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

    @Override
    public List<Member> getTodosMiembros() {
        List<Member> lMiembros = new ArrayList<>();

        String sql = "SELECT dni, birthDate, name, surname, specialization, idResearchTeam, user FROM member";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sDNI = rs.getString(1);
                Date oDate = rs.getDate(2);
                GregorianCalendar birthDate = new GregorianCalendar();
                String sName = rs.getString(3);
                String sSurname = rs.getString(4);
                Specialization oSpecialization = new Specialization(rs.getString(5));
                ResearchTeam oResearchTeam = new ResearchTeam((byte) rs.getInt(6));
                User oUser = new User(rs.getString(7));
                if (oDate != null) {
                    birthDate.setTime(oDate);
                    lMiembros.add(new Member(sDNI, birthDate, sName, sSurname, oSpecialization, oResearchTeam, oUser));
                }else {
                    lMiembros.add(new Member(sDNI, sName, sSurname, oSpecialization, oResearchTeam, oUser));
                }

            }
            stm.close();
        } catch (SQLException exception) {
            lMiembros = null;
        }
        return lMiembros;
    }
}
