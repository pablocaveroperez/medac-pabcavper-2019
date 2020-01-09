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

    public String darHora(byte bTipo, Reloj reloj){
        String salida ="";
        if (bTipo == 1){ // 12
            salida += darHora12(reloj);
        }else if (bTipo == 2){ // 24
            salida += darHora24();
        }
        return salida;
    }

    private String darHora24() {
        return toString();
    }

    private String darHora12(Reloj reloj) {
        String salida = "";
        if (reloj.getbHoras() <= 11 && reloj.getbHoras() >= 0){
            salida += reloj.getbHoras()+ ":"+reloj.getbMinutos()+":"+reloj.getbSegundos()+" AM";
        }else if (reloj.getbHoras() > 12 && reloj.getbHoras() <= 23){
            salida += (reloj.getbHoras() - 12)+":"+reloj.getbMinutos()+":"+reloj.getbSegundos()+" PM";
        }else if (reloj.getbHoras() == 12){
            salida += toString()+ " PM";
        }
        return salida;
    }

    public void ponerEnHora(byte bHoras, byte bMinutos){
        setbHoras(bHoras);
        setbMinutos(bMinutos);
        setbSegundos((byte)0);
    }

    public void ponerEnHora(byte bHoras, byte bMinutos, byte bSegundos){
        setbHoras(bHoras);
        setbMinutos(bMinutos);
        setbSegundos(bSegundos);
    }

    public String toString() {
        String salida = "";
        salida += getbHoras() + ":"+getbMinutos()+":"+getbSegundos();
        return salida;
    }
}
