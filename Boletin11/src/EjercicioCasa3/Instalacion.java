package EjercicioCasa3;

public class Instalacion {
    private int idInstalacion;
    private boolean estado;
    private String tipo;
    private String ubicacion;

    public Instalacion(int idInstalacion){
        setIdInstalacion(idInstalacion);
    }

    public int getIdInstalacion() {
        return idInstalacion;
    }

    private void setIdInstalacion(int idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
