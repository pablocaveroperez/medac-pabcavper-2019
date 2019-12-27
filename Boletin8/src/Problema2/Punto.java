package Problema2;

public class Punto {
    private double x;
    private double y;

    public Punto(){
        setX(0);
        setY(0);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void borrar(){
        setY(0);
        setX(0);
    }

    public void mover(double x, double y){
        setX(x);
        setY(y);
    }

    public void mover(Punto punto){
        setX(punto.getX());
        setY(punto.getY());
    }
}
