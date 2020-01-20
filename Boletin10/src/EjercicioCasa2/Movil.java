package EjercicioCasa2;

public class Movil extends Telefono implements ITelefono {
    public Movil(int iTelefono) {
        super(iTelefono);
    }

    @Override
    public int consultarNumero() {
        return this.iTelefono;
    }

    @Override
    public String marcar() {
        setEstaLlamando(true);
        return "Llamando" ;
    }

    @Override
    public String colgar() {
        setEstaLlamando(false);
        return "Colgado";
    }

    @Override
    public String activarAltavoz() {
        setAltavozEncendido(true);
        return "Altavoz activado";
    }

    @Override
    public String desactivarAltavoz() {
        setAltavozEncendido(false);
        return "Altavoz desactivado";
    }

    @Override
    public boolean sonarTimbre() {
        return isEstaLlamando();
    }

    public String imprimir(){
        String salida = "";
        salida += "Movil: \n";
        return salida;
    }
}
