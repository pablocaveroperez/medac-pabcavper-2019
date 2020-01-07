package Clase_3;

public class Semaforo {
    /**
     * iColor, 0 es rojo, 1 es ambar y 2 es verde
     */
    private int iColor;
    private boolean parpadeando;

    public Semaforo(){
        setiColor(0);
        setParpadeando(false);
    }

    public int getiColor() {
        return iColor;
    }

    public void setiColor(int iColor) {
        if (iColor == 0 ||iColor == 1 || iColor == 2)
            this.iColor = iColor;
    }

    public boolean isParpadeando() {
        return parpadeando;
    }

    public void setParpadeando(boolean parpadeando) {
        if (isParpadeando() && getiColor() == 1)
            this.parpadeando = parpadeando;
    }

    private String cadenaColor(){
        String salida ="";
        if (getiColor() == 0)
            salida += "ROJO";
        if (getiColor() == 1)
            salida += "AMBAR";
        if (getiColor() == 2)
            salida += "VERDE";
        return salida;
    }

    public void imprimir(){
        String salida = "";
        salida += "El semaforo es "+cadenaColor();
        if (isParpadeando())
            salida += " parpadeando";
        System.out.println(salida);
    }

    public void cambia(){

            if (getiColor() == 2){
                setiColor(0);
            }else if (getiColor() == 0){
                setParpadeando(true);
                setiColor(1);
            }else if (getiColor() == 1){

            }
            else
                setiColor(getiColor()+1);
    }
}
