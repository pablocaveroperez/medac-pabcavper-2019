package model;

public class University {
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
        this.sUniName = sUniName;
    }

    public String getsLocality() {
        return sLocality;
    }

    public boolean setsLocality(String sLocality) {
        this.sLocality = sLocality;
    }

    public String getsAddres() {
        return sAddres;
    }

    public boolean setsAddres(String sAddres) {
        this.sAddres = sAddres;
    }

    public Country getoCountry() {
        return oCountry;
    }

    public boolean setoCountry(Country oCountry) {
        this.oCountry = oCountry;
    }
}
