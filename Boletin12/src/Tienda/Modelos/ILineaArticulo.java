package Tienda.Modelos;

public interface ILineaArticulo {
    void setArticulo(Articulo articulo);

    boolean setCantidad(short cantidad);

    Articulo getArticulo();

    short getCantidad();
}
