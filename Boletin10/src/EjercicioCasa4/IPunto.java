package EjercicioCasa4;

public interface IPunto {
    void setX(double x);

    void setY(double y);

    double getX();

    double getY();

    public void borrar();

    public void mover(double x, double y);

    public void mover(Punto punto);

    public double distancia(Punto punto);

    public String toString();
}
