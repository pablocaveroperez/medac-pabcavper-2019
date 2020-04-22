package model;

public class Category implements ICategory {
    private String sCategoryName;
    private String sDescription;

    public Category(String sCategoryName, String sDescription) {
        setsCategoryName(sCategoryName);
        setsDescription(sDescription);
    }

    public Category(String sCategoryName) {
        setsCategoryName(sCategoryName);
    }

    @Override
    public String getsDescription() {
        return sDescription;
    }

    @Override
    public String getsCategoryName() {
        return sCategoryName;
    }

    @Override
    public boolean setsDescription(String sDescription) {
        boolean bExito = false;
        if (sDescription.length() < 200 && sDescription != null && sDescription.length() > 0){
            this.sDescription = sDescription;
            bExito = true;
        }
        return bExito;
    }

    private boolean setsCategoryName(String sCategoryName) {
        boolean bExito = false;
        if (sCategoryName.length() < 60 && sCategoryName != null && sCategoryName.length() > 0){
            this.sCategoryName = sCategoryName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkCategory() {
        boolean bExito = false;
        if (getsCategoryName().length() < 60 && getsDescription().length() < 200){
            bExito = true;
        }
        return bExito;
    }
}
