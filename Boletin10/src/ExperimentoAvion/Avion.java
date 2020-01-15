package ExperimentoAvion;

public class Avion implements IAeronave{
    private int altura;
    private String id;
    private boolean trenAbierto;

    public Avion(String identificacion) {
        setId(identificacion);
        setAltura(0);
        setTrenAbierto(true);
        mensaje("Preparado para recibir plan de vuelo");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public boolean isTrenAbierto() {
        return trenAbierto;
    }

    public void setTrenAbierto(boolean trenAbierto) {
        this.trenAbierto = trenAbierto;
    }

    public String aumentarAlturaDeVuelo(int aumento) {
        setAltura(this.altura + aumento);
        return mensaje("Incrementando altura de vuelo en " + aumento + " pies");
    }

    public String disminuirAlturaDeVuelo(int descenso) {
        setAltura(this.altura - descenso);
        return mensaje("Disminuyendo la altura de vuelo en " + descenso + " pies");
    }

    public String despegar() {
        String sResultado = "";
        sResultado += mensaje("Procediendo a realizar la maniobra de despegue");
        aumentarAlturaDeVuelo(150);
        setTrenAbierto(false);
        aumentarAlturaDeVuelo(1000);
        sResultado += mensaje("Maniobra de despegue concluida");
        return sResultado;
    }

    public String aterrizar() {
        String sResultado = "";
        sResultado += mensaje("Procediendo a realizar la maniobra de aterrizaje");
        setAltura(200);
        setTrenAbierto(true);
        disminuirAlturaDeVuelo(0);
        sResultado += mensaje("Maniobra de aterrizaje concluida");
        return sResultado;
    }

    private String mensaje(String informacion) {
        return "Airbus340 - Vuelo " + getId() + ":" + informacion + "\n";
    }

}

