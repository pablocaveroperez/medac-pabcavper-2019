package EjercicioCasa3;

public class Revista extends Publicacion implements IPublicacion {
    private String sNombreRevista;

    public Revista(int iCodigo, String sNombreRevista, String sAutor, String sTitulo, short shPubicacion){
        super(iCodigo, sAutor, sTitulo, shPubicacion);
        setsNombreRevista(sNombreRevista);
    }

    public void setsNombreRevista(String sNombreRevista) {
        this.sNombreRevista = sNombreRevista;
    }

    public String getsNombreRevista() {
        return sNombreRevista;
    }

    @Override
    public int getCodigo() {
        return this.iCodigo;
    }

    @Override
    public boolean setCodigo(int iCodigo) {
        boolean bExito = false;
        if (iCodigo > 0){
            this.iCodigo = iCodigo;
            bExito = false;
        }
        return bExito;
    }

    @Override
    public String getAutor() {
        return this.sAutor;
    }

    @Override
    public void setAutor(String sAutor) {
        this.sAutor = sAutor;
    }

    @Override
    public String getTitulo() {
        return this.sTitulo;
    }

    @Override
    public void setTitulo(String sTitulo) {
        this.sTitulo = sTitulo;
    }

    @Override
    public short getshPubicacion() {
        return this.shPubicacion;
    }

    @Override
    public boolean setshPubicacion(short shPubicacion) {
        boolean bExito = false;
        if (shPubicacion > 0){
            this.shPubicacion = shPubicacion;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean getEstaPrestado() {
        return this.estaPrestado;
    }

    @Override
    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }
}
