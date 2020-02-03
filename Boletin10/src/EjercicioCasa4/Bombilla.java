package EjercicioCasa4;

public class Bombilla implements IBombilla{
    private boolean bolEncendida = false;

    @Override
    public void encender(){
        this.setBolEncendida(true);
    }

    @Override
    public void apagar(){
        this.setBolEncendida(false);
    }

    @Override
    public void cambiar(){
        if (this.bolEncendida)
            this.setBolEncendida(false);
        else
            this.setBolEncendida(true);
    }

    @Override
    public boolean isBolEncendida() {
        return bolEncendida;
    }

    @Override
    public void setBolEncendida(boolean bolEncendida) {
        this.bolEncendida = bolEncendida;
    }

    @Override
    public String toString(){
        String salida = "";
        if (isBolEncendida())
            salida += '*';
        else
            salida += '·';
        return salida;
    }
}
