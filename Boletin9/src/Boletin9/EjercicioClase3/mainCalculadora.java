package Boletin9.EjercicioClase3;

import Boletin9.Libreria;

public class mainCalculadora {
    public static void main(String[] args) {
        double dNumero = Double.parseDouble(Libreria.leer("Introduce el numero deseado: "));




        Calculadora calc1 = new Calculadora(dNumero);
    }
}
