package model.Publicadores;

import model.Country;

public interface IHeadquarters {
    String getsName();

    String getsAddres();

    boolean setsAddres(String sAddres);

    String getsLocality();

    boolean setsLocality(String sLocality);

    Country getoCountry();

    boolean setoCountry(Country oCountry);

    boolean checkHeadquarters();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
