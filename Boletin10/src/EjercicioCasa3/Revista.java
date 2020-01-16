package EjercicioCasa3;

public class Revista extends Publicacion {
    private String sTitulo;

    public Revista(int iCodigo, String sAutor, String sTitulo, short shPubicacion){
        super(iCodigo, sAutor, sTitulo, shPubicacion);
    }

    public String imprimir(){
        String salida = "";
        salida += "Propiedades Revista:\n";
        salida += super.imprimir();
        return salida;
    }
}
