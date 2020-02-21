package Tienda.Modelos;

import java.util.Objects;

public class Articulo implements IArticulo {
    private int id;
    private String nombre;
    private float precio;

    public Articulo(int id, String nombre, float precio){
        setNombre(nombre);
        setPrecio(precio);
        setId(id);
    }

    public Articulo(int id){
        setId(id);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public float getPrecio() {
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean setPrecio(float precio) {
        boolean bExito = false;
        if (precio > 0 && precio < 500){
            this.precio = precio;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Articulo articulo = (Articulo) o;
        return id == articulo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "*************************";
        salida += "\nID ARTICULO: "+ getId();
        salida += "\nNOMBRE: "+ getNombre();
        salida += "\nPRECIO: "+ getPrecio();
        return salida;
    }
}
