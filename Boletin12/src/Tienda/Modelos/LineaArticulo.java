package Tienda.Modelos;

public class LineaArticulo {
    private byte idLineaArticulo;
    private Articulo articulo;
    private short cantidad;

    public LineaArticulo(Articulo articulo, short cantidad){
        setArticulo(articulo);
        setCantidad(cantidad);
    }

    public LineaArticulo(){
        setArticulo(null);
        setCantidad((short) 0);
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public short getCantidad() {
        return cantidad;
    }
}
