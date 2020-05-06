package model;

public class Magazine implements LimitsDB {
    private String sName;
    private Headquarters oHeadquarters;

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
}
