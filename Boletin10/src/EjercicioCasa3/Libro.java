package EjercicioCasa3;

public class Libro extends Publicacion {
    private String sTitulo;

    public Libro(int iCodigo, String sAutor, String sTitulo, short shPubicacion){
        super(iCodigo, sAutor, sTitulo, shPubicacion);
    }
}
