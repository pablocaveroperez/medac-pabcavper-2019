package EjercicioCasa7;

public interface ITarjetaCredito {
    public void comprar(float importe, String DNI);

    public void retirarCajero(float importe, int pin);

    public float cargo(float importe);

    public String getId();

    void setId(String id);

    public String getDNITitular();

    public float getSaldo();

    int getPin();

    public void setPin(int pin);

    void setSaldo(float saldo);
}
