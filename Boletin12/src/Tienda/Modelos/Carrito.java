package Tienda.Modelos;

public class Carrito implements ICarrito {
    private byte idCarrito;
    private LineaArticulo[] lineaArticulos;
    private final byte MAXLINEAARTICULOS = 100;
    private byte contadorCarrito;

    public Carrito(byte idCarrito) {
        lineaArticulos = new LineaArticulo[MAXLINEAARTICULOS];
        contadorCarrito = 0;
        setIdCarrito(idCarrito);
    }

    @Override
    public LineaArticulo[] getLineaArticulos() {
        return lineaArticulos;
    }

    @Override
    public byte getContadorCarrito() {
        return contadorCarrito;
    }

    @Override
    public void setContadorCarrito(byte contadorCarrito) {
        this.contadorCarrito = contadorCarrito;
    }

    private boolean setIdCarrito(byte idCarrito) {
        boolean bExito = false;
        if (idCarrito > 0){
            this.idCarrito = idCarrito;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public byte getIdCarrito() {
        return idCarrito;
    }
}
