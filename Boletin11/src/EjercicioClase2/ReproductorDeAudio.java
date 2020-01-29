package EjercicioClase2;

import EjercicioClase1.ReproductorPortatil;

public class ReproductorDeAudio extends ReproductorPortatil implements IReproductorAudio {
    private boolean reproduceAudioCds, reproduceMP3, reproduceWMA, reproduceVorbis;
    private boolean accesoPorCarpetas;
    private boolean radio;
    private boolean grabacionDeVoz;

    public ReproductorDeAudio(String marca, String modelo, byte tipoDeAlmacenamiento){
        super(marca, modelo, tipoDeAlmacenamiento);
        setReproduceAudioCds(false);
        setReproduceMP3(false);
        setReproduceWMA(false);
        setReproduceVorbis(false);
    }

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

    @Override
    public String toString() {
        return "ReproductorDeAudio{" +
                "reproduceAudioCds: " + reproduceAudioCds +
                "\nReproduceMP3: " + reproduceMP3 +
                "\nReproduceWMA: " + reproduceWMA +
                "\nReproduceVorbis: " + reproduceVorbis +
                "\nAccesoPorCarpetas: " + accesoPorCarpetas +
                "\nRadio: " + radio +
                "\nGrabacionDeVoz: " + grabacionDeVoz;
    }
}
