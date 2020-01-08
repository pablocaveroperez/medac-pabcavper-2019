package EjercicioClase2;

public class mainPersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Antonio","Jimenez","Lopez");
         if (!persona1.setbEdad((short) 152))
             System.out.println("La edad introducida es incorrecta");


        if (!persona1.setbEdad((short) 20))
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

    }
}
