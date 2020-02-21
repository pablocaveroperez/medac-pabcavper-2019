package EjercicioClase2;

import static EjercicioClase1.Libreria.*;

public class mainPersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Antonio","Jimenez","Lopez");

        short shEdad = 0;

        do {
            try{
                shEdad = (short) valida("Introduce la edad: ", 0,150,4);
            }catch (NumberFormatException exc){
                shEdad = -1;
            }catch (Exception exc){
                shEdad = -1;
            }finally {
                if (shEdad == -1)
                    System.out.println("Edad introducida incorrecto.");
                else
                    System.out.println("Edad introducida correcto.");
            }
        }while(shEdad == -1);

        float fEstatura = 0;

        do {
            try{
                fEstatura = (float) valida("Introduce la edad: ", 0,3,2);
            }catch (NumberFormatException exc){
                fEstatura = -1;
            }catch (Exception exc){
                fEstatura = -1;
            }finally {
                if (fEstatura == -1)
                    System.out.println("La estatura introducida es incorrecta");
                else
                    System.out.println("La estatura introducida es correcta");
            }
        }while(fEstatura == -1);

        float fKilos = 0;

        do {
            try{
                fKilos = (float) valida("Introduce la edad: ", 0,300,2);
            }catch (NumberFormatException exc){
                fKilos = -1;
            }catch (Exception exc){
                fKilos = -1;
            }finally {
                if (fKilos == -1)
                    System.out.println("La masa introducida es incorrecta");
                else
                    System.out.println("La masa introducida es correcta");
            }
        }while(fKilos == -1);

        byte bEstado = 0;

        do {
            try{
                bEstado = (byte) valida("Introduce la edad: ", 1,5,3);
            }catch (NumberFormatException exc){
                bEstado = -1;
            }catch (Exception exc){
                bEstado = -1;
            }finally {
                if (bEstado == -1)
                    System.out.println("El estado introducido es incorrecto");
                else
                    System.out.println("El estado introducido es correcto");
            }
        }while(bEstado == -1);

        System.out.println(persona1);

        System.out.println(persona1.estadoTexto());

    }
}
