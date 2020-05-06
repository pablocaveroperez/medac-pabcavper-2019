package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Member implements LimitsDB {
    private String sDNI; // Primary Key
    private GregorianCalendar birthDate = new GregorianCalendar(); // NULO
    private String sName; // NN
    private String sSurname; // NN
    private Specialization oSpecialization; // NN
    private ResearchTeam oResearchTeam; // NN

    public Member(String sDNI, GregorianCalendar birthDate, String sName, String sSurname, Specialization oSpecialization, ResearchTeam oResearchTeam) {
        setsDNI(sDNI);
        setBirthDate(birthDate);
        setsName(sName);
        setsSurname(sSurname);
        setoSpecialization(oSpecialization);
        setoResearchTeam(oResearchTeam);
    }

    public Member(String sDNI, String sName, String sSurname, Specialization oSpecialization, ResearchTeam oResearchTeam) {
        setsDNI(sDNI);
        setsName(sName);
        setsSurname(sSurname);
        setoSpecialization(oSpecialization);
        setoResearchTeam(oResearchTeam);
    }

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

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public boolean setBirthDate(GregorianCalendar birthDate) {
        boolean bExito = false;
        if (birthDate.get(Calendar.YEAR) > 1900 && birthDate.get(Calendar.YEAR) < 2020) {
            this.birthDate = birthDate;
            bExito = true;
        }
        return bExito;
    }

    public String getsName() {
        return sName;
    }

    public boolean setsName(String sName) {
        boolean bExito = false;
        if (sName != null && sName.length() < MAXCHAR_50 && sName.length() > MINCHAR) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    public String getsSurname() {
        return sSurname;
    }

    public boolean setsSurname(String sSurname) {
        boolean bExito = false;
        if (sSurname != null && sSurname.length() > MINCHAR && sSurname.length() < MAXCHAR_50) {
            this.sSurname = sSurname;
            bExito = true;
        }
        return bExito;
    }

    public Specialization getoSpecialization() {
        return oSpecialization;
    }

    public boolean setoSpecialization(Specialization oSpecialization) {
        boolean bExito = false;
        if (oSpecialization.checkSpecialization()) {
            this.oSpecialization = oSpecialization;
            bExito = true;
        }
        return bExito;
    }

    public ResearchTeam getoResearchTeam() {
        return oResearchTeam;
    }

    public boolean setoResearchTeam(ResearchTeam oResearchTeam) {
        boolean bExito = false;
        if (oResearchTeam.checkResearchTeam()) {
            this.oResearchTeam = oResearchTeam;
            bExito = true;
        }
        return bExito;
    }
}
