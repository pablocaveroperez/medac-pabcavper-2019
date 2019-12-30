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
        if (bombilla1.isBolEncendida()){
            bombilla2.apagar();
            bombilla3.encender();
            bombilla4.apagar();
            bombilla5.encender();
            bombilla6.apagar();
        }
        else{
            bombilla2.encender();
            bombilla3.apagar();
            bombilla4.encender();
            bombilla5.apagar();
            bombilla6.encender();
        }
    }


}
