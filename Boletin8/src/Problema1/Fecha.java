package Problema1;

public class Fecha {
    private byte bDia;
    private byte bMes;
    private short shAnio;

    public Fecha(){

    }

    public byte getbDia() {
        return bDia;
    }

    public void setbDia(byte bDia) {
        this.bDia = bDia;
    }

    public byte getbMes() {
        return bMes;
    }

    public void setbMes(byte bMes) {
        this.bMes = bMes;
    }

    public short getbAnio() {
        return shAnio;
    }

    public void setbAnio(short bAnio) {
        this.shAnio = bAnio;
    }

    public byte diasDelMes(byte bMes, short shAnio){
        byte diasDelMes;
        if (bMes == 1 || bMes == 3 || bMes == 5 || bMes == 7 || bMes == 8 || bMes == 10 || bMes == 12)
            diasDelMes = 31;
        else if (bMes == 4 || bMes == 6 || bMes == 9 || bMes == 11)
            diasDelMes = 30;
        else
            if (esBisiesto(shAnio))
                diasDelMes = 29;
            else
                diasDelMes = 28;

        return diasDelMes;
    }

    public boolean esFechaValida(byte bDia, byte bMes, short shAnio){
        boolean esValida = false;
        if (bMes == 2){
            if (esBisiesto(shAnio)){
                if (bDia >= 1 && bDia <= diasDelMes(bMes,shAnio))
                    esValida = true;
                else
                    esValida = false;
            }
        }


        return esValida;
    }

    public boolean esBisiesto(short shAnio){
        return shAnio % 400 == 0 || shAnio % 4 == 0 && shAnio % 100 != 0;
    }
}
