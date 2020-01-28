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

    public void getMarca();
}
