package EjercicioCasa3;

public class Club {
    private static final byte MAXSOCIOS = 50;
    private static final byte MAXALQUILERES = 50;
    private static final byte MAXRESERVA = 50;
    private static final byte MAXINSTALACIONES = 50;
    private static final byte MAXARTICULOS = 50;

    public static void main(String[] args) {
        Terminal t1 = new Terminal((byte) 1,MAXSOCIOS,MAXARTICULOS,MAXINSTALACIONES,MAXRESERVA,MAXALQUILERES);
    }
}
