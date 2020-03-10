package Problema3;
/*
Como va a calentar o enfriar el climatizador cuando esta apagado. Tiene que estar encendido para que vaya modificando la temperatura actual
 */
public class Climatizador {
    private boolean encendido;
    private float temperaturaActual;
    private float temperaturaDeseada;

    public Climatizador(){
        this.setEncendido(false);
    }

    public void activar(){
        if (getTemperaturaActual() < getTemperaturaDeseada()){
            do {
                calentar();
            }while(getTemperaturaActual() < getTemperaturaDeseada());
        }else if (getTemperaturaActual() > getTemperaturaDeseada()){
            do {
                enfriar();
            }while(getTemperaturaActual() > getTemperaturaDeseada());
        }else {
            setEncendido(true);
            System.out.println("La temperatura actual es igual a la deseada");
            desactivar();
        }
    }

    public void desactivar(){
        System.out.println("Se ha desactivado el climatizador");
        setEncendido(false);
        System.exit(0);
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public float getTemperaturaActual() {
        return temperaturaActual;
    }

    public float getTemperaturaDeseada() {
        return temperaturaDeseada;
    }

    public void setTemperaturaActual(float temperaturaActual) {
        if (!isEncendido())
            this.temperaturaActual = temperaturaActual;
    }

    public void setTemperaturaDeseada(float temperaturaDeseada) {
        if (!isEncendido())
            this.temperaturaDeseada = temperaturaDeseada;
    }

    private void enfriar(){
        System.out.print("La temperatura ha bajado de "+getTemperaturaActual()+" a ");
        setTemperaturaActual((float) (getTemperaturaActual() - 0.5));
        System.out.println(getTemperaturaActual());
    }

    private void calentar(){
        System.out.print("La temperatura ha subido de "+getTemperaturaActual()+" a ");
        setTemperaturaActual((float) (getTemperaturaActual() + 0.5));
        System.out.println(getTemperaturaActual());
    }
}
