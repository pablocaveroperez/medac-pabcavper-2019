package Club.Modelos;

import java.util.Calendar;

public class Reserva {
    private Socio socio;
    private Instalacion instalacion;
    private Calendar fecha;
    private byte hora;
    private byte minutos;

    public Reserva(Socio socio, Instalacion instalacion, Calendar fecha, byte hora, byte minutos){
        setSocio(socio);
        setInstalacion(instalacion);
        setFecha(fecha);
        setHora(hora);
        setMinutos(minutos);
    }

    public Socio getSocio() {
        return socio;
    }

    private void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    private void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Calendar getFecha() {
        return fecha;
    }

    private void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public byte getHora() {
        return hora;
    }

    private boolean setHora(byte hora) {
        boolean bExito = false;
        if (hora >= 0 && hora < 24){
            this.hora = hora;
            bExito = true;
        }else
            this.hora = -1;
        return bExito;
    }

    public byte getMinutos() {
        return minutos;
    }

    private boolean setMinutos(byte minutos) {
        boolean bExito = false;
        if (minutos >= 0 && minutos < 60){
            this.minutos = minutos;
            bExito = true;
        }else
            this.minutos = -1;
        return bExito;
    }

    public boolean reservaValida(){
        boolean bExito = false;
        if (getHora() != -1 && getMinutos() != -1 && getFecha() != null && instalacion.instalacionValida() && socio.getId() != 0)
            bExito = true;
        return bExito;
    }
}
