package EjercicioCasa7;

public interface ITarjetaCredito {
    public void comprar(float importe, String DNI);

    public void retirarCajero(float importe, int pin);

    public String getId();

    public String getDNITitular();

    public float getSaldo();

    public void setPin(int pin);
}
