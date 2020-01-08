package Boletin9.EjercicioClase3;

public class Calculadora {
    private double dNumero;
    private int iNumero;
    private long lNumero;
    private float fNumero;
    private Object oNumero;

    public Calculadora(double dNumero){
        this.dNumero = dNumero;
    }

    public double getdNumero() {
        return dNumero;
    }

    public void setdNumero(double dNumero) {
        this.dNumero = dNumero;
    }

    public int getiNumero() {
        return iNumero;
    }

    public void setiNumero(int iNumero) {
        this.iNumero = iNumero;
    }

    public long getlNumero() {
        return lNumero;
    }

    public void setlNumero(long lNumero) {
        this.lNumero = lNumero;
    }

    public float getfNumero() {
        return fNumero;
    }

    public void setfNumero(float fNumero) {
        this.fNumero = fNumero;
    }


    public Object getoNumero(byte bTipo, double dNumero) {

        if (bTipo == 1){
            setiNumero((int) dNumero);
            oNumero = getiNumero();
        }else if (bTipo == 2){
            setlNumero((long) dNumero);
            oNumero = getlNumero();
        }else if (bTipo == 3){
            setfNumero((float) dNumero);
            oNumero = getfNumero();
        }else if (bTipo == 4){
            setdNumero((double) dNumero);
            oNumero = getdNumero();
        }else
            return null;

        return oNumero;
    }
}
