package EjercicioCasa3;

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

    private static Articulo[] llenarVectorArticulo() {
        int iTamanio;
        Articulo[] iVector = new Articulo[iTamanio];
        for(int iContador = 0; iContador < iVector.length; iContador++) {
            iVector[iContador] = new Articulo();
        }
        return iVector;
    }
}
