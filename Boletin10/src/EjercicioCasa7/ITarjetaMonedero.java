package EjercicioCasa7;

public interface ITarjetaMonedero {
    public void comprar(float importe, String DNI);

    public String getId();

    public String getDNITitular();

    public void setDNITitular(String DNITitular);

    public float getSaldo();

    public void setPin(int pin);
}
