package Club.Modelos;

import java.util.Objects;

public class Instalacion implements IInstalacion {
    private byte ubicacion;
    private byte tipo;
    private boolean bEstado;

    public Instalacion(byte ubicacion, byte tipo){
        setUbicacion(ubicacion);
        setTipo(tipo);
        setbEstado(true);
    }

    @Override
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

    @Override
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

    @Override
    public boolean isbEstado() {
        return bEstado;
    }

    @Override
    public void setbEstado(boolean bEstado) {
        this.bEstado = bEstado;
    }

    @Override
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

    @Override
    public boolean instalacionValida(){
        boolean bExito = false;
        if (getTipo() != -1 && getUbicacion() != -1)
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Instalacion that = (Instalacion) o;
        return getUbicacion() == that.getUbicacion() && getTipo() == that.getTipo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUbicacion(), getTipo());
    }

    public String toString(){
        String salida = "";
        if (instalacionValida()){
            salida += "*********************************************";
            salida += "\nNombre de la instalacion: " + tipoString() + " " + getUbicacion();
            salida += "\nEstado de la instalacion: " + isbEstado();
        }
        return salida;
    }
}
