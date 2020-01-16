package EjercicioCasa3;

public class Publicacion implements IPublicacion {
    protected int iCodigo;
    protected String sAutor;
    protected String sTitulo;
    protected short shPubicacion;
    protected boolean estaPrestado;

    public Publicacion(){

    }


    @Override
    public int getCodigo() {
        return this.iCodigo;
    }

    @Override
    public void setCodigo(int iCodigo) {

    }

    @Override
    public String getAutor() {
        return this.sAutor;
    }

    @Override
    public void setAutor(String sAutor) {

    }

    @Override
    public String getTitulo() {
        return this.sTitulo;
    }

    @Override
    public void setTitulo(String sTitulo) {

    }

    @Override
    public short getshPublicacion() {
        return this.shPubicacion;
    }

    @Override
    public void setshPublicacion(short shPublicacion) {

    }

    @Override
    public boolean getEstaPrestado() {
        return this.estaPrestado;
    }

    @Override
    public void setEstaPrestado(boolean estaPrestado) {

    }
}
