package Tienda.Modelos;

public interface ILineaArticulo {
    int getIdLineaArticulo();

    void setArticulo(Articulo articulo);

    boolean setCantidad(short cantidad);

    Articulo getArticulo();

    short getCantidad();
}
