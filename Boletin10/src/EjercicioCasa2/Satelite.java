package EjercicioCasa2;

public class Satelite extends Telefono implements ITelefono {
    public Satelite(int iTelefono) {
        super(iTelefono);
    }

    @Override
    public int consultarNumero() {
        return this.iTelefono;
    }

    @Override
    public String marcar() {
        setEstaLlamando(true);
        return "SATELITE: Llamando" ;
    }

    @Override
    public String colgar() {
        setEstaLlamando(false);
        return "SATELITE: Colgado";
    }

    @Override
    public String activarAltavoz() {
        setAltavozEncendido(true);
        return "SATELITE: Altavoz activado";
    }

    @Override
    public String desactivarAltavoz() {
        setAltavozEncendido(false);
        return "SATELITE: Altavoz desactivado";
    }

    @Override
    public boolean sonarTimbre() {
        return isEstaLlamando();
    }

    public String imprimir(){
        String salida = "";
        salida += "SATELITE: \n";
        return salida;
    }
}
