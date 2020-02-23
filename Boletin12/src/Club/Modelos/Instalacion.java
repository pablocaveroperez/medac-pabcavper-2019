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

    public void setTipo(byte tipo) {
        this.tipo = tipo;
    }

    public boolean isbEstado() {
        return bEstado;
    }

    public void setbEstado(boolean bEstado) {
        this.bEstado = bEstado;
    }
}
