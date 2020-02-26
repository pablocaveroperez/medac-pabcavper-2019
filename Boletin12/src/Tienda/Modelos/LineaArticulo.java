package Tienda.Modelos;

public class LineaArticulo implements ILineaArticulo {
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

    @Override
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public boolean setCantidad(short cantidad) {
        boolean bExito = false;
        if (cantidad > 0 && cantidad < getArticulo().getStock()){
            this.cantidad = cantidad;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public Articulo getArticulo() {
        return articulo;
    }

    @Override
    public short getCantidad() {
        return cantidad;
    }

    public String toString() {
        String salida = "";
        salida += articulo.toString();
        salida += "\nCantidad seleccionada: " + getCantidad();
        return salida;
    }
}
