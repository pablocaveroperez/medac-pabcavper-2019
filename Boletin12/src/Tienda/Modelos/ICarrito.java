package Tienda.Modelos;

public interface ICarrito {
    LineaArticulo[] getLineaArticulos();

    byte getContadorCarrito();

    void setContadorCarrito(byte contadorCarrito);

    byte getIdCarrito();
}
