package Club.Modelos;

public class Instalacion {
    private byte ubicacion;
    private byte tipo;
    private boolean bEstado;

    public Instalacion(byte ubicacion, byte tipo){
        setUbicacion(ubicacion);
        setTipo(tipo);
        setbEstado(true);
    }

    public byte getUbicacion() {
        return ubicacion;
    }

    private boolean setUbicacion(byte ubicacion) {
        boolean bExito = false;
        if (ubicacion > 0){
            this.ubicacion = ubicacion;
            bExito = true;
        }else
            this.ubicacion = -1;
        return bExito;
    }

    public byte getTipo() {
        return tipo;
    }

    private boolean setTipo(byte tipo) {
        boolean bExito = false;
        if (tipo > 0 && tipo < 4){
            this.tipo = tipo;
            bExito = true;
        }else
            this.tipo = -1;
        return bExito;
    }

    public boolean isbEstado() {
        return bEstado;
    }

    public void setbEstado(boolean bEstado) {
        this.bEstado = bEstado;
    }

    public String tipoString(){
        String salida = "";
        if (getTipo() == FUTBOL)
            salida = "FUTBOL";
        else if (getTipo() == PADEL)
            salida = "PADEL";
        else if (getTipo() == BALONCESTO)
            salida = "BALONCESTO";
        return salida;
    }
}
