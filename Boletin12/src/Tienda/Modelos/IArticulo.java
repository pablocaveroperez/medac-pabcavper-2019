package Tienda.Modelos;

public interface IArticulo {
    public boolean setPrecio(double precio);
    public boolean setNombre(String nombre);
    public double getPrecio();
    public String getNombre();
    public int getId();
}
