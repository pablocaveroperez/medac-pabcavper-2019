package model.ArticulosUsuarios;

import model.LimitsDB;

import java.util.Objects;

public class Category implements ICategory, LimitsDB {
    private String sCategoryName;   // PRIMARY KEY
    private String sDescription;    // NULL

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
        if (sDescription.length() < MAXCHAR_200 && sDescription.length() > MINCHAR){
            this.sDescription = sDescription;
            bExito = true;
        }
        return bExito;
    }

    private boolean setsCategoryName(String sCategoryName) {
        boolean bExito = false;
        if (sCategoryName != null && sCategoryName.length() < MAXCHAR_60 && sCategoryName.length() > MINCHAR){
            this.sCategoryName = sCategoryName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkCategory() {
        boolean bExito = false;
        if (getsCategoryName() != null){
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
            if (sDescription != null)
                salida += "\nDescripcion: " + sDescription;
            salida += "\n********************";
        }
        return salida;
    }
}
