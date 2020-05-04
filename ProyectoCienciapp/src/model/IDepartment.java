package model;

public interface IDepartment {
    byte getIdDepartment();

    Faculty getoFaculty();

    boolean setoFaculty(Faculty oFaculty);

    String getsName();

    boolean setsName(String sName);

    boolean checkDepartment();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
