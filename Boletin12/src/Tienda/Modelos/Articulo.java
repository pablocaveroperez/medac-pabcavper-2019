package Tienda.Modelos;

public class Articulo {
    private int id;
    private String nombre;
    private double precio;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    private boolean setId(int id) {
        boolean bExito = false;
        if (id > 0){
            this.id = id;
            bExito = true;
        }
        return bExito;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean setPrecio(double precio) {
        boolean bExito = false;
        if (precio > 0 && precio < 500){
            this.precio = precio;
            bExito = true;
        }
        return bExito;
    }
}
