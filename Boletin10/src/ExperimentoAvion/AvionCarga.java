package ExperimentoAvion;

public class AvionCarga extends Avion {
    private float carga;

    public AvionCarga(String id, float carga) {
        super(id);
        setCarga(carga);
    }

    public void setCarga(float carga) {
        this.carga = carga;
    }
}
