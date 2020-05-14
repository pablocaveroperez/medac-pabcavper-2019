package model.SistemaInvestigacion;

import model.LimitsDB;

import java.util.Objects;

public class ResearchTeam implements LimitsDB, IResearchTeam {
    private byte idResearchTeam;        // PRIMARY KEY
    private Department oDepartment;     // NN
    private String sName;               // NULL
    private int iBudget;                // NN

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

    public ResearchTeam(byte idResearchTeam) {
        setIdResearchTeam(idResearchTeam);
    }

    @Override
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

    @Override
    public Department getoDepartment() {
        return oDepartment;
    }

    @Override
    public boolean setoDepartment(Department oDepartment) {
        boolean bExito = false;
        if (oDepartment.checkDepartment()) {
            this.oDepartment = oDepartment;
            bExito = true;
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
        if (sName == null || (sName.length() > MINCHAR && sName.length() < MAXCHAR_40)) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int getiBudget() {
        return iBudget;
    }

    @Override
    public boolean setiBudget(int iBudget) {
        boolean bExito = false;
        if (iBudget > MINCHAR && iBudget < MAXBUDGET) {
            this.iBudget = iBudget;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkResearchTeam() {
        boolean bExito = false;
        if (getoDepartment() != null && (getiBudget() > MINCHAR && getiBudget() < MAXBUDGET) && (getIdResearchTeam() < MAXCHAR_30 && getIdResearchTeam() > MINCHAR))
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchTeam that = (ResearchTeam) o;
        return getIdResearchTeam() == that.getIdResearchTeam();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdResearchTeam());
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "*******************";
        salida += "\nID Equipo de Investigacion: " + getIdResearchTeam();
        if (getsName() != null)
            salida += "\nNombre: " + getsName();
        salida += "\nPresupuesto: " + getiBudget();
        salida += "\nDepartamento: " + getoDepartment().getIdDepartment();
        salida += "\n*******************";
        return salida;
    }
}
