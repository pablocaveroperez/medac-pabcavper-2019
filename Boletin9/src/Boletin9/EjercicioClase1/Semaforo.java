package Boletin9.EjercicioClase1;

public class Semaforo {
    /**
     * iColor, 0 es rojo, 1 es ambar y 2 es verde
     */
    private int iColor;
    private boolean bParpadeando;

    public Semaforo() {
        setiColor(2);
        setbParpadeando(true);
    }

    public Semaforo(int iColor){
        if (iColor == 2){
            setiColor(iColor);
            setbParpadeando(true);
        }else{
            setiColor(iColor);
            setbParpadeando(false);
        }
    }

    public int getiColor() {
        return iColor;
    }

    public void setiColor(int iColor) {
        if(iColor >= 1 && iColor <= 3) {
            this.iColor = iColor;
        }
    }

    public boolean isbParpadeando() {
        return bParpadeando;
    }

    public void setbParpadeando(boolean bParpadeando) {
        if(bParpadeando && this.iColor == 2) {
            this.bParpadeando = bParpadeando;
        } else {
            this.bParpadeando = false;
        }
    }

    public String cadenaColor() {
        String sResultado;
        if(getiColor() == 1) {
            sResultado = "ROJO";
        }else if(getiColor() == 2) {
            sResultado = "AMBAR";
        }else {
            sResultado = "VERDE";
        }
        return sResultado;
    }


    public String imprimir() {
        String sResultado = "Semaforo en " + this.cadenaColor();
        if(this.bParpadeando) {
            sResultado += " parpadeando";
        }
        return sResultado;
    }

    public void cambia() {
        if(this.iColor == 1) {
            this.setiColor(3);
        }else if(this.iColor == 3) {
            this.setiColor(2);
            this.setbParpadeando(true);
        }else if(this.iColor == 2 && this.isbParpadeando()) {
            this.setbParpadeando(false);
        }else {
            this.setiColor(1);
        }
    }
}
