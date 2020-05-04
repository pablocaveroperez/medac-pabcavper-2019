package model;

import java.util.Objects;

public class University implements LimitsDB {
    private String sUniName;
    private String sLocality;
    private String sAddres;
    private Country oCountry;

    public University(String sUniName, String sLocality, String sAddres, Country oCountry) {
        setsUniName(sUniName);
        setsLocality(sLocality);
        setsAddres(sAddres);
        setoCountry(oCountry);
    }

    public University(String sUniName, String sLocality, Country oCountry) {
        setsUniName(sUniName);
        setsLocality(sLocality);
        setoCountry(oCountry);
    }

    public String getsUniName() {
        return sUniName;
    }

    private boolean setsUniName(String sUniName) {
        boolean bExito = false;
        if (sUniName != null && sUniName.length() < MAXCHAR_65 && sUniName.length() > MINCHAR ) {
            this.sUniName = sUniName;
            bExito = true;
        }
        return bExito;
    }

    public String getsLocality() {
        return sLocality;
    }

    public boolean setsLocality(String sLocality) {
        boolean bExito = false;
        if (sLocality != null && sLocality.length() < MAXCHAR_70 && sLocality.length() > MINCHAR) {
            this.sLocality = sLocality;
            bExito = true;
        }
        return bExito;
    }

    public String getsAddres() {
        return sAddres;
    }

    public boolean setsAddres(String sAddres) {
        boolean bExito = false;
        if (sAddres.length() > MINCHAR && sAddres.length() < MAXCHAR_100) {
            this.sAddres = sAddres;
            bExito = true;
        }
        return bExito;
    }

    public Country getoCountry() {
        return oCountry;
    }

    public boolean setoCountry(Country oCountry) {
        boolean bExito = false;
        if (oCountry.checkCountry()) {
            this.oCountry = oCountry;
            bExito = true;
        }
        return bExito;
    }

    public boolean chechUniversity() {
        boolean bExito = false;
        if (getsUniName() != null && getsLocality() != null && getoCountry() != null)
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return getsUniName().equals(that.getsUniName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsUniName());
    }

    public String toString() {
        String salida = "";
        salida += "*******************";
        salida += "\nUniversidad: " + getsUniName();
        salida += "\nLocalidad: " + getsLocality();
        salida += "\nPais: " + getoCountry().getsName();
        if (getsAddres() != null)
            salida += "\nDireccion: " + getsAddres();
        salida += "*******************";
        return salida;
    }
}