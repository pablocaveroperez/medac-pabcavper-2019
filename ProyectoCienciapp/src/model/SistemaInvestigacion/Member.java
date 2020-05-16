package model.SistemaInvestigacion;

import model.LimitsDB;
import model.ArticulosUsuarios.User;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Member implements LimitsDB, IMember {
    private String sDNI;                                            // Primary Key
    private GregorianCalendar birthDate;  // NULO
    private String sName;                                           // NN
    private String sSurname;                                        // NN
    private Specialization oSpecialization;                         // NN
    private ResearchTeam oResearchTeam;                             // NN
    private User oUser;                                             // NN

    public Member(String sDNI, GregorianCalendar birthDate, String sName, String sSurname, Specialization oSpecialization, ResearchTeam oResearchTeam, User oUser) {
        setsDNI(sDNI);
        setBirthDate(birthDate);
        setsName(sName);
        setsSurname(sSurname);
        setoSpecialization(oSpecialization);
        setoResearchTeam(oResearchTeam);
        setoUser(oUser);
    }

    public Member(String sDNI, String sName, String sSurname, Specialization oSpecialization, ResearchTeam oResearchTeam, User oUser) {
        setsDNI(sDNI);
        setsName(sName);
        setsSurname(sSurname);
        setoSpecialization(oSpecialization);
        setoResearchTeam(oResearchTeam);
        setoUser(oUser);
    }

    public Member(String sDNI) {
        setsDNI(sDNI);
    }

    public User getoUser() {
        return oUser;
    }

    public boolean setoUser(User oUser) {
        boolean bExito = false;
        if (oUser.checkUser()) {
            this.oUser = oUser;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public String getsDNI() {
        return sDNI;
    }

    private boolean setsDNI(String sDNI) {
        boolean bExito = false;
        if (sDNI != null && sDNI.length() == 9) {
            this.sDNI = sDNI;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean setBirthDate(GregorianCalendar birthDate) {
        boolean bExito = false;
        if (birthDate == null) {
            this.birthDate = null;
            bExito = true;
        }else {
            if (birthDate.get(Calendar.YEAR) > 1900 && birthDate.get(Calendar.YEAR) < 2020) {
                this.birthDate = birthDate;
                bExito = true;
            }
        }
        return bExito;
    }

    @Override
    public String getsName() {
        return sName;
    }

    @Override
    public boolean setsName(String sName) {
        boolean bExito = false;
        if (sName != null && sName.length() < MAXCHAR_50 && sName.length() > MINCHAR) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public String getsSurname() {
        return sSurname;
    }

    @Override
    public boolean setsSurname(String sSurname) {
        boolean bExito = false;
        if (sSurname != null && sSurname.length() > MINCHAR && sSurname.length() < MAXCHAR_50) {
            this.sSurname = sSurname;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public Specialization getoSpecialization() {
        return oSpecialization;
    }

    @Override
    public boolean setoSpecialization(Specialization oSpecialization) {
        boolean bExito = false;
        if (oSpecialization.checkSpecialization()) {
            this.oSpecialization = oSpecialization;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public ResearchTeam getoResearchTeam() {
        return oResearchTeam;
    }

    @Override
    public boolean setoResearchTeam(ResearchTeam oResearchTeam) {
        boolean bExito = false;
        if (oResearchTeam.checkResearchTeam()) {
            this.oResearchTeam = oResearchTeam;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkMember() {
        boolean bExito = false;
        if (getsDNI() != null)
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return getsDNI().equals(member.getsDNI());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsDNI());
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "**********************";
        salida += "\nDNI: " + getsDNI();
        salida += "\nNombre: " + getsName();
        salida += "\nApellido: " + getsSurname();
        salida += "\nUsuario: " + getoUser();
        if (getBirthDate() != null) {
            salida += "\nFecha Nacimiento: " + getBirthDate().get(Calendar.DATE) + "/" + getBirthDate().get(Calendar.MONTH)
                    + "/" + getBirthDate().get(Calendar.YEAR);
        }
        salida += "\nEspecializacion: " + getoSpecialization().getsName();
        salida += "\nEquipo de investigacion: " + getoResearchTeam().getIdResearchTeam();
        salida += "\n**********************";
        return salida;
    }
}
