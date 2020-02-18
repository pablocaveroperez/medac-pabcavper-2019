package Tienda.Modelos;

public interface IArticulo {
    public boolean setPrecio(float precio);
    public boolean setNombre(String nombre);
    public float getPrecio();
    public String getNombre();
    public int getId();
}
