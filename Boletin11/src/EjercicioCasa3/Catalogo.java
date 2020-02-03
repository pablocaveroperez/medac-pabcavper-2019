package EjercicioCasa3;

import static EjercicioCasa3.ValidaLibrary.*;

public class Catalogo {
    private int autoincremento;
    private Articulo[] articulos;

    public Catalogo(){

    }

    public Articulo[] getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulo[] articulos) {
        this.articulos = articulos;
    }

    public int getAutoincremento() {
        return autoincremento;
    }

    public void setAutoincremento(int autoincremento) {
        this.autoincremento = autoincremento;
    }

    public static Articulo[] llenarVectorArticulo() {
        int iTamanio = (int) valida("Introduce el tamanio del vector (2-100): ",0,5,1);
        Articulo[] iVector = new Articulo[iTamanio];
        for(int iContador = 0; iContador < iVector.length; iContador++) {
            iVector[iContador] = new Articulo((int)valida("Introduce idArticulo: ",0,5,1),(int)valida("Introduce el tamanio del articulo: ",0,50,1),(int)valida("Introduce el stock del articulo: ",
                    0,100,1),leer("Introduce el nombre del articulo"),leer("Introduce la descripcion del articulo: "));
        }
        return iVector;
    }

    public void addArticulo(Articulo articulo){
        Articulo[] aux = new Articulo[getArticulos().length+1];
        for (int i = 0; i < aux.length;i++){
            if (i < getArticulos().length)
                aux[i] = getArticulos()[i];
            else
                aux[i] = articulo;
        }
        setArticulos(aux);
    }

}
