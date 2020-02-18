package Tienda.Modelos;

import java.util.Objects;

public class Cliente implements ICliente {
    private int idCliente;
    private String sNombre;
    private float saldo;
    private String sApellidos;
    private String sDni;

    public Cliente(String sDni, String sNombre, String sApellidos, float saldo, int idCliente){
        setSaldo(saldo);
        setsApellidos(sApellidos);
        setsNombre(sNombre);
        setsDni(sDni);
        setIdCliente(idCliente);
    }

    public Cliente(int idCliente){
        setIdCliente(idCliente);
    }

    @Override
    public int getIdCliente() {
        return idCliente;
    }

    private boolean setIdCliente(int idCliente) {
        boolean bExito = false;
        if (idCliente > 0){
            this.idCliente = idCliente;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    @Override
    public boolean setSaldo(float saldo) {
        boolean bExito = false;
        if (saldo > 0 && saldo < 2000){
            this.saldo = saldo;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public void setsApellidos(String sApellidos) {
        this.sApellidos = sApellidos;
    }

    @Override
    public void setsDni(String sDni) {
        this.sDni = sDni;
    }

    @Override
    public String getsNombre() {
        return sNombre;
    }

    @Override
    public float getSaldo() {
        return saldo;
    }

    @Override
    public String getsApellidos() {
        return sApellidos;
    }

    @Override
    public String getsDni() {
        return sDni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cliente cliente = (Cliente) o;
        return idCliente == cliente.idCliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "**************************";
        salida += "\nID CLIENTE: "+ getIdCliente();
        salida += "\nNOMBRE: "+ getsNombre();
        salida += "\nAPELLIDOS: "+ getsApellidos();
        salida += "\nSALDO: "+ getSaldo();
        salida += "\nDNI: "+ getsDni();
        return salida;
    }
}
