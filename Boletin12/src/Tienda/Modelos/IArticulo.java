package Tienda.Modelos;

public interface IArticulo {
    public boolean setPrecio(float precio);
    public void setNombre(String nombre);
    public float getPrecio();

    boolean setStock(short stock);

    int getStock();

    public String getNombre();
    public int getId();
}
