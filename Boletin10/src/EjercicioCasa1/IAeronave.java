package EjercicioCasa1;

public interface IAeronave {
    public final byte VOLANDO = 1;
    public final byte TIERRA = 2;

    public String aumentarAlturaDeVuelo(int aumento);

    public String disminuirAlturaDeVuelo(int descenso);

    public String despegar();

    public String aterrizar();

    public Object consultarEstado();
}
