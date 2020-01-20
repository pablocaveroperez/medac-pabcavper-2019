package EjercicioCasa4;

public class Bombilla implements IBombilla{
    private boolean bolEncendida = false;

    public void encender(){
        this.setBolEncendida(true);
    }

    public void apagar(){
        this.setBolEncendida(false);
    }

    public void cambiar(){
        if (this.bolEncendida)
            this.setBolEncendida(false);
        else
            this.setBolEncendida(true);
    }

    public boolean isBolEncendida() {
        return bolEncendida;
    }

    public void setBolEncendida(boolean bolEncendida) {
        this.bolEncendida = bolEncendida;
    }

    public String toString(){
        String salida = "";
        if (isBolEncendida())
            salida += '*';
        else
            salida += '�';
        return salida;
    }
}