package model;

public class ArticleRatingUser implements LimitsDB {
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

    public User getoUser() {
        return oUser;
    }

    public boolean setoUser(User oUser) {
        boolean bExito = false;
        if (oUser != null && oUser.checkUser()) {
            this.oUser = oUser;
            bExito = true;
        }
        return bExito;
    }

    public Article getoArticle() {
        return oArticle;
    }

    public boolean setoArticle(Article oArticle) {
        boolean bExito = false;
        if (oArticle != null && oArticle.checkArticle()) {
            this.oArticle = oArticle;
            bExito = true;
        }
        return bExito;
    }

    public String getsComment() {
        return sComment;
    }

    public boolean setsComment(String sComment) {
        boolean bExito = false;
        if (sComment != null && sComment.length() > MINCHAR && sComment.length() < MAXCHAR_255) {
            this.sComment = sComment;
            bExito = true;
        }
        return bExito;
    }

    public byte getbRating() {
        return bRating;
    }

    public boolean setbRating(byte bRating) {
        boolean bExito = false;
        if (bRating > MINCHAR && bRating < MAXRATING) {
            this.bRating = bRating;
            bExito = true;
        }
        return bExito;
    }
}
