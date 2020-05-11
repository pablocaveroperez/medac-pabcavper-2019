package model;

public interface IArticleXCategory {
    Article getoArticle();

    boolean setoArticle(Article oArticle);

    Category getoCategory();

    boolean setoCategory(Category oCategory);

    boolean checkArticleXCategory();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
