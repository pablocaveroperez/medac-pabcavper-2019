package EjercicioClase2;

import static EjercicioClase1.Libreria.*;

public class mainPersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Antonio","Jimenez","Lopez");

        short shEdad;

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


        if (!persona1.setfEstatura(1.82f))
            System.out.println("La estatura introducida es incorrecta");

        if (!persona1.setfEstatura(-1.5f))
            System.out.println("La estatura introducida es incorrecta");

        if (!persona1.setfKilos(75.5f))
            System.out.println("La masa introducida es incorrecta");

        if (!persona1.setfKilos(324.2f))
            System.out.println("La masa introducida es incorrecta");

        if (!persona1.setbEstado((byte) 1))
            System.out.println("El estado introducido es incorrecto");

        if (!persona1.setbEstado((byte)3))
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
