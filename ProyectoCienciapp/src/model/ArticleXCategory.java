package model;

import java.util.Objects;

public class ArticleXCategory {
    private Article oArticle;       // PRIMARY KEY Y FOREIGN KEY
    private Category oCategory;     // PRIMARY KEY Y FOREIGN KEY

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

    public Category getoCategory() {
        return oCategory;
    }

    public boolean setoCategory(Category oCategory) {
        boolean bExito = false;
        if (oCategory != null && oCategory.checkCategory()) {
            this.oCategory = oCategory;
            bExito = true;
        }
        return bExito;
    }

    public boolean checkArticleXCategory() {
        boolean bExito = false;
        if (getoArticle() != null && getoArticle().checkArticle() && getoCategory() != null && getoCategory().checkCategory())
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleXCategory that = (ArticleXCategory) o;
        return getoArticle().equals(that.getoArticle()) &&
                getoCategory().equals(that.getoCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getoArticle(), getoCategory());
    }
}
