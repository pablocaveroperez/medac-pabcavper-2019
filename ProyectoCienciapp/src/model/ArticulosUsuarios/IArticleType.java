package model.ArticulosUsuarios;

public interface IArticleType {
    String getsDescription();

    String getsTypeName();

    boolean setsDescription(String sDescription);

    boolean checkArticleType();

    public boolean equals(Object o);

    public int hashCode();

    public String toString();

}
