package model;

import java.util.Objects;

public class Magazine implements LimitsDB {
    private String sName;                   //PRIMARY KEY
    private Headquarters oHeadquarters;     // NN

    public String getsName() {
        return sName;
    }

    private boolean setsName(String sName) {
        boolean bExito = false;
        if (sName != null && sName.length() < MAXCHAR_100 && sName.length() > MINCHAR) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    public Headquarters getoHeadquarters() {
        return oHeadquarters;
    }

    public boolean setoHeadquarters(Headquarters oHeadquarters) {
        boolean bExito = false;
        if (oHeadquarters.checkHeadquarters()) {
            this.oHeadquarters = oHeadquarters;
            bExito = true;
        }
        return bExito;
    }

    public boolean checkMagazine() {
        boolean bExito = false;
        if (getsName() != null && getoHeadquarters() != null && getoHeadquarters().checkHeadquarters())
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return getsName().equals(magazine.getsName()) &&
                getoHeadquarters().equals(magazine.getoHeadquarters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsName(), getoHeadquarters());
    }

    public String toString() {
        String salida = "";
        salida += "**********************";
        salida += "\nNombre: " + getsName();
        salida += "\nOficina Central: " + getoHeadquarters().getsName();
        salida += "\n**********************";
        return salida;
    }
}
