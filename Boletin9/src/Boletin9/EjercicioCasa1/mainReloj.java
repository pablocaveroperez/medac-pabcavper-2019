package Boletin9.EjercicioCasa1;

public class mainReloj {
    public static void main(String[] args) {
        Reloj reloj1 = new Reloj((byte)18,(byte)35,(byte)50);

        System.out.println(reloj1.darHora((byte)1,reloj1));
        System.out.println(reloj1.darHora((byte)2,reloj1));
    }
}
