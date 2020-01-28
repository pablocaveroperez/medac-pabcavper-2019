package EjercicioClase1;

public interface IReproductorPortatil {
    //  TIPOS DE ALMACENAMIENTOS
    public final byte CD = 1;
    public final byte DVD = 2;
    public final byte MemoriaFlash = 3;
    public final byte Minidisk = 4;

    //  TIPOS DE PANTALLAS
    public final byte NINGUNA = 1;
    public final byte TEXTO = 2;
    public final byte MONOCROMO = 3;
    public final byte COLOR = 4;

    //  TIPOS DE BATERIA
    public final byte PILAS = 1;
    public final byte LI_ION = 2;

    public String getMarca();

    void setMarca(String marca);

    String getModelo();

    boolean isReproduceSonido();

    void setReproduceSonido(boolean reproduceSonido);

    boolean isReproduceVideo();

    void setReproduceVideo(boolean reproduceVideo);

    byte getTipoDeAlmacenamiento();

    boolean setTipoDeAlmacenamiento(byte tipoDeAlmacenamiento);

    int getCapacidadDeAlmacenamiento();

    boolean setCapacidadDeAlmacenamiento(int capacidadDeAlmacenamiento);

    byte getPantalla();

    boolean setPantalla(byte pantalla);

    byte getTipoDeBateria();

    boolean setTipoDeBateria(byte tipoDeBateria);

    int getAutonomia();

    void setAutonomia(int autonomia);

    float getPeso();

    void setPeso(float peso);

    float getAncho();

    void setAncho(float ancho);

    float getAlto();

    void setAlto(float alto);

    float getGrosor();

    void setGrosor(float grosor);
}
