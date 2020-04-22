package model;

public class Country implements ICountry {
    private String sName;

    public Country (String sName) {
        setsName(sName);
    }

    @Override
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

    @Override
    public boolean checkCountry(){
        boolean bExito = false;
        if (getsName().length() < 70){
            bExito = true;
        }
        return bExito;
    }
}
