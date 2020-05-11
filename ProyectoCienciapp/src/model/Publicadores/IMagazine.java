package model.Publicadores;

public interface IMagazine {
    String getsName();

    Headquarters getoHeadquarters();

    boolean setoHeadquarters(Headquarters oHeadquarters);

    boolean checkMagazine();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
