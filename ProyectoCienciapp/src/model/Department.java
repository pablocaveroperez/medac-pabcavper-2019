package model;

import java.util.Objects;

public class Department implements LimitsDB, IDepartment {
    private byte idDepartment;
    private Faculty oFaculty;
    private String sName;

    public Department(byte idDepartment, Faculty oFaculty, String sName) {
        setIdDepartment(idDepartment);
        setoFaculty(oFaculty);
        setsName(sName);
    }

    public Department(byte idDepartment, Faculty oFaculty) {
        setIdDepartment(idDepartment);
        setoFaculty(oFaculty);
    }

    @Override
    public byte getIdDepartment() {
        return idDepartment;
    }

    private boolean setIdDepartment(byte idDepartment) {
        boolean bExito = false;
        if (idDepartment > MINCHAR && idDepartment < MAXCHAR_30) {
            this.idDepartment = idDepartment;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public Faculty getoFaculty() {
        return oFaculty;
    }

    @Override
    public boolean setoFaculty(Faculty oFaculty) {
        boolean bExito = false;
        if (oFaculty.checkFaculty()) {
            this.oFaculty = oFaculty;
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
        if (sName.length() > MINCHAR && sName.length() < MAXCHAR_50) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkDepartment() {
        boolean bExito = false;
        if (getoFaculty().checkFaculty() && getIdDepartment() > MINCHAR && getIdDepartment() < MAXCHAR_30)
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return getIdDepartment() == that.getIdDepartment();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDepartment());
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "*******************";
        salida += "\nID Departamento: " + getIdDepartment();
        if (getsName() != null)
            salida += "\nNombre: " + getsName();
        salida += "\nFacultad: " + getoFaculty().getsFaculName();
        salida += "*******************";
        return salida;
    }
}
