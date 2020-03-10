package Problema5;

public class Bombilla {
    private boolean bolEncendida = false;

    /**
     * Este metodo enciende la bombilla
     */
    public void encender(){
        this.setBolEncendida(true);
    }

    /**
     * Este metodo apaga la bombilla
     */
    public void apagar(){
        this.setBolEncendida(false);
    }

    /**
     * Este metodo cambia el estado de la bombilla a encendida si esta apagada o la apaga si esta encendida
     */
    public void cambiar(){
        if (this.bolEncendida)
            this.setBolEncendida(false);
        else
            this.setBolEncendida(true);
    }

    /**
     * Este metodo devuelve el estado de la bombilla
     * @return Estado de la bombilla
     */
    public boolean isBolEncendida() {
        return bolEncendida;
    }

    /**
     * Este metodo cambia el estado de la bombilla
     * @param bolEncendida
     */
    public void setBolEncendida(boolean bolEncendida) {
        this.bolEncendida = bolEncendida;
    }

    public String toString(){
        String salida = "";
        if (isBolEncendida())
            salida += '*';
        else
            salida += '.';
        return salida;
    }
}
