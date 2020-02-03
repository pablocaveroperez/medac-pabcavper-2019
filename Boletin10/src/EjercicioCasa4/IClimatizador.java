package EjercicioCasa4;

public interface IClimatizador {

    void activar();

    public void desactivar();

    void setEncendido(boolean encendido);

    boolean isEncendido();

    float getTemperaturaActual();

    float getTemperaturaDeseada();

    void setTemperaturaActual(float temperaturaActual);

    void setTemperaturaDeseada(float temperaturaDeseada);

    public void enfriar();

    public void calentar();
}
