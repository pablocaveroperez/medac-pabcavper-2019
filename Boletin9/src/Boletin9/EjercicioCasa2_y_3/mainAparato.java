package Boletin9.EjercicioCasa2_y_3;

public class mainAparato {
    private static final byte TAMANIO = 3;

    public static void main(String[] args) {
        Aparato[] aparatos = new Aparato[TAMANIO];
        aparatos[0] = new Aparato(100,"Bombilla");
        aparatos[1] = new Aparato(2000,"Radiador");
        aparatos[2] = new Aparato(1200,"Plancha");

        for (int i = 0; i < aparatos.length; i++){
            System.out.println("El aparato "+aparatos[i].getsNombre()+" consume "+aparatos[i].getfConsumo());
        }

        aparatos[0].setEncendido(true);
        aparatos[2].setEncendido(true);

        Instalacion instalacion1 = new Instalacion(aparatos);

        System.out.println(instalacion1.consumoTotal());

        aparatos[2].setEncendido(false);
        aparatos[1].setEncendido(true);

        System.out.println(instalacion1.consumoTotal());

        for (int i = 0; i < aparatos.length; i++){
            System.out.println(aparatos[i]);
        }
    }
}
