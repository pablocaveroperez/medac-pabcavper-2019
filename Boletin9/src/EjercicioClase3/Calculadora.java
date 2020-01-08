package EjercicioClase3;

public class Calculadora {
    private double oNumero;
    //private


    public Object getoNumero(byte bTipo) {
        Object oNumero = this.oNumero;
        if (bTipo == 1){
            return Integer.parseInt((String) oNumero);
        }else if (bTipo == 2){
            return Long.parseLong((String) oNumero);
        }else if (bTipo == 3){
            return Float.parseFloat((String) oNumero);
        }else if (bTipo == 4){
            return oNumero;
        }

        return oNumero;
    }
}
