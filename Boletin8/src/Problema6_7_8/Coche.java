package Problema6_7_8;

public class Coche {
    private String modelo;
    private String color;
    private boolean bolPinturaMetalizada;
    private String matricula;
    private short anioFabricacion;
    private boolean bolTodoRiesgo;

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
}
