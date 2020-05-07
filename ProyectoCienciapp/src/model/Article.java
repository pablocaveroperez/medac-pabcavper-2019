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
        this.idArticle = idArticle;
    }

    public short getShPages() {
        return shPages;
    }

    public boolean setShPages(short shPages) {
        this.shPages = shPages;
    }

    public String getsName() {
        return sName;
    }

    public boolean setsName(String sName) {
        this.sName = sName;
    }

    public Magazine getoMagazine() {
        return oMagazine;
    }

    public boolean setoMagazine(Magazine oMagazine) {
        this.oMagazine = oMagazine;
    }

    public Member getoMember() {
        return oMember;
    }

    public boolean setoMember(Member oMember) {
        this.oMember = oMember;
    }

    public ArticleType getoArticleType() {
        return oArticleType;
    }

    public boolean setoArticleType(ArticleType oArticleType) {
        this.oArticleType = oArticleType;
    }
}
