package Boletin9.EjercicioCasa2;

public class Aparato {
    private float fConsumo;
    private boolean isEncendido;

    public Aparato(){
        setEncendido(false);
    }

    public void setEncendido(boolean encendido) {
        isEncendido = encendido;
    }

    public boolean setfConsumo(float fConsumo) {
        boolean bExito = false;
        if (fConsumo > 0){
            this.fConsumo = fConsumo;
            bExito = true;
        }
        return bExito;
    }


}
