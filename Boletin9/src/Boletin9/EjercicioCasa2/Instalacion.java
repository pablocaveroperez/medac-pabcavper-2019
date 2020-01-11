package Boletin9.EjercicioCasa2;

import java.util.Arrays;

public class Instalacion {
    private Aparato[] oAparatos;

    public Instalacion(Aparato[] oAparatos){
        setoAparatos(oAparatos);
    }

    public void setoAparatos(Aparato[] oAparatos) {
        this.oAparatos = oAparatos;
    }

    public Aparato[] getoAparatos() {
        return oAparatos;
    }

    public void addAparato(Aparato aparato){
        Aparato[] oAparatos = new Aparato[this.oAparatos.length+1];
        for (int i = 0; i < oAparatos.length; i++){
            if (i == oAparatos.length-1)
                oAparatos[i] = aparato;
            else
                oAparatos[i] = this.oAparatos[i];
        }
    }

    public float consumoTotal(){
        float fConsumoTotal = 0;

        for (int i = 0; i < this.getoAparatos().length; i++){
            if (this.getoAparatos()[i].isEncendido())
                fConsumoTotal += this.getoAparatos()[i].getfConsumo();
        }
        return fConsumoTotal;
    }

    @Override
    public String toString() {
        String salida = "";
        for (int i = 0; i < getoAparatos().length; i++){
            salida += getoAparatos()[i].toString()+"\n";
        }
        return salida;
    }
}
