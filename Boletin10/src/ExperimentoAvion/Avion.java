package ExperimentoAvion;

public abstract class Avion implements IAeronave{
    private int iAltura;
    private String sId;
    private boolean trenAbierto;

    public Avion(int iAltura, String sId) {
        this.setiAltura(iAltura);
        this.sId = sId;
    }

    public void setiAltura(int iAltura) {
        this.iAltura = iAltura;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public void setTrenAbierto(boolean trenAbierto) {
        this.trenAbierto = trenAbierto;
    }

    public int getiAltura() {
        return iAltura;
    }

    public String getsId() {
        return sId;
    }
}
