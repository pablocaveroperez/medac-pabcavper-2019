package model;

import java.util.Objects;

public class ArticleType implements IArticleType, LimitsDB {
    private String sTypeName;
    private String sDescription;

    public ArticleType(String sTypeName, String sDescription) {
        setsTypeName(sTypeName);
        setsDescription(sDescription);
    }

    public ArticleType(String sTypeName) {
        setsTypeName(sTypeName);
    }

    @Override
    public String getsDescription() {
        return sDescription;
    }

    @Override
    public String getsTypeName() {
        return sTypeName;
    }

    @Override
    public boolean setsDescription(String sDescription) {
        boolean bExito = false;
        if (sDescription.length() < MAXCHAR_DESCTYPE && sDescription.length() > 0){
            this.sDescription = sDescription;
            bExito = true;
        }
        return bExito;
    }

    private boolean setsTypeName(String sTypeName) {
        boolean bExito = false;
        if (sTypeName.length() < MAXCHAR_NAME && sTypeName.length() > 0){
            this.sTypeName = sTypeName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkArticleType() {
        boolean bExito = false;
        if (getsTypeName().length() < MAXCHAR_NAME && getsDescription().length() < MAXCHAR_DESCTYPE && getsTypeName() != null) {
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleType that = (ArticleType) o;
        return getsTypeName().equals(that.getsTypeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsTypeName());
    }

    @Override
    public String toString() {
        String salida = "";
        if (checkArticleType()) {
            salida += "**********************";
            salida += "\nTipo de Articulo: " + sTypeName;
            salida += "\nDescripcion: " + sDescription;
            salida += "\n**********************";
        }
        return salida;
    }
}
