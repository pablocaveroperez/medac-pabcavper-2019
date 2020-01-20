package EjercicioCasa1;

public interface IAeronave {
    public final byte VOLANDO = 1;
    public final byte TIERRA = 2;

    public void aumentarAlturaDeVuelo(int aumento);
    public void disminuirAlturaDeVuelo(int descenso);
    public int obtenerAlturaDeVuelo();
    public void variarAlturaDeVuelo(int altura);
    public void despegar();
    public void aterrizar();
    public String obtenerIdentificacion();
    public void establecerIdentificacion(String identificacion);

    public String consultarEstado();
}
