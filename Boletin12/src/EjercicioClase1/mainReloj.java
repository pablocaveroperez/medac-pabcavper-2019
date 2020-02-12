package EjercicioClase1;

import static EjercicioClase1.Libreria.valida;

public class mainReloj {
    public static void main(String[] args) {

        try {
            byte bHoras = (byte) valida("Introduce las horas(0-24): ",0,24,3);
        }catch (NumberFormatException exc){

        }


        byte bMinutos = (byte) valida("Introduce los minutos(0-59): ",0,59,3);
        byte bSegundos = (byte) valida("Introduce las segundos(0-59): ",0,59,3);


        Reloj reloj1 = new Reloj(bHoras,bMinutos,bSegundos);

        System.out.println(reloj1.darHora((byte)1,reloj1));
        System.out.println(reloj1.darHora((byte)2,reloj1));

        bHoras = (byte) valida("Introduce las horas(0-24): ",0,24,3);
        bMinutos = (byte) valida("Introduce los minutos(0-59): ",0,59,3);


        reloj1.ponerEnHora(bHoras,bMinutos);
        System.out.println(reloj1.darHora((byte)1,reloj1));
        System.out.println(reloj1.darHora((byte)2,reloj1));
    }
}
