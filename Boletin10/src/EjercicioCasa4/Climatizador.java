package EjercicioCasa4;

/*
Como va a calentar o enfriar el climatizador cuando esta apagado. Tiene que estar encendido para que vaya modificando la temperatura actual
*/
public class Climatizador implements IClimatizador {
    private boolean encendido;
    private float temperaturaActual;
    private float temperaturaDeseada;

    public Climatizador(){
        this.setEncendido(false);
    }

    @Override
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

    @Override
    public void desactivar(){
        System.out.println("Se ha desactivado el climatizador");
        setEncendido(false);
        System.exit(0);
    }

    @Override
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    @Override
    public boolean isEncendido() {
        return encendido;
    }

    @Override
    public float getTemperaturaActual() {
        return temperaturaActual;
    }

    @Override
    public float getTemperaturaDeseada() {
        return temperaturaDeseada;
    }

    @Override
    public void setTemperaturaActual(float temperaturaActual) {
        if (!isEncendido())
            this.temperaturaActual = temperaturaActual;
    }

    @Override
    public void setTemperaturaDeseada(float temperaturaDeseada) {
        if (!isEncendido())
            this.temperaturaDeseada = temperaturaDeseada;
    }

    @Override
    public void enfriar(){
        System.out.print("La temperatura ha bajado de "+getTemperaturaActual()+" a ");
        setTemperaturaActual((float) (getTemperaturaActual() - 0.5));
        System.out.println(getTemperaturaActual());
    }

    @Override
    public void calentar(){
        System.out.print("La temperatura ha subido de "+getTemperaturaActual()+" a ");
        setTemperaturaActual((float) (getTemperaturaActual() + 0.5));
        System.out.println(getTemperaturaActual());
    }
}
