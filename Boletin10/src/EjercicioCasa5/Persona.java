package EjercicioCasa5;

public class Persona implements IPersona {
    protected String sNombre;
    protected String sApellido1;
    protected String sApellido2;
    protected short shEdad;
    protected float fEstatura;
    protected float fKilos;
    protected byte bEstado; // 1 - SOLTERO; 2 - CASADO; 3 - SEPARADO; 4 - DIVORCIADO; 5 - VIUDO

    public Persona(String sNombre, String sApellido1, String sApellido2){
        this.setsNombre(sNombre);
        this.setsApellido1(sApellido1);
        this.setsApellido2(sApellido2);
    }

    @Override
    public String getsNombre() {
        return sNombre;
    }

    @Override
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    @Override
    public String getsApellido1() {
        return sApellido1;
    }

    @Override
    public void setsApellido1(String sApellido1) {
        this.sApellido1 = sApellido1;
    }

    @Override
    public String getsApellido2() {
        return sApellido2;
    }

    @Override
    public void setsApellido2(String sApellido2) {
        this.sApellido2 = sApellido2;
    }

    @Override
    public short getShEdad() {
        return shEdad;
    }

    @Override
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

    @Override
    public float getfEstatura() {
        return fEstatura;
    }

    @Override
    public boolean setfEstatura(float fEstatura) {
        boolean bExito = false;
        if (fEstatura >= 0 && fEstatura <= 3){
            this.fEstatura = fEstatura;
            bExito = true;
        }
        return bExito;
    }

    @Override
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

    @Override
    public byte getbEstado() {
        return bEstado;
    }

    @Override
    public boolean setbEstado(byte bEstado) {
        boolean bExito = false;
        if (this.bEstado == SOLTERO && bEstado == CASADO) {
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == CASADO && bEstado == SEPARADO){
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == SEPARADO && (bEstado == DIVORCIADO || bEstado == VIUDO)){
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == DIVORCIADO && bEstado == CASADO){
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == VIUDO && bEstado == CASADO){
            this.bEstado = bEstado;
            bExito = true;
        }else if (this.bEstado == 0) {
            this.bEstado = bEstado;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public String estadoTexto(){
        String salida = "";
        if (this.bEstado == SOLTERO)
            salida += "SOLTERO";
        if (this.bEstado == CASADO)
            salida += "CASADO";
        if (this.bEstado == SEPARADO)
            salida += "SEPARADO";
        if (this.bEstado == DIVORCIADO)
            salida += "DIVORCIADO";
        if (this.bEstado == VIUDO)
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
