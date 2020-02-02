package EjercicioCasa3;

public class Descripcion {
    private String descripcion;

    public Descripcion(){

    }

    public Descripcion(String descripcion){

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "Descripcion: "+getDescripcion()+"\n";
        return salida;
    }
}
