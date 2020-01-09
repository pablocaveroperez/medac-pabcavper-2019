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

    public float getfConsumo() {
        return fConsumo;
    }

    public boolean isEncendido() {
        return isEncendido;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "El aparato consume: "+getfConsumo();
        if (isEncendido())
            salida += "Estado: Encendido";
        else
            salida += "Estado: Apagado";
        return salida;
    }
}
