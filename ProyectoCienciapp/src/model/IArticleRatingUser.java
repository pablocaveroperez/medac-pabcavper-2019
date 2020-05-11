package model;

public interface IArticleRatingUser {
    User getoUser();

    boolean setoUser(User oUser);

    Article getoArticle();

    boolean setoArticle(Article oArticle);

    String getsComment();

    boolean setsComment(String sComment);

    byte getbRating();

    boolean setbRating(byte bRating);

    boolean checkArticleRatingUser();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
