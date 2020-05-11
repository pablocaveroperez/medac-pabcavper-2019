package model;

import java.util.Objects;

public class ArticleRatingUser implements LimitsDB, IArticleRatingUser {
    private User oUser;
    private Article oArticle;
    private String sComment;
    private byte bRating;

    public ArticleRatingUser(User oUser, Article oArticle, String sComment, byte bRating) {
        setoUser(oUser);
        setoArticle(oArticle);
        setsComment(sComment);
        setbRating(bRating);
    }

    public ArticleRatingUser(User oUser, Article oArticle, byte bRating) {
        setoUser(oUser);
        setoArticle(oArticle);
        setbRating(bRating);
    }

    @Override
    public User getoUser() {
        return oUser;
    }

    @Override
    public boolean setoUser(User oUser) {
        boolean bExito = false;
        if (oUser != null && oUser.checkUser()) {
            this.oUser = oUser;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public Article getoArticle() {
        return oArticle;
    }

    @Override
    public boolean setoArticle(Article oArticle) {
        boolean bExito = false;
        if (oArticle != null && oArticle.checkArticle()) {
            this.oArticle = oArticle;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public String getsComment() {
        return sComment;
    }

    @Override
    public boolean setsComment(String sComment) {
        boolean bExito = false;
        if (sComment.length() > MINCHAR && sComment.length() < MAXCHAR_255) {
            this.sComment = sComment;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public byte getbRating() {
        return bRating;
    }

    @Override
    public boolean setbRating(byte bRating) {
        boolean bExito = false;
        if (bRating > MINCHAR && bRating < MAXRATING) {
            this.bRating = bRating;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkArticleRatingUser() {
        boolean bExito = false;
        if (getoUser() != null && getoUser().checkUser() && getoArticle() != null && getoArticle().checkArticle() && getbRating() > MINCHAR && getbRating() < MAXRATING)
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleRatingUser that = (ArticleRatingUser) o;
        return getoUser().equals(that.getoUser()) &&
                getoArticle().equals(that.getoArticle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getoUser(), getoArticle());
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "**********************";
        salida += "\nUsuario: " + getoUser().getsUsername();
        salida += "\nArticulo: " + getoArticle().getIdArticle();
        if (getsComment() != null)
            salida += "\nComentario: " + getsComment();
        salida += "\nPuntuacion sobre diez: " + getbRating();
        salida += "\n**********************";
        return salida;
    }
}
