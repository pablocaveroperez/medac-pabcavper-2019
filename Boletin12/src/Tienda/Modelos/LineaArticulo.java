package Tienda.Modelos;

public class LineaArticulo {
    private Articulo articulo;
    private int cantidad;

    public LineaArticulo() {

    }

    public LineaArticulo(Articulo articulo, int cantidad) {
        setArticulo(articulo);
        setCantidad(cantidad);
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String toString(){
        String salida = "";
        salida += getArticulo().toString();
        salida += "\nCantidad en el carrito: " + getCantidad()+"\n";
        return salida;
    }
}
