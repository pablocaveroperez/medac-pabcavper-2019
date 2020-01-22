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
        setSaldo(saldo - importe);
    }

    @Override
    public void retirarCajero(float importe, int pin) {

    }

    @Override
    public float cargo(float importe){
        float cargo = 0;
        return cargo;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getDNITitular() {
        return DNITitular;
    }

    @Override
    public void setDNITitular(String DNITitular) {
        this.DNITitular = DNITitular;
    }

    @Override
    public int getPin() {
        return pin;
    }

    @Override
    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public float getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}
