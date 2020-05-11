package model.SistemaInvestigacion;

import model.LimitsDB;

import java.util.Objects;

public class Faculty implements LimitsDB, IFaculty {
    private String sFaculName;          // PRIMARY KEY
    private University oUniversity;     // NN

    public Faculty(String sFaculName, University oUniversity) {
        setoUniversity(oUniversity);
        setsFaculName(sFaculName);
    }

    @Override
    public String getsFaculName() {
        return sFaculName;
    }

    private boolean setsFaculName(String sFaculName) {
        boolean bExito = false;
        if (sFaculName != null && sFaculName.length() < MAXCHAR_50 && sFaculName.length() > MINCHAR) {
            this.sFaculName = sFaculName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public University getoUniversity() {
        return oUniversity;
    }

    @Override
    public boolean setoUniversity(University oUniversity) {
        boolean bExito = false;
        if (oUniversity.checkUniversity()) {
            this.oUniversity = oUniversity;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkFaculty() {
        boolean bExito = false;
        if (sFaculName != null && oUniversity.checkUniversity())
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return getsFaculName().equals(faculty.getsFaculName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsFaculName());
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "*******************";
        salida += "\nFacultad: " + getsFaculName();
        salida += "\nUniversidad: " + getoUniversity().getsUniName();
        salida += "*******************";
        return salida;
    }
}
