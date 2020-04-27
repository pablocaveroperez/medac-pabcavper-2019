package model;

import java.util.Objects;

public class Specialization implements ISpecialization {
    private String sName;
    private String sDescription;

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
        if (sDescription.length() < 200) {
            this.sDescription = sDescription;
            bExito = true;
        }
        return bExito;
    }

    private boolean setsName(String sName) {
        boolean bExito = false;
        if (sName.length() < 50){
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkSpecialization() {
        boolean bExito = false;
        if (getsName().length() < 50 && getsDescription().length() < 200 && getsName() != null){
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
            salida += "\nDescripcion: " + sDescription;
            salida += "\n*******************";
        }
        return salida;
    }
}
