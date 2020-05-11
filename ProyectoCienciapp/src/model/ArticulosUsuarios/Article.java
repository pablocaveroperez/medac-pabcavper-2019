package model.ArticulosUsuarios;

import model.LimitsDB;
import model.Publicadores.Magazine;
import model.SistemaInvestigacion.Member;

import java.util.Objects;

public class Article implements LimitsDB, IArticle {
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

    @Override
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

    @Override
    public short getShPages() {
        return shPages;
    }

    @Override
    public boolean setShPages(short shPages) {
        boolean bExito = false;
        if (shPages > MINCHAR && shPages < MAXCHAR_1000) {
            this.shPages = shPages;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public String getsName() {
        return sName;
    }

    @Override
    public boolean setsName(String sName) {
        boolean bExito = false;
        if (sName != null && sName.length() > MINCHAR && sName.length() < MAXCHAR_55) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public Magazine getoMagazine() {
        return oMagazine;
    }

    @Override
    public boolean setoMagazine(Magazine oMagazine) {
        boolean bExito = false;
        if (oMagazine != null && oMagazine.checkMagazine()) {
            this.oMagazine = oMagazine;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public Member getoMember() {
        return oMember;
    }

    @Override
    public boolean setoMember(Member oMember) {
        boolean bExito = false;
        if (oMember != null && oMember.checkMember()) {
            this.oMember = oMember;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public ArticleType getoArticleType() {
        return oArticleType;
    }

    @Override
    public boolean setoArticleType(ArticleType oArticleType) {
        boolean bExito = false;
        if (oArticleType != null && oArticleType.checkArticleType()) {
            this.oArticleType = oArticleType;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkArticle() {
        boolean bExito = false;
        if ((getIdArticle() > MINCHAR && getIdArticle() < MAXCHAR_100) && getsName() != null && getoMagazine() != null && getoMagazine().checkMagazine()
            && getoMember() != null && getoMember().checkMember() && getoArticleType() != null && getoArticleType().checkArticleType())
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return getIdArticle() == article.getIdArticle();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdArticle());
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "**********************";
        salida += "\nID Articulo: " + getIdArticle();
        salida += "\nNombre: " + getsName();
        if (shPages > MINCHAR && shPages < MAXCHAR_1000)
            salida += "\nPaginas: " + getShPages();
        salida += "\nRevista: " + getoMagazine().getsName();
        salida += "\nMiembro: " + getoMember().getsDNI();
        salida += "\nTipo Articulo: " + getoArticleType().getsTypeName();
        salida += "\n**********************";
        return salida;
    }
}
