package EjercicioClase1;

import static EjercicioClase1.Libreria.valida;

public class mainReloj {
    public static void main(String[] args) {
        byte bHoras = 0, bMinutos = 0, bSegundos = 0;

        do {
            try {
                bHoras = (byte) valida("Introduce las horas(0-24): ",0,24,3);
            }catch (NumberFormatException exc){
                bHoras = -1;
            }catch (Exception exc){
                bHoras = -1;
            }finally {
                if (bHoras == -1){
                    System.out.println("La hora introducida es incorrecta.");
                }
                else System.out.println("La hora introducida es correcta");
            }
        }while (bHoras == -1);

        do {
            try {
                bMinutos = (byte) valida("Introduce las horas(0-24): ",0,24,3);
            }catch (NumberFormatException exc){
                bMinutos = -1;
            }catch (Exception exc){
                bMinutos = -1;
            }finally {
                if (bMinutos == -1){
                    System.out.println("La hora introducida es incorrecta.");
                }
                else System.out.println("La hora introducida es correcta");
            }
        }while (bMinutos == -1);

        do {
            try {
                bSegundos = (byte) valida("Introduce las segundos(0-59): ",0,59,3);
            }catch (NumberFormatException exc){
                bSegundos = -1;
            }catch (Exception exc){
                bSegundos = -1;
            }finally {
                if (bSegundos == -1){
                    System.out.println("La hora introducida es incorrecta.");
                }
                else System.out.println("La hora introducida es correcta");
            }
        }while (bSegundos == -1);

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