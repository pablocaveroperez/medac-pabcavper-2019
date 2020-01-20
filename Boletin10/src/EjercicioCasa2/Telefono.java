package EjercicioCasa2;

public class Telefono {
    protected int iTelefono;
    protected boolean altavozEncendido;
    protected boolean estaLlamando;

    public Telefono(int iTelefono){
        setiTelefono(iTelefono);
        setAltavozEncendido(false);
        setEstaLlamando(false);
    }

    public void setiTelefono(int iTelefono) {
        this.iTelefono = iTelefono;
    }

    public int getiTelefono() {
        return iTelefono;
    }

    public void setAltavozEncendido(boolean altavozEncendido) {
        this.altavozEncendido = altavozEncendido;
    }

    public void setEstaLlamando(boolean estaLlamando) {
        this.estaLlamando = estaLlamando;
    }

    public boolean isAltavozEncendido() {
        return altavozEncendido;
    }

    public boolean isEstaLlamando() {
        return estaLlamando;
    }

    public String imprimir(){
        String salida ="";
        salida += "El numero de telefono es: "+getiTelefono();
        salida += "\nEsta en llamada: "+isEstaLlamando();
        salida += "\nEsta altaVOX encendido: "+isAltavozEncendido();
        return salida+"\n";
    }
}
