package EjercicioCasa3;

public class Reserva {
    private int idReserva;
    private String fecha;
    private String hora;

    public Reserva(int idReserva, String fecha, String hora){

    }

    public void introducirDatos(Socio s1, Instalacion i1){

    }

    public String imprimirRecibo(){

    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHora() {
        return hora;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
}
