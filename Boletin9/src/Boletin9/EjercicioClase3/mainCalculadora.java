package Boletin9.EjercicioClase3;

import Boletin9.Libreria;

public class mainCalculadora {
    public static void main(String[] args) {
        double dNumero = Double.parseDouble(Libreria.valida("Introduce el numero deseado: ",-2000,2000,5));




        Calculadora calc1 = new Calculadora(dNumero);
    }
}
