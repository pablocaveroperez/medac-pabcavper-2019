package Club.Modelos;

public class Socio implements ISocio{
    private int id;
    private String sDni;
    private String sNombre;
    private String sApellidos;

    public Socio(int id, String sDni, String sNombre, String sApellidos){
        setId(id);
        setsDni(sDni);
        setsNombre(sNombre);
        setsApellidos(sApellidos);
    }

    public Socio(int id){
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsDni() {
        return sDni;
    }

    public void setsDni(String sDni) {
        this.sDni = sDni;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsApellidos() {
        return sApellidos;
    }

    public void setsApellidos(String sApellidos) {
        this.sApellidos = sApellidos;
    }
}
