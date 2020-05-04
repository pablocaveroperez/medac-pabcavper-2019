package model;

public interface IUniversity {
    String getsUniName();

    String getsLocality();

    boolean setsLocality(String sLocality);

    String getsAddres();

    boolean setsAddres(String sAddres);

    Country getoCountry();

    boolean setoCountry(Country oCountry);

    boolean chechUniversity();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
