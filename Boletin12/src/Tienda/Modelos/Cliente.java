package Tienda.Modelos;

public class Cliente implements ICliente {
    private int idCliente;
    private String sNombre;
    private double saldo;
    private String sApellidos;
    private String sDni;

    public Cliente(String sDni, String sNombre, String sApellidos, double saldo){
        setSaldo(saldo);
        setsApellidos(sApellidos);
        setsNombre(sNombre);
        setsDni(sDni);
    }

    public Cliente(String sDni){
        setsDni(sDni);
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
    public boolean setSaldo(double saldo) {
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
    public double getSaldo() {
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
}
