package EjercicioCasa3;

public class Publicacion implements IPublicacion {
    protected int iCodigo;
    protected String sAutor;
    protected String sTitulo;
    protected short shPubicacion;
    protected boolean estaPrestado;

    public Publicacion(int iCodigo, String sAutor, String sTitulo, short shPubicacion){
        setAutor(sAutor);
        setCodigo(iCodigo);
        setshPubicacion(shPubicacion);
        setTitulo(sTitulo);
        setEstaPrestado(false);
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
