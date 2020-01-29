package EjercicioClase2;

public class ReproductorDeAudio implements IReproductorAudio {
    private boolean reproduceAudioCds, reproduceMP3, reproduceWMA, reproduceVorbis;
    private boolean accesoPorCarpetas;
    private boolean radio;
    private boolean grabacionDeVoz;

    @Override
    public boolean isAccesoPorCarpetas() {
        return accesoPorCarpetas;
    }

    @Override
    public boolean isGrabacionDeVoz() {
        return grabacionDeVoz;
    }

    @Override
    public boolean isReproduceAudioCds() {
        return reproduceAudioCds;
    }

    @Override
    public void setReproduceAudioCds(boolean reproduceAudioCds) {
        this.reproduceAudioCds = reproduceAudioCds;
    }

    @Override
    public boolean isReproduceMP3() {
        return reproduceMP3;
    }

    @Override
    public void setReproduceMP3(boolean reproduceMP3) {
        this.reproduceMP3 = reproduceMP3;
    }

    @Override
    public boolean isReproduceWMA() {
        return reproduceWMA;
    }

    @Override
    public void setReproduceWMA(boolean reproduceWMA) {
        this.reproduceWMA = reproduceWMA;
    }

    @Override
    public boolean isReproduceVorbis() {
        return reproduceVorbis;
    }

    @Override
    public void setReproduceVorbis(boolean reproduceVorbis) {
        this.reproduceVorbis = reproduceVorbis;
    }

    @Override
    public void setAccesoPorCarpetas(boolean accesoPorCarpetas) {
        this.accesoPorCarpetas = accesoPorCarpetas;
    }

    @Override
    public boolean isRadio() {
        return radio;
    }

    @Override
    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    @Override
    public void setGrabacionDeVoz(boolean grabacionDeVoz) {
        this.grabacionDeVoz = grabacionDeVoz;
    }
}