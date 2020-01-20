package EjercicioCasa2;

public class Fijo extends Telefono implements ITelefono {
    public Fijo(int iTelefono) {
        super(iTelefono);
    }

    @Override
    public int consultarNumero() {
        return this.iTelefono;
    }

    @Override
    public String marcar() {
        setEstaLlamando(true);
        return "FIJO: Llamando" ;
    }

    @Override
    public String colgar() {
        setEstaLlamando(false);
        return "FIJO: Colgado";
    }

    @Override
    public String activarAltavoz() {
        setAltavozEncendido(true);
        return "FIJO: Altavoz activado";
    }

    @Override
    public String desactivarAltavoz() {
        setAltavozEncendido(false);
        return "FIJO: Altavoz desactivado";
    }

    @Override
    public String sonarTimbre() {
        String salida = "";
        if (isEstaLlamando())
            salida += "Esta sonando el timbre";
        else
            salida += "No esta sonando el timbre";
        return salida;
    }

    public String imprimir(){
        String salida = "";
        salida += "FIJO: \n"+super.imprimir();
        return salida;
    }
}
