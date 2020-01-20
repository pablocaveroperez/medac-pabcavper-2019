package EjercicioCasa1;

public class mainAeronave {
    public static void main(String[] args) {
        Globo globo = new Globo("111");

        globo.despegar();

        globo.aumentarAlturaDeVuelo(500);

        System.out.println(globo.consultarEstado());

        System.out.println(globo.obtenerAlturaDeVuelo());

        globo.disminuirAlturaDeVuelo(20);

        globo.aterrizar();

        System.out.println(globo.consultarEstado());
    }
}
