package model;

import java.util.Objects;

public class Country implements ICountry, LimitsDB {
    private String sName;

    public Country (String sName) {
        setsName(sName);
    }

    @Override
    public String getsName() {
        return sName;
    }

    private boolean setsName(String sName) {
        boolean bExito = false;
        if (sName.length() < MAXCHAR_COUNTRY && sName.length() > 0) {
            this.sName = sName;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean checkCountry(){
        boolean bExito = false;
        if (getsName().length() < MAXCHAR_COUNTRY && getsName() != null){
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return getsName().equals(country.getsName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsName());
    }

    @Override
    public String toString() {
        String salida = "";
        if (checkCountry()) {
            salida += "*******************";
            salida += "\nPais: " + sName;
            salida += "\n*******************";
        }
        return salida;
    }
}
