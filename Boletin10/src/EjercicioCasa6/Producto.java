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

    @Override
    public float valorEnStock() {
        return unidades * precio;
    }

    @Override
    public void incrementarStock(int incremento) {
        unidades = unidades + incremento;
    }

    @Override
    public void disminuirStock(int decremento) {
        unidades = unidades - decremento;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public float getPrecio() {
        return precio;
    }

    @Override
    public int getUnidades() {
        return unidades;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setUnidades(int unidades) {
        if(unidades > 0) {
            this.unidades = unidades;
        }
    }

    @Override
    public void setPrecio(float precio) {
        if (precio > 0 && precio < PRECIO_MAXIMO)
            this.precio = precio;
    }

    @Override
    public String toString() {
        String sResultado = "";
        sResultado += "Nombre: " + this.getNombre() + "\n";
        sResultado += "Precio: " + this.getPrecio() + "\n";
        sResultado += "Unidades: " + this.getUnidades() + "\n";
        return sResultado;
    }
}