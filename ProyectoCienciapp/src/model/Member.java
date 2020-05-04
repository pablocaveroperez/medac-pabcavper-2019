package model;

import java.util.Date;
import java.util.GregorianCalendar;

public class Member implements LimitsDB {
    private String sDNI; // Primary Key
    private GregorianCalendar birthDate = new GregorianCalendar(); // NULO
    private String sName; // NN
    private String sSurname; // NN
    private Specialization oSpecialization; // NN
    private ResearchTeam oResearchTeam; // NN

    public Member(String sDNI, Date birthDate, String sName, String sSurname, Specialization oSpecialization, ResearchTeam oResearchTeam) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean setBirthDate(Date birthDate) {
        boolean bExito = false;
        if (birthDate.getYear() > 1900 && birthDate.getYear() < 2020) {
            this.birthDate = birthDate;
            bExito = true;
        }
        return bExito;
    }

    public String getsName() {
        return sName;
    }

    public boolean setsName(String sName) {
        this.sName = sName;
    }

    public String getsSurname() {
        return sSurname;
    }

    public boolean setsSurname(String sSurname) {
        this.sSurname = sSurname;
    }

    public Specialization getoSpecialization() {
        return oSpecialization;
    }

    public boolean setoSpecialization(Specialization oSpecialization) {
        this.oSpecialization = oSpecialization;
    }

    public ResearchTeam getoResearchTeam() {
        return oResearchTeam;
    }

    public boolean setoResearchTeam(ResearchTeam oResearchTeam) {
        this.oResearchTeam = oResearchTeam;
    }
}
