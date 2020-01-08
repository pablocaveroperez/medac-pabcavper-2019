package EjercicioClase2;

public class mainPersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Antonio","Jimenez","Lopez");
         if (!persona1.setbEdad((short) 152)){
             System.out.println("La edad introducida es incorrecta");
         }
    }
}
