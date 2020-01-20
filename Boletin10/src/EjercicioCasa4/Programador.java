package EjercicioCasa4;

public class Programador {
    private Bombilla []bombillas = new Bombilla[6];

    public Programador(){
        this.bombillas[0] = new Bombilla();
        this.bombillas[1] = new Bombilla();
        this.bombillas[2] = new Bombilla();
        this.bombillas[3] = new Bombilla();
        this.bombillas[4] = new Bombilla();
        this.bombillas[5] = new Bombilla();
    }

    private void reestablecerBombillas(){
        for (int i = 0; i < this.bombillas.length; i++){
            this.bombillas[i].apagar();
        }
    }

    public void encenderAlternativo(){
        bombillas[0].encender();
        bombillas[1].apagar();
        bombillas[2].encender();
        bombillas[3].apagar();
        bombillas[4].encender();
        bombillas[5].apagar();
        System.out.println("----------------------------");
        System.out.println(toString());

        for (int i = 0; i < this.bombillas.length; i++){
            this.bombillas[i].cambiar();
        }
        System.out.println(toString());
        System.out.println("----------------------------");
    }

    public void encenderBarrido(){
        reestablecerBombillas();
        System.out.println("----------------------------");
        for (int i = 0; i < this.bombillas.length; i++){
            this.bombillas[i].encender();
            System.out.println(toString());
        }
        System.out.println("----------------------------");
    }

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