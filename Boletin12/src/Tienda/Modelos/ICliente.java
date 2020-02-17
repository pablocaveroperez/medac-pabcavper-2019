package Tienda.Modelos;

public interface ICliente {
    int getIdCliente();

    void setsNombre(String sNombre);

    boolean setSaldo(double saldo);

    void setsApellidos(String sApellidos);

    void setsDni(String sDni);

    String getsNombre();

    double getSaldo();

    String getsApellidos();

    String getsDni();
}
