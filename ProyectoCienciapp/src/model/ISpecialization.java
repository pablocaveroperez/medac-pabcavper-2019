package model;

public interface ISpecialization {
    String getsName();

    String getsDescription();

    boolean setsDescription(String sDescription);

    boolean checkSpecialization();

    public boolean equals(Object o);

    public int hashCode();

    public String toString();
}
