package Tienda.Modelos;

public interface ICliente {
    int getIdCliente();

    void setsNombre(String sNombre);

    boolean setSaldo(float saldo);

    void setsApellidos(String sApellidos);

    void setsDni(String sDni);

    String getsNombre();

    float getSaldo();

    String getsApellidos();

    String getsDni();
}
