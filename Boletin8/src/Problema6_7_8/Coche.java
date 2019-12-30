package Problema6_7_8;

public class Coche {
    private String modelo;
    private String color;
    private boolean bolPinturaMetalizada;
    private String matricula;
    private short anioFabricacion;
    private boolean bolTodoRiesgo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String tipo;

    private final String MINI = "MINI";
    private final String UTILITARIO = "UTILITARIO";
    private final String FAMILIAR = "FAMILIAR";
    private final String DEPORTIVO = "DEPORTIVO";

    public Coche(String modelo, String color, boolean bolPinturaMetalizada, String matricula, short anioFabricacion, boolean bolTodoRiesgo) {
        this.modelo = modelo;
        this.color = color;
        this.bolPinturaMetalizada = bolPinturaMetalizada;
        this.matricula = matricula;
        this.anioFabricacion = anioFabricacion;
        this.bolTodoRiesgo = bolTodoRiesgo;
    }

    public Coche(){

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBolPinturaMetalizada() {
        return bolPinturaMetalizada;
    }

    public void setBolPinturaMetalizada(boolean bolPinturaMetalizada) {
        this.bolPinturaMetalizada = bolPinturaMetalizada;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public short getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(short anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public boolean isBolTodoRiesgo() {
        return bolTodoRiesgo;
    }

    public void setBolTodoRiesgo(boolean bolTodoRiesgo) {
        this.bolTodoRiesgo = bolTodoRiesgo;
    }

    public String imprimeCoche(){
        String salida = "";
        salida += "El coche "+getModelo()+" es de color "+getColor();
        return salida;
    }
}
