package EjercicioCasa3;

public class Publicacion implements IPublicacion, IPrestable, IConsultable {
    protected int iCodigo;
    protected String sAutor;
    protected String sTitulo;
    protected short shPubicacion;
    protected boolean estaPrestado;
    protected boolean esConsultado;

    public Publicacion(int iCodigo, String sAutor, String sTitulo, short shPubicacion){
        setAutor(sAutor);
        setCodigo(iCodigo);
        setshPubicacion(shPubicacion);
        setTitulo(sTitulo);
        setPrestado(false);
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
    public void setPrestado(boolean bPrestado) {
        if (!estaConsultando())
            this.estaPrestado = bPrestado;
    }

    @Override
    public void setEsConsultado(boolean esConsultado) {
        if (!(estaPrestado()))
            this.esConsultado = esConsultado;
    }

    @Override
    public void prestar() {
        setPrestado(true);
    }

    @Override
    public void devolver() {
        setPrestado(false);
    }

    @Override
    public boolean estaPrestado() {
        return estaPrestado;
    }

    @Override
    public void retirar() {
        setEsConsultado(true);
    }

    @Override
    public void devolverConsul() {
        setEsConsultado(false);
    }

    @Override
    public boolean estaConsultando() {
        return esConsultado;
    }

    protected String imprimir(){
        String salida = "";
        salida += "Codigo: "+getCodigo()+"\n";
        salida += "Autor: "+getAutor()+"\n";
        salida += "Titulo: "+getTitulo()+"\n";
        salida += "Pubicacion: "+getshPubicacion()+"\n";
        salida += "Estado: ";
        if (estaPrestado())
            salida += "Prestado";
        else
            salida += "No prestado";
        salida += "\nConsultando: ";
        if (estaConsultando())
            salida += "Si";
        else
            salida += "No";
        return salida+"\n";
    }
}
