package EjercicioCasa3;

public class Articulo {
    private int idArticulo;
    private int tamanio;
    private int stock;
    private String nombre;
    private String descripcion;
    private Catalogo catalogo;

    public Articulo(){

    }

    public Articulo(int idArticulo, int tamanio, int stock, String nombre, String descripcion){
        setIdArticulo(idArticulo);
        setTamanio(tamanio);
        setStock(stock);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    private void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getStock() {
        return stock;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "ID articulo: "+getIdArticulo()+"\n";
        salida += "Tamanio: "+getTamanio()+"\n";
        salida += "Stock: "+getStock()+"\n";
        salida += "Nombre: "+getNombre()+"\n";
        salida += "Descripcion: "+getDescripcion()+"\n";
        return salida;
    }
}
