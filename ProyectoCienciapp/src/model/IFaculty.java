package model;

public interface IFaculty {
    String getsFaculName();

    University getoUniversity();

    boolean setoUniversity(University oUniversity);

    boolean checkFaculty();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
