package Club.Modelos;

import java.util.Objects;

public class Socio implements ISocio {
    private int id;
    private String sDni;
    private String sNombre;
    private String sApellidos;
    private String sTelefono;
    private String sEmail;

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
    public String getsTelefono() {
        return sTelefono;
    }

    @Override
    public void setsTelefono(String sTelefono) {
        this.sTelefono = sTelefono;
    }

    @Override
    public String getsEmail() {
        return sEmail;
    }

    @Override
    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return id == socio.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
