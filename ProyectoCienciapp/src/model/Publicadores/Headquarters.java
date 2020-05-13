package model.Publicadores;

import model.Ctrl.Country;
import model.LimitsDB;

import java.util.Objects;

public class Headquarters implements LimitsDB, IHeadquarters {
    private String sName;       // PRIMARY KEY
    private String sAddres;     // NULL
    private String sLocality;   // NN
    private Country oCountry;   // NN

    public Headquarters(String sName, String sLocality, Country oCountry) {
        setsName(sName);
        setsLocality(sLocality);
        setoCountry(oCountry);
    }

    public Headquarters(String sName, String sAddres, String sLocality, Country oCountry) {
        setsName(sName);
        setsAddres(sAddres);
        setsLocality(sLocality);
        setoCountry(oCountry);
    }

    @Override
    public String getsName() {
        return sName;
    }

    private boolean setsName(String sName) {
        boolean bExito = false;
        if (sName != null && sName.length() > MINCHAR && sName.length() < MAXCHAR_40) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public String getsAddres() {
        return sAddres;
    }

    @Override
    public boolean setsAddres(String sAddres) {
        boolean bExito = false;
        if (sAddres.length() > MINCHAR && sAddres.length() < MAXCHAR_100) {
            this.sAddres = sAddres;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public String getsLocality() {
        return sLocality;
    }

    @Override
    public boolean setsLocality(String sLocality) {
        boolean bExito = false;
        if (sLocality != null && sLocality.length() > MINCHAR && sLocality.length() < MAXCHAR_70) {
            this.sLocality = sLocality;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public Country getoCountry() {
        return oCountry;
    }

    @Override
    public boolean setoCountry(Country oCountry) {
        boolean bExito = false;
        if (oCountry.checkCountry()) {
            this.oCountry = oCountry;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkHeadquarters() {
        boolean bExito = false;
        if (getsName() != null && getoCountry().checkCountry() && getsLocality() != null)
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Headquarters that = (Headquarters) o;
        return getsName().equals(that.getsName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsName());
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "**********************";
        salida += "\nOficina Central: " + getsName();
        if (getsAddres() != null)
            salida += "\nDireccion: " + getsAddres();
        salida += "\nLocalidad: " + getsLocality();
        salida += "\nPais: " + getoCountry().getsName();
        salida += "\n**********************";
        return salida;
    }
}
