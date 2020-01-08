package Boletin9.EjercicioClase3;

import Boletin9.Libreria;

public class mainCalculadora {
    public static void main(String[] args) {
        double dNumero = (double) Libreria.valida("Introduce el numero deseado: ",-2000,2000,5);
        Calculadora calculadora1 = new Calculadora(dNumero);

        System.out.println(calculadora1.transformarNumero((byte) 1,dNumero));
        System.out.println(calculadora1.suma(5));
        System.out.println(calculadora1.transformarNumero((byte) 1,calculadora1.suma(5)));
        System.out.println(calculadora1.transformarNumero((byte) 1,calculadora1.restar(5)));
        System.out.println(calculadora1.transformarNumero((byte) 1,calculadora1.dividir(5)));
        System.out.println(calculadora1.transformarNumero((byte) 1,calculadora1.multiplicar(5)));
    }
}
