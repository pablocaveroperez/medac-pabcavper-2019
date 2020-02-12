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




        if (!persona1.setbEdad(shEdad))
            System.out.println("La edad introducida es incorrecta");


        if (!persona1.setbEdad(shEdad))
            System.out.println("La edad introducida es incorrecta");


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
                    System.out.println("La estatura introducida es incorrecta");
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
                    System.out.println("Edad introducida incorrecto.");
                else
                    System.out.println("Edad introducida correcto.");
            }
        }while(fKilos == -1);

        if (!persona1.setfKilos(fKilos))
            System.out.println("La masa introducida es incorrecta");

        if (!persona1.setfKilos(fKilos))
            System.out.println("La masa introducida es incorrecta");

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
                    System.out.println("Edad introducida incorrecto.");
                else
                    System.out.println("Edad introducida correcto.");
            }
        }while(bEstado == -1);

        if (!persona1.setbEstado(bEstado))
            System.out.println("El estado introducido es incorrecto");

        if (!persona1.setbEstado(bEstado))
            System.out.println("El estado introducido es incorrecto");

        System.out.println(persona1);

        if (!persona1.setbEstado((byte)5))
            System.out.println("El estado introducido es incorrecto");

        System.out.println(persona1.estadoTexto());

        if (!persona1.setbEstado((byte)2))
            System.out.println("El estado introducido es incorrecto");

        System.out.println(persona1.estadoTexto());

        if (!persona1.setbEstado((byte)3))
            System.out.println("El estado introducido es incorrecto");

        System.out.println(persona1.estadoTexto());

        if (!persona1.setbEstado((byte)4))
            System.out.println("El estado introducido es incorrecto");

        System.out.println(persona1.estadoTexto());

        if (!persona1.setbEstado((byte)5))
            System.out.println("El estado introducido es incorrecto");

        System.out.println(persona1.estadoTexto());

    }
}
