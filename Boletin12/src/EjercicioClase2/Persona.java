package EjercicioClase2;

public class Persona {
    private String sNombre;
    private String sApellido1;
    private String sApellido2;
    private short shEdad;
    private float fEstatura;
    private float fKilos;
    private byte bEstado; // 1 - SOLTERO; 2 - CASADO; 3 - SEPARADO; 4 - DIVORCIADO; 5 - VIUDO

    public Persona(String sNombre, String sApellido1, String sApellido2){
        this.setsNombre(sNombre);
        this.setsApellido1(sApellido1);
        this.setsApellido2(sApellido2);
    }

    public Persona(){

    }

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
                System.out.println("La edad introducida "+shEdad+" es mayor que la anterior "+shAux);
        }
        return bExito;

    }

    public float getfEstatura() {
        return fEstatura;
    }

    public boolean setfEstatura(float fEstatura) {
        boolean bExito = false;
        if (fEstatura >= 0 && fEstatura <= 3){
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
        if (fKilos >= 0 && fKilos <= 300){
            this.fKilos = fKilos;
            bExito = true;
        }
        return bExito;
    }

    public byte getbEstado() {
        return bEstado;
    }

    public boolean setbEstado(byte bEstado) {
        boolean bExito = false;
        if (this.bEstado == 1 && bEstado == 2) {
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == 2 && bEstado == 3){
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == 3 && (bEstado == 4 || bEstado == 5)){
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == 4 && bEstado == 2){
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == 5 && bEstado == 2){
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == 0) {
            this.bEstado = bEstado;
            bExito = true;
        }
        return bExito;
    }

    public String estadoTexto(){
        String salida = "";
        if (this.bEstado == 1)
            salida += "SOLTERO";
        if (this.bEstado == 2)
            salida += "CASADO";
        if (this.bEstado == 3)
            salida += "SEPARADO";
        if (this.bEstado == 4)
            salida += "DIVORCIADO";
        if (this.bEstado == 5)
            salida += "VIUDO";
        return salida;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "\nNombre: "+ getsNombre();
        salida += "\nPrimer Apellido: "+ getsApellido1();
        salida += "\nSegundo Apellido: "+ getsApellido2();
        salida += "\nMasa: "+ getfKilos()+" kg";
        salida += "\nEstatura: "+ getfEstatura()+" m";
        salida += "\nEstado: "+ estadoTexto();
        return salida;
    }
}
