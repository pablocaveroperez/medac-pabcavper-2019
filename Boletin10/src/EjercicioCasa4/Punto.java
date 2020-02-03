package EjercicioCasa4;

public class Punto implements IPunto{
    private double x;
    private double y;

    public Punto(){
        this.setX(0);
        this.setY(0);
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void borrar(){
        setY(0);
        setX(0);
    }

    @Override
    public void mover(double x, double y){
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void mover(Punto punto){
        this.setX(punto.getX());
        this.setY(punto.getY());
    }

    @Override
    public double distancia(Punto punto){
        return Math.sqrt(Math.pow(this.getX() - punto.getX(),2) + Math.pow(this.getY() - punto.getY(),2));
    }

    @Override
    public String toString() {
        return "("+this.getX()+" , "+this.getY()+")";
    }
}
