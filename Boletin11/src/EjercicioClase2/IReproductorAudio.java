package EjercicioClase2;

public interface IReproductorAudio {
    boolean isAccesoPorCarpetas();

    boolean isGrabacionDeVoz();

    boolean isReproduceAudioCds();

    void setReproduceAudioCds(boolean reproduceAudioCds);

    boolean isReproduceMP3();

    void setReproduceMP3(boolean reproduceMP3);

    boolean isReproduceWMA();

    void setReproduceWMA(boolean reproduceWMA);

    boolean isReproduceVorbis();

    void setReproduceVorbis(boolean reproduceVorbis);

    void setAccesoPorCarpetas(boolean accesoPorCarpetas);

    boolean isRadio();

    void setRadio(boolean radio);

    void setGrabacionDeVoz(boolean grabacionDeVoz);
}
