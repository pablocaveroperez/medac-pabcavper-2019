package model;

import java.util.Objects;

public class Specialization implements ISpecialization, LimitsDB{
    private String sName;           // PRIMARY KEY
    private String sDescription;    // NULL

    public Specialization(String sName, String sDescription) {
        setsName(sName);
        setsDescription(sDescription);
    }

    public Specialization(String sName) {
        setsName(sName);
    }

    @Override
    public String getsName() {
        return sName;
    }

    @Override
    public String getsDescription() {
        return sDescription;
    }

    @Override
    public boolean setsDescription(String sDescription) {
        boolean bExito = false;
        if (sDescription.length() < MAXCHAR_200 && sDescription.length() > MINCHAR) {
            this.sDescription = sDescription;
            bExito = true;
        }
        return bExito;
    }

    private boolean setsName(String sName) {
        boolean bExito = false;
        if (sName != null && sName.length() < MAXCHAR_50 && sName.length() > MINCHAR){
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkSpecialization() {
        boolean bExito = false;
        if (getsName() != null){
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return getsName().equals(that.getsName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsName());
    }

    @Override
    public String toString() {
        String salida = "";
        if (checkSpecialization()) {
            salida += "*******************";
            salida += "\nEspecializacion: " + sName;
            if (getsDescription() != null)
                salida += "\nDescripcion: " + sDescription;
            salida += "\n*******************";
        }
        return salida;
    }
}
