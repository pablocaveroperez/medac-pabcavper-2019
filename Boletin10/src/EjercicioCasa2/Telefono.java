package EjercicioCasa2;

public class Telefono implements ITelefono {
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

    @Override
    public int consultarNumero() {
        return this.iTelefono;
    }

    @Override
    public void marcar() {
        setEstaLlamando(true);
    }

    @Override
    public void colgar() {
        setEstaLlamando(false);
    }

    @Override
    public void activarAltavoz() {
        setAltavozEncendido(true);
    }

    @Override
    public void desactivarAltavoz() {
        setAltavozEncendido(false);
    }

    @Override
    public boolean sonarTimbre() {
        return isEstaLlamando();
    }
}
