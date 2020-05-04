package model;

public class Faculty implements LimitsDB {
    private String sFaculName;
    private University oUniversity;

    public Faculty(String sFaculName, University oUniversity) {
        setoUniversity(oUniversity);
        setsFaculName(sFaculName);
    }

    public String getsFaculName() {
        return sFaculName;
    }

    private boolean setsFaculName(String sFaculName) {
        boolean bExito = false;
        if (sFaculName != null && sFaculName.length() < MAXCHAR_50 && sFaculName.length() > MINCHAR) {
            this.sFaculName = sFaculName;
            bExito = true;
        }
        return bExito;
    }

    public University getoUniversity() {
        return oUniversity;
    }

    public boolean setoUniversity(University oUniversity) {
        boolean bExito = false;
        if (oUniversity.chechUniversity()) {
            this.oUniversity = oUniversity;
            bExito = true;
        }
        return bExito;
    }
}
