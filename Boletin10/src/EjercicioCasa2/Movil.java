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
        return "MOVIL: Llamando";
    }

    @Override
    public String colgar() {
        setEstaLlamando(false);
        return "MOVIL: Colgado";
    }

    @Override
    public String activarAltavoz() {
        setAltavozEncendido(true);
        return "MOVIL: Altavoz activado";
    }

    @Override
    public String desactivarAltavoz() {
        setAltavozEncendido(false);
        return "MOVIL: Altavoz desactivado";
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

    @Override
    public String imprimir(){
        String salida = "";
        salida += "Movil: \n"+super.imprimir();
        return salida;
    }
}
