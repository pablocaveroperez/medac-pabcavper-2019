package Club.Modelos;

public class Socio implements ISocio {
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

    @Override
    public int getId() {
        return id;
    }

    private boolean setId(int id) {
        boolean bExito = false;
        if (id > 0){
            this.id = id;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public String getsDni() {
        return sDni;
    }

    @Override
    public void setsDni(String sDni) {
        this.sDni = sDni;
    }

    @Override
    public String getsNombre() {
        return sNombre;
    }

    @Override
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    @Override
    public String getsApellidos() {
        return sApellidos;
    }

    @Override
    public void setsApellidos(String sApellidos) {
        this.sApellidos = sApellidos;
    }
}
