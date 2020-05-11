package model.ArticulosUsuarios;

public interface ICategory {
    String getsDescription();

    String getsCategoryName();

    boolean setsDescription(String sDescription);

    boolean checkCategory();

    public boolean equals(Object o);

    public int hashCode();

    public String toString();
}
