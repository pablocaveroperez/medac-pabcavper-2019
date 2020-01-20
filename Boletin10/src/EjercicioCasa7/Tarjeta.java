package EjercicioCasa7;

public class Tarjeta implements ITarjetaCredito, ITarjetaMonedero {
    private String id;
    private String DNITitular;
    private int pin;
    private float saldo;

    public Tarjeta (String id, String dniTitular, int pin, float saldo) {
        setId(id);
        setDNITitular(dniTitular);
        setPin(pin);
        setSaldo(saldo);
    }

    @Override
    public void comprar(float importe, String DNI) {

    }

    @Override
    public void retirarCajero(float importe, int pin) {

    }

    private float cargo(float importe){
        float cargo = 0;
        return cargo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDNITitular() {
        return DNITitular;
    }

    public void setDNITitular(String DNITitular) {
        this.DNITitular = DNITitular;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}
