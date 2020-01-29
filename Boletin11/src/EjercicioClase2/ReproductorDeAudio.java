package EjercicioClase2;

public class ReproductorDeAudio implements IReproductorAudio {
    private boolean reproduceAudioCds, reproduceMP3, reproduceWMA, reproduceVorbis;
    private boolean accesoPorCarpetas;
    private boolean radio;
    private boolean grabacionDeVoz;

    public boolean isAccesoPorCarpetas() {
        return accesoPorCarpetas;
    }

    public boolean isGrabacionDeVoz() {
        return grabacionDeVoz;
    }

    public boolean isReproduceAudioCds() {
        return reproduceAudioCds;
    }

    public void setReproduceAudioCds(boolean reproduceAudioCds) {
        this.reproduceAudioCds = reproduceAudioCds;
    }

    public boolean isReproduceMP3() {
        return reproduceMP3;
    }

    public void setReproduceMP3(boolean reproduceMP3) {
        this.reproduceMP3 = reproduceMP3;
    }

    public boolean isReproduceWMA() {
        return reproduceWMA;
    }

    public void setReproduceWMA(boolean reproduceWMA) {
        this.reproduceWMA = reproduceWMA;
    }

    public boolean isReproduceVorbis() {
        return reproduceVorbis;
    }

    public void setReproduceVorbis(boolean reproduceVorbis) {
        this.reproduceVorbis = reproduceVorbis;
    }

    public void setAccesoPorCarpetas(boolean accesoPorCarpetas) {
        this.accesoPorCarpetas = accesoPorCarpetas;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public void setGrabacionDeVoz(boolean grabacionDeVoz) {
        this.grabacionDeVoz = grabacionDeVoz;
    }
}
