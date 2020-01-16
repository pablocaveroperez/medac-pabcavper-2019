package EjercicioCasa3;

public class Disco extends Publicacion {
    private String sTitulo;

    public Disco(int iCodigo, String sAutor, String sTitulo, short shPubicacion){
        super(iCodigo, sAutor, sTitulo, shPubicacion);
    }

    public String imprimir(){
        String salida = "";
        salida += "Propiedades Disco\n";
        salida += super.imprimir();
        return salida;
    }
}
