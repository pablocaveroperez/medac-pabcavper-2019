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

    public boolean esFechaValida(byte bDia, byte bMes, short shAnio){
        boolean esValida = true;



        return esValida;
    }

    public boolean esBisiesto(short shAnio){
        return shAnio % 400 == 0 || shAnio % 4 == 0 && shAnio % 100 != 0;
    }
}
