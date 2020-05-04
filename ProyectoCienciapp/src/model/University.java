package model;

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
}
