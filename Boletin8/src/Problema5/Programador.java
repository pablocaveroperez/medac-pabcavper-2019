package Problema5;

public class Programador {
    private Bombilla []bombillas = new Bombilla[6];

    public Programador(){
        for (int i = 0; i < bombillas.length; i++){
            this.bombillas[i] = new Bombilla();
        }
    }

    /**
     * Este metodo apaga todas las bombillas
     */
    private void reestablecerBombillas(){
        for (int i = 0; i < this.bombillas.length; i++){
            this.bombillas[i].apagar();
        }
    }

    /**
     * Este metodo enciende las bombillas que estan en la posicion impar del vector y luego al contrario
     */
    public void encenderAlternativo(){
        for (int i = 0; i < bombillas.length; i++){
            if (i % 2 != 0)
                this.bombillas[i].encender();
        }
        System.out.println("----------------------------");
        System.out.println(toString());

        for (int i = 0; i < this.bombillas.length; i++){
            this.bombillas[i].cambiar();
        }
        System.out.println(toString());
        System.out.println("----------------------------");
    }

    /**
     * Este metodo va encendiendo poco a poco las bombillas empezando desde la izquierda
     */
    public void encenderBarrido(){
        reestablecerBombillas();
        System.out.println("----------------------------");
        for (int i = 0; i < this.bombillas.length; i++){
            this.bombillas[i].encender();
            System.out.println(toString());
        }
        System.out.println("----------------------------");
    }

    /**
     * Este metodo enciende las bombillas una por una empezando por la izquierda
     */
    public void encenderUnoPorUno(){
        reestablecerBombillas();
        System.out.println("----------------------------");
        for (int i = 0; i < this.bombillas.length; i++){
            this.bombillas[i].encender();
            System.out.println(toString());
            this.bombillas[i].cambiar();
        }
        for (int i = this.bombillas.length-1; i >= 0; i--){
            this.bombillas[i].encender();
            System.out.println(toString());
            this.bombillas[i].cambiar();
        }
        System.out.println("----------------------------");
    }

    @Override
    public String toString() {
        String salida = "";
        for (int i = 0; i < this.bombillas.length;i++){
            salida += this.bombillas[i];
        }
        return salida;
    }
}
