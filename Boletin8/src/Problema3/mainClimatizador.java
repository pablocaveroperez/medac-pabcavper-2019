package Problema3;

public class mainClimatizador {
    public static void main(String[] args) {
        Climatizador climatizador = new Climatizador();

        climatizador.setTemperaturaDeseada(25);
        climatizador.setTemperaturaActual(14);

        climatizador.activar();

        System.out.println();

        climatizador.setTemperaturaDeseada(14);
        climatizador.setTemperaturaActual(25);

        climatizador.activar();
    }
}
