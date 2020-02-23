package Club.Modelos;

import java.util.Calendar;
import java.util.Objects;

public class Reserva implements IReserva {
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

    @Override
    public Socio getSocio() {
        return socio;
    }

    private void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Override
    public Instalacion getInstalacion() {
        return instalacion;
    }

    private void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    @Override
    public Calendar getFecha() {
        return fecha;
    }

    private void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    @Override
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

    @Override
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

    @Override
    public boolean reservaValida(){
        boolean bExito = false;
        if (getHora() != -1 && getMinutos() != -1 && getFecha() != null && instalacion.instalacionValida() && socio.getId() != 0)
            bExito = true;
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        boolean bExito = false;
        Reserva that = (Reserva) o;
        if (this != null && that != null && this.getInstalacion().equals(that.getInstalacion()) && this.getFecha().equals(that.getFecha())){
            if ((this.getHora() + 1 == that.getHora() && that.getMinutos() < this.getMinutos())
                    || (this.getHora() - 1 == that.getHora() && that.getMinutos() > this.getMinutos())
                    || this.getHora() == that.getHora())
                bExito = true;
        }
        return bExito;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSocio(), getInstalacion(), getFecha(), getHora(), getMinutos());
    }
}
