package EjercicioCasa3;

public class Reserva {
    private int idReserva;
    private String fecha;
    private String hora;
    private Socio sosio;
    private Instalacion instalasion;

    public Reserva(int idReserva, String fecha, String hora){
        setIdReserva(idReserva);
        setFecha(fecha);
        setHora(hora);
    }

    public void introducirDatos(Socio s1, Instalacion i1){

    }

    public String imprimirRecibo(){
        String salida = "";
        salida += "idReserva: "+ getIdReserva()+"\n";
        salida += "Fecha: " + getFecha()+"\n";
        salida +=
        return salida;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setInstalasion(Instalacion instalasion) {
        this.instalasion = instalasion;
    }

    public Instalacion getInstalasion() {
        return instalasion;
    }

    public void setSosio(Socio sosio) {
        this.sosio = sosio;
    }

    public Socio getSosio() {
        return sosio;
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

    private void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
}
