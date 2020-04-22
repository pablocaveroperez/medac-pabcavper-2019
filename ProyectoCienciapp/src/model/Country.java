package model;

public class Country {
    private String sName;

    public Country (String sName) {
        setsName(sName);
    }

    public String getsName() {
        return sName;
    }

    private boolean setsName(String sName) {
        boolean bExito = false;
        if (sName.length() < 70) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    public boolean checkCountry(){
        boolean bExito = false;
        if (sName.length() < 70){
            bExito = true;
        }
        return bExito;
    }
}
