package model;

import java.util.Objects;

public class Category implements ICategory, LimitsDB {
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
        if (sDescription.length() < MAXCHAR_DESC && sDescription != null && sDescription.length() > 0){
            this.sDescription = sDescription;
            bExito = true;
        }
        return bExito;
    }

    private boolean setsCategoryName(String sCategoryName) {
        boolean bExito = false;
        if (sCategoryName.length() < MAXCHAR_CATEGORY && sCategoryName != null && sCategoryName.length() > 0){
            this.sCategoryName = sCategoryName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkCategory() {
        boolean bExito = false;
        if (getsCategoryName().length() < MAXCHAR_CATEGORY && getsDescription().length() < MAXCHAR_DESC && getsCategoryName() != null){
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return getsCategoryName().equals(category.getsCategoryName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsCategoryName());
    }

    @Override
    public String toString() {
        String salida = "";
        if (checkCategory()) {
            salida += "********************";
            salida += "\nCategoria: " + sCategoryName;
            salida += "\nDescripcion: " + sDescription;
            salida += "\n********************";
        }
        return salida;
    }
}
