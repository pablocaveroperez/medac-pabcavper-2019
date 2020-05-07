package model;

public class Article implements LimitsDB {
    private byte idArticle;                 // PRIMARY KEY
    private short shPages;                  // NULL
    private String sName;                   // NN
    private Magazine oMagazine;             // NN
    private Member oMember;                 // NN
    private ArticleType oArticleType;       // NN

    public Article(byte idArticle, String sName, Magazine oMagazine, Member oMember, ArticleType oArticleType) {
        setIdArticle(idArticle);
        setsName(sName);
        setoMagazine(oMagazine);
        setoMember(oMember);
        setoArticleType(oArticleType);
    }

    public Article(byte idArticle, short shPages, String sName, Magazine oMagazine, Member oMember, ArticleType oArticleType) {
        setIdArticle(idArticle);
        setShPages(shPages);
        setsName(sName);
        setoMagazine(oMagazine);
        setoMember(oMember);
        setoArticleType(oArticleType);
    }

    public byte getIdArticle() {
        return idArticle;
    }

    private boolean setIdArticle(byte idArticle) {
        boolean bExito = false;
        if (idArticle > MINCHAR && idArticle < MAXCHAR_100) {
            this.idArticle = idArticle;
            bExito = true;
        }
        return bExito;
    }

    public short getShPages() {
        return shPages;
    }

    public boolean setShPages(short shPages) {
        boolean bExito = false;
        if (shPages > MINCHAR && shPages < MAXCHAR_1000) {
            this.shPages = shPages;
            bExito = true;
        }
        return bExito;
    }

    public String getsName() {
        return sName;
    }

    public boolean setsName(String sName) {
        boolean bExito = false;
        if (sName != null && sName.length() > MINCHAR && sName.length() < MAXCHAR_55) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    public Magazine getoMagazine() {
        return oMagazine;
    }

    public boolean setoMagazine(Magazine oMagazine) {
        boolean bExito = false;
        if (oMagazine != null && oMagazine.checkMagazine()) {
            this.oMagazine = oMagazine;
            bExito = true;
        }
        return bExito;
    }

    public Member getoMember() {
        return oMember;
    }

    public boolean setoMember(Member oMember) {
        boolean bExito = false;
        if (oMember != null && oMember.checkMember()) {
            this.oMember = oMember;
            bExito = true;
        }
        return bExito;
    }

    public ArticleType getoArticleType() {
        return oArticleType;
    }

    public boolean setoArticleType(ArticleType oArticleType) {
        boolean bExito = false;
        if (oArticleType != null && oArticleType.checkArticleType()) {
            this.oArticleType = oArticleType;
            bExito = true;
        }
        return bExito;
    }

    public boolean checkArticle() {
        boolean bExito = false;
        if ((getIdArticle() > MINCHAR && getIdArticle() < MAXCHAR_100) && getsName() != null && getoMagazine() != null && getoMagazine().checkMagazine()
            && getoMember() != null && getoMember().checkMember() && getoArticleType() != null && getoArticleType().checkArticleType())
            bExito = true;
        return bExito;
    }
}
