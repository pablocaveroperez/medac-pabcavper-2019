package EjercicioCasa4;

public interface IPunto {
    public void borrar();

    public void mover(double x, double y);

    public void mover(Punto punto);

    public double distancia(Punto punto);
}
