package ExperimentoAvion;

public class AvionComercial extends Avion {
    private int pasajeros;

    public AvionComercial(String id, int pasajeros){
        super(id);
        setPasajeros(pasajeros);
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getPasajeros() {
        return pasajeros;
    }
}
