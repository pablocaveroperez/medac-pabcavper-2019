package Tienda.Modelos;

public class Cliente {
    private String sNombre;
    private double saldo;
    private String sApellidos;
    private String sDni;

    public Cliente(){

    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setsApellidos(String sApellidos) {
        this.sApellidos = sApellidos;
    }

    public void setsDni(String sDni) {
        this.sDni = sDni;
    }
}
