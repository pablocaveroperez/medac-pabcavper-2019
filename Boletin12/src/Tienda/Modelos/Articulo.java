package Tienda.Modelos;

import java.util.Objects;

public class Articulo implements IArticulo {
    private int id;
    private String nombre;
    private float precio;
    private short stock;
    private byte idProveedor;

    public Articulo(int id, String nombre, float precio, short stock){
        setNombre(nombre);
        setPrecio(precio);
        setId(id);
        setStock(stock);
    }

    public Articulo(int id){
        setId(id);
    }
    
    @Override
    public byte getIdProveedor() {
		return idProveedor;
	}
    
    @Override
    public boolean setIdProveedor(byte idProveedor) {
    	boolean bExito = false;
		if (idProveedor > 0) {
			this.idProveedor = idProveedor;
			bExito = true;
		}
		return bExito;
	}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean setStock(short stock) {
        boolean bExito = false;
        if (stock > 0 && stock < 1000){
            this.stock = stock;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int getStock() {
        return stock;
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
        salida += "\nSTOCK: "+ getStock();
        salida += "\nID PROVEEDOR: " + getIdProveedor();
        return salida;
    }
}
