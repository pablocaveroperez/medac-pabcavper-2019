package model;

public class ResearchTeam implements LimitsDB {
    private byte idResearchTeam;
    private Department oDepartment;
    private String sName;
    private int iBudget;

    public ResearchTeam(byte idResearchTeam, Department oDepartment, String sName, int iBudget) {
        setiBudget(iBudget);
        setIdResearchTeam(idResearchTeam);
        setoDepartment(oDepartment);
        setsName(sName);
    }

    public ResearchTeam(byte idResearchTeam, Department oDepartment, int iBudget) {
        setiBudget(iBudget);
        setIdResearchTeam(idResearchTeam);
        setoDepartment(oDepartment);
    }

    public byte getIdResearchTeam() {
        return idResearchTeam;
    }

    private boolean setIdResearchTeam(byte idResearchTeam) {
        boolean bExito = false;
        if (idResearchTeam < MAXCHAR_30 && idResearchTeam > MINCHAR) {
            this.idResearchTeam = idResearchTeam;
            bExito = true;
        }
        return bExito;
    }

    public Department getoDepartment() {
        return oDepartment;
    }

    public boolean setoDepartment(Department oDepartment) {
        boolean bExito = false;
        if (oDepartment.checkDepartment()) {
            this.oDepartment = oDepartment;
            bExito = true;
        }
        return bExito;
    }

    public String getsName() {
        return sName;
    }

    public boolean setsName(String sName) {
        boolean bExito = false;
        if (sName.length() > MINCHAR && sName.length() < MAXCHAR_40) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    public int getiBudget() {
        return iBudget;
    }

    public boolean setiBudget(int iBudget) {
        boolean bExito = false;
        if (iBudget > MINCHAR && iBudget < MAXBUDGET) {
            this.iBudget = iBudget;
            bExito = true;
        }
        return bExito;
    }

    public boolean checkResearchTeam() {
        boolean bExito = false;
        if (getoDepartment() != null && (getiBudget() > MINCHAR && getiBudget() < MAXBUDGET) && (getIdResearchTeam() < MAXCHAR_30 && getIdResearchTeam() > MINCHAR))
            bExito = true;
        return bExito;
    }
}
