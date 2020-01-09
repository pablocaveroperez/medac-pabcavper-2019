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

    public void setbHoras(byte bHoras) {
        this.bHoras = bHoras;
    }

    public void setbMinutos(byte bMinutos) {
        this.bMinutos = bMinutos;
    }

    public void setbSegundos(byte bSegundos) {
        this.bSegundos = bSegundos;
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



    @Override
    public String toString() {
        String salida = "";
        salida += getbHoras() + ":"+getbMinutos()+":"+getbSegundos();
        return salida;
    }
}
