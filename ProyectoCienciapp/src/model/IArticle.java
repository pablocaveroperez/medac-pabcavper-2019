package model;

public interface IArticle {
    byte getIdArticle();

    short getShPages();

    boolean setShPages(short shPages);

    String getsName();

    boolean setsName(String sName);

    Magazine getoMagazine();

    boolean setoMagazine(Magazine oMagazine);

    Member getoMember();

    boolean setoMember(Member oMember);

    ArticleType getoArticleType();

    boolean setoArticleType(ArticleType oArticleType);

    boolean checkArticle();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
