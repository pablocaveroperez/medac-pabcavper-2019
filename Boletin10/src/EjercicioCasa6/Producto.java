package EjercicioCasa6;

public class Producto implements IProducto{
    private String nombre;
    private float precio;
    private int unidades;
    private final int PRECIO_MAXIMO = 1000000;

    public Producto(String nombre, float precio, int unidades) {
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setUnidades(unidades);
    }

    public float valorEnStock() {
        return unidades * precio;
    }

    public void incrementarStock(int incremento) {
        unidades = unidades + incremento;
    }

    public void disminuirStock(int decremento) {
        unidades = unidades - decremento;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidades(int unidades) {
        if(unidades > 0) {
            this.unidades = unidades;
        }
    }

    public void setPrecio(float precio) {
        if (precio > 0 && precio < PRECIO_MAXIMO)
            this.precio = precio;
    }

    public String toString() {
        String sResultado = "";
        sResultado += "Nombre: " + this.getNombre() + "\n";
        sResultado += "Precio: " + this.getPrecio() + "\n";
        sResultado += "Unidades: " + this.getUnidades() + "\n";
        return sResultado;
    }
}