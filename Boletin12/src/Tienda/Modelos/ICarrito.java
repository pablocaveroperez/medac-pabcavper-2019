package Tienda.Modelos;

public interface ICarrito {
    LineaArticulo[] getLineaArticulos();

    byte getArticulosCarrito();

    void setArticulosCarrito(byte articulosCarrito);

    byte getIdCarrito();
}
