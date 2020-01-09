package Boletin9.EjercicioCasa1;
import Boletin9.Libreria;

public class mainReloj {
    public static void main(String[] args) {
        byte bHoras = (byte) Libreria.valida("Introduce las horas(0-24): ",0,24,3);
        byte bMinutos = (byte) Libreria.valida("Introduce los minutos(0-59): ",0,59,3);
        byte bSegundos = (byte) Libreria.valida("Introduce las segundos(0-59): ",0,59,3);


        Reloj reloj1 = new Reloj(bHoras,bMinutos,bSegundos);

        System.out.println(reloj1.darHora((byte)1,reloj1));
        System.out.println(reloj1.darHora((byte)2,reloj1));

        bHoras = (byte) Libreria.valida("Introduce las horas(0-24): ",0,24,3);
        bMinutos = (byte) Libreria.valida("Introduce los minutos(0-59): ",0,59,3);


        reloj1.ponerEnHora(bHoras,bMinutos);
        System.out.println(reloj1.darHora((byte)1,reloj1));
        System.out.println(reloj1.darHora((byte)2,reloj1));
    }
}
