package Tienda.Modelos;

public class Carrito {
    private byte idCarrito;
    private LineaArticulo[] lineaArticulos;
    private final byte MAXLINEAARTICULOS = 100;
    private byte contadorCarrito;

    public Carrito() {
        lineaArticulos = new LineaArticulo[MAXLINEAARTICULOS];
        contadorCarrito = 0;
    }

    public LineaArticulo[] getLineaArticulos() {
        return lineaArticulos;
    }

    public byte getContadorCarrito() {
        return contadorCarrito;
    }

    public void setContadorCarrito(byte contadorCarrito) {
        this.contadorCarrito = contadorCarrito;
    }

    private void setIdCarrito(byte idCarrito) {

        this.idCarrito = idCarrito;
    }

    public byte getIdCarrito() {
        return idCarrito;
    }
}
