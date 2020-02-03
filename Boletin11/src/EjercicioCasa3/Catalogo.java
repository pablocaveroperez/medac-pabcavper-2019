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
}
