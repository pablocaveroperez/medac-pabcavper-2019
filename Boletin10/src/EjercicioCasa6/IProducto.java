package EjercicioCasa6;

public interface IProducto {

    public float valorEnStock();

    public void incrementarStock(int incremento) ;

    public void disminuirStock(int decremento) ;

    public String getNombre() ;

    public float getPrecio() ;

    public int getUnidades() ;

    public void setNombre(String nombre) ;

    public void setUnidades(int unidades) ;

    public void setPrecio(float precio) ;

    public String toString();
}
