package EjercicioClase2;

public class Persona {
    private String sNombre;
    private String sApellido1;
    private String sApellido2;
    private byte bEdad;
    private float fEstatura;
    private float fKilos;
    private static byte bEstado; // 1 - SOLTERO; 2 - CASADO; 3 - SEPARADO; 4 - DIVORCIADO; 5 - VIUDO

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsApellido1() {
        return sApellido1;
    }

    public void setsApellido1(String sApellido1) {
        this.sApellido1 = sApellido1;
    }

    public String getsApellido2() {
        return sApellido2;
    }

    public void setsApellido2(String sApellido2) {
        this.sApellido2 = sApellido2;
    }

    public byte getbEdad() {
        return bEdad;
    }

    public void setbEdad(byte bEdad) {
        boolean bExito = false;
        if (bEdad >= 0 && bEdad <= 126){
            this.bEdad = bEdad;
        }

    }

    public float getfEstatura() {
        return fEstatura;
    }

    public void setfEstatura(float fEstatura) {
        this.fEstatura = fEstatura;
    }

    public float getfKilos() {
        return fKilos;
    }

    public void setfKilos(float fKilos) {
        this.fKilos = fKilos;
    }

    public static byte getbEstado() {
        return bEstado;
    }

    public static void setbEstado(byte bEstado) {
        Persona.bEstado = bEstado;
    }
}
