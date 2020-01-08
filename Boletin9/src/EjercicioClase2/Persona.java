package EjercicioClase2;

public class Persona {
    private String sNombre;
    private String sApellido1;
    private String sApellido2;
    private short shEdad;
    private float fEstatura;
    private float fKilos;
    private static byte bEstado; // 1 - SOLTERO; 2 - CASADO; 3 - SEPARADO; 4 - DIVORCIADO; 5 - VIUDO

    public Persona(String sNombre, String sApellido1, String sApellido2){
        this.setsNombre(sNombre);
        this.setsApellido1(sApellido1);
        this.setsApellido2(sApellido2);
    }

    public String getsNombre() {
        return sNombre;
    }

    private void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsApellido1() {
        return sApellido1;
    }

    private void setsApellido1(String sApellido1) {
        this.sApellido1 = sApellido1;
    }

    public String getsApellido2() {
        return sApellido2;
    }

    private void setsApellido2(String sApellido2) {
        this.sApellido2 = sApellido2;
    }

    public short getShEdad() {
        return shEdad;
    }

    public boolean setbEdad(short shEdad) {
        boolean bExito = false;
        short shAux = this.shEdad;
        if (shEdad >= 0 && shEdad <= 150){
            this.shEdad = shEdad;
            bExito = true;
            if (shAux < shEdad)
                System.out.println("La edad introducida es mayor que la anterior");
        }
        return bExito;

    }

    public float getfEstatura() {
        return fEstatura;
    }

    public boolean setfEstatura(float fEstatura) {
        boolean bExito = false;
        if (fEstatura >= 1.50 && fEstatura <= 2.32){
            this.fEstatura = fEstatura;
            bExito = true;
        }
        return bExito;
    }

    public float getfKilos() {
        return fKilos;
    }

    public boolean setfKilos(float fKilos) {
        boolean bExito = false;
        if (fKilos >= 30 && fKilos <= 200){
            this.fKilos = fKilos;
            bExito = true;
        }
        return bExito;
    }

    public static byte getbEstado() {
        return bEstado;
    }

    public static boolean setbEstado(byte bEstado) {
        boolean bExito = false;
        if (bEstado == 1 || bEstado == 2 || bEstado == 3 || bEstado == 4 || bEstado == 5){
            Persona.bEstado = bEstado;
            bExito = true;
        }
        return bExito;
    }
}
