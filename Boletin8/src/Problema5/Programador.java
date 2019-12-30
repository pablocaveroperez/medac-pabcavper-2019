package Problema5;

public class Programador {
    private Bombilla bombilla1;
    private Bombilla bombilla2;
    private Bombilla bombilla3;
    private Bombilla bombilla4;
    private Bombilla bombilla5;
    private Bombilla bombilla6;

    public Programador(){
        this.bombilla1 = new Bombilla();
        this.bombilla2 = new Bombilla();
        this.bombilla3 = new Bombilla();
        this.bombilla4 = new Bombilla();
        this.bombilla5 = new Bombilla();
        this.bombilla6 = new Bombilla();
    }

    public void encenderAlternativo(){
        bombilla1.encender();
        bombilla2.apagar();
        bombilla3.encender();
        bombilla4.apagar();
        bombilla5.encender();
        bombilla6.apagar();
        System.out.println(toString());


        bombilla1.cambiar();
        bombilla2.cambiar();
        bombilla3.cambiar();
        bombilla4.cambiar();
        bombilla5.cambiar();
        bombilla6.cambiar();
        System.out.println(toString());
    }

    public void encenderBarrido(){

    }

    @Override
    public String toString() {
        return bombilla1+" "+bombilla2+" "+bombilla3+" "+bombilla4+" "+bombilla5+" "+bombilla6;
    }
}
