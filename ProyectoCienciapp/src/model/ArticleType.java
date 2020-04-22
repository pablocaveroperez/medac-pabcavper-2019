package model;

public class ArticleType implements IArticleType {
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
        if (sDescription.length() < 250){
            this.sDescription = sDescription;
            bExito = true;
        }
        return bExito;
    }

    private boolean setsTypeName(String sTypeName) {
        boolean bExito = false;
        if (sTypeName.length() < 50){
            this.sTypeName = sTypeName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkArticleType() {
        boolean bExito = false;
        if (getsTypeName().length() < 50 && getsDescription().length() < 250) {
            bExito = true;
        }
        return bExito;
    }

}
