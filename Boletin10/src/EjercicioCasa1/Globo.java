package EjercicioCasa1;

public class Globo implements IAeronave {

    private String id;
    private int altura=0;
    private byte bEstado;



    public Globo(String identificacion) {
        this.id=identificacion;
        mensaje("Preparado para dar un paseo en globo");
        setbEstado(TIERRA);
    }

    public void setbEstado(byte bEstado) {
        this.bEstado = bEstado;
    }

    public byte getbEstado() {
        return bEstado;
    }

    public void calentarAire(int segundos){
        mensaje("Calentando aire durante " + segundos + " segundos");
    }

    public void expulsarAire(int segundos){
        mensaje("Expulsando aire durante " + segundos + " segundos");
    }

    @Override
    public void aumentarAlturaDeVuelo(int aumento){
        mensaje("Incrementando altura de vuelo en " + aumento + " pies");
        variarAlturaDeVuelo(obtenerAlturaDeVuelo()+aumento);
    }

    @Override
    public void disminuirAlturaDeVuelo(int descenso){
        mensaje("Disminuyendo la altura de vuelo en " + descenso + " pies");
        variarAlturaDeVuelo(obtenerAlturaDeVuelo()-descenso);
    }

    @Override
    public int obtenerAlturaDeVuelo(){
        return altura;
    }

    @Override
    public void variarAlturaDeVuelo(int altura){
        if(obtenerAlturaDeVuelo() < altura)
            calentarAire(altura - obtenerAlturaDeVuelo());
        else if(obtenerAlturaDeVuelo() > altura)
            expulsarAire(obtenerAlturaDeVuelo() - altura);

        this.altura = altura;
        mensaje("Altura de vuelo establecida en " + obtenerAlturaDeVuelo() +
                " pies");
    }

    @Override
    public void despegar(){
        mensaje("?Preparaos para despegar!");
        aumentarAlturaDeVuelo(150);
        mensaje("?Ya estamos en el aire!");
        setbEstado(VOLANDO);
    }

    @Override
    public void aterrizar(){
        mensaje("Vamos a aterrizar !Agarraos!");
        variarAlturaDeVuelo(0);
        mensaje("Ya estamos en tierra firme");
        setbEstado(TIERRA);
    }

    @Override
    public String obtenerIdentificacion(){
        return id;
    }

    @Override
    public void establecerIdentificacion(String identificacion){
        mensaje("Cambio de n?mero de vuelo a" + identificacion);
        id = identificacion;
    }

    @Override
    public String consultarEstado() {
        String salida = "";
        if (bEstado == VOLANDO)
            salida += "El globo esta volando";
        else
            salida += "El globo esta en tierra";
        return salida;
    }


    private void mensaje(String informacion){
        System.out.println( "Globo - Vuelo " +
                obtenerIdentificacion() + ":" + informacion);
    }

}
