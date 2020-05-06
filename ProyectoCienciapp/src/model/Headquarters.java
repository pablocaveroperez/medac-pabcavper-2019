package model;

public class Headquarters implements LimitsDB {
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

    public String getsLocality() {
        return sLocality;
    }

    public boolean setsLocality(String sLocality) {
        boolean bExito = false;
        if (sLocality != null && sLocality.length() > MINCHAR && sLocality.length() < MAXCHAR_70) {
            this.sLocality = sLocality;
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
}
