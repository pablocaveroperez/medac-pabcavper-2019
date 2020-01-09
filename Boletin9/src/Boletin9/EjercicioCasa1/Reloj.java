package Boletin9.EjercicioCasa1;

public class Reloj {
    private byte bHoras;
    private byte bMinutos;
    private byte bSegundos;

    public Reloj(){
        setbHoras((byte)0);
        setbMinutos((byte)0);
        setbSegundos((byte)0);
    }

    public Reloj(byte bHoras, byte bMinutos, byte bSegundos){
        setbHoras(bHoras);
        setbMinutos(bMinutos);
        setbSegundos(bSegundos);
    }

    public boolean setbHoras(byte bHoras) {
        boolean bExito = false;
        if (bHoras >= 0 && bHoras <= 24){
            this.bHoras = bHoras;
            bExito = true;
        }
        return bExito;
    }

    public boolean setbMinutos(byte bMinutos) {
        boolean bExito = false;
        if (bMinutos >= 0 && bMinutos <= 59){
            this.bMinutos = bMinutos;
            bExito = true;
        }
        return bExito;
    }

    public boolean setbSegundos(byte bSegundos) {
        boolean bExito = false;
        if (bSegundos >= 0 && bSegundos <= 59){
            this.bSegundos = bSegundos;
            bExito = true;
        }
        return bExito;
    }

    public byte getbHoras() {
        return bHoras;
    }

    public byte getbMinutos() {
        return bMinutos;
    }

    public byte getbSegundos() {
        return bSegundos;
    }

    public String darHora(byte bTipo){
        String salida ="";
        if (bTipo == 1){ // AM
            salida += darHoraAM();
        }else if (bTipo == 2){ // PM
            salida += darHoraPM();
        }
        return salida;
    }

    private String darHoraPM() {

    }

    private String darHoraAM() {
    }

    @Override
    public String toString() {
        String salida = "";
        salida += getbHoras() + ":"+getbMinutos()+":"+getbSegundos();
        return salida;
    }
}
