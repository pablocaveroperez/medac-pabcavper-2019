package Tienda.Modelos;

public class Articulo implements IArticulo {
    private int id;
    private String nombre;
    private double precio;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
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

    @Override
    public boolean setNombre(String nombre) {
        boolean bExito = false;
        if (nombre.length() < 5){
            this.nombre = nombre;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean setPrecio(double precio) {
        boolean bExito = false;
        if (precio > 0 && precio < 500){
            this.precio = precio;
            bExito = true;
        }
        return bExito;
    }
}
