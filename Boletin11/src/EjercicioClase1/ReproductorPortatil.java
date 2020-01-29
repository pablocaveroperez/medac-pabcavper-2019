package EjercicioClase1;

public class ReproductorPortatil implements IReproductorPortatil {
    private String marca;
    private String modelo;
    private boolean reproduceSonido, reproduceVideo;
    private byte tipoDeAlmacenamiento;
    private int capacidadDeAlmacenamiento; // MegaBytes
    private byte pantalla;
    private byte tipoDeBateria;
    private int autonomia; //   NUMERO DE HORAS DE AUTONOMIA
    private float peso; //  PESO EN GRAMOS DEL DISPOSITIVO
    private float ancho, alto, grosor; //   DIMENSIONES EN MILIMETROS DEL DISPOSITIVO

    public ReproductorPortatil(String marca, String modelo, byte tipoDeAlmacenamiento){
        setMarca(marca);
        setModelo(modelo);
        setTipoDeAlmacenamiento(tipoDeAlmacenamiento);
        setAlto(0);
        setAncho(0);
        setAutonomia(0);
        setCapacidadDeAlmacenamiento(0);
        setGrosor(0);
        setPantalla((byte) 0);
        setPeso(0);
        setReproduceSonido(false);
        setReproduceVideo(false);
        setTipoDeBateria((byte) 0);
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean isReproduceSonido() {
        return reproduceSonido;
    }

    @Override
    public void setReproduceSonido(boolean reproduceSonido) {
        this.reproduceSonido = reproduceSonido;
    }

    @Override
    public boolean isReproduceVideo() {
        return reproduceVideo;
    }

    @Override
    public void setReproduceVideo(boolean reproduceVideo) {
        this.reproduceVideo = reproduceVideo;
    }

    @Override
    public byte getTipoDeAlmacenamiento() {
        return tipoDeAlmacenamiento;
    }

    @Override
    public boolean setTipoDeAlmacenamiento(byte tipoDeAlmacenamiento) {
        boolean bExito = false;
        if (tipoDeAlmacenamiento >= 1 && tipoDeAlmacenamiento <= 4){
            this.tipoDeAlmacenamiento = tipoDeAlmacenamiento;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int getCapacidadDeAlmacenamiento() {
        return capacidadDeAlmacenamiento;
    }

    @Override
    public boolean setCapacidadDeAlmacenamiento(int capacidadDeAlmacenamiento) {
        boolean bExito = false;
        if (capacidadDeAlmacenamiento >= 0){
            this.capacidadDeAlmacenamiento = capacidadDeAlmacenamiento;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public byte getPantalla() {
        return pantalla;
    }

    @Override
    public boolean setPantalla(byte pantalla) {
        boolean bExito = false;
        if (pantalla >= 1 && pantalla <= 4){
            this.pantalla = pantalla;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public byte getTipoDeBateria() {
        return tipoDeBateria;
    }

    @Override
    public boolean setTipoDeBateria(byte tipoDeBateria) {
        boolean bExito = false;
        if (tipoDeBateria == PILAS || tipoDeBateria == LI_ION){
            this.tipoDeBateria = tipoDeBateria;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int getAutonomia() {
        return autonomia;
    }

    @Override
    public boolean setAutonomia(int autonomia) {
        boolean bExito = false;
        if (autonomia >= 0){
            this.autonomia = autonomia;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public float getPeso() {
        return peso;
    }

    @Override
    public boolean setPeso(float peso) {
        boolean bExito = false;
        if (peso > 0){
            this.peso = peso;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public float getAncho() {
        return ancho;
    }

    @Override
    public boolean setAncho(float ancho) {
        boolean bExito = false;
        if (ancho > 0){
            this.ancho = ancho;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public float getAlto() {
        return alto;
    }

    @Override
    public boolean setAlto(float alto) {
        boolean bExito = false;
        if (alto > 0){
            this.alto = alto;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public float getGrosor() {
        return grosor;
    }

    @Override
    public boolean setGrosor(float grosor) {
        boolean bExito = false;
        if (alto > 0){
            this.grosor = grosor;
            bExito = true;
        }
        return bExito;
    }

    private String almacenamientoTexto(){
        String salida = "";
        if (this.tipoDeAlmacenamiento == CD)
            salida += "CD";
        else if (this.tipoDeAlmacenamiento == DVD)
            salida += "DVD";
        else if (this.tipoDeAlmacenamiento == MEMORIAFLASH)
            salida += "MemoriaFlash";
        else if (this.tipoDeAlmacenamiento == MINIDISK)
            salida += "Minidisk";
        else
            salida += "Tipo de almacenamiento erroneo";
        return salida;
    }

    private String pantallaTexto(){
        String salida = "";
        if (this.pantalla == NINGUNA)
            salida += "NINGUNA";
        else if (this.pantalla == TEXTO)
            salida += "TEXTO";
        else if (this.pantalla == MONOCROMO)
            salida += "MONOCROMO";
        else if (this.pantalla == COLOR)
            salida += "COLOR";
        else
            salida += "Tipo de pantalla erroneo";
        return salida;
    }

    private String bateriaTexto() {
        String salida = "";
        if (this.tipoDeBateria == PILAS)
            salida += "PILAS";
        else if (this.tipoDeBateria == LI_ION)
            salida += "LI-ION";
        return salida;
    }

    @Override
    public String toString(){
        String salida = "";
        salida += "Marca: " + getMarca() + "\n";
        salida += "Modelo: " + getModelo() + "\n";
        salida += "Tipo de almacenamiento: " + almacenamientoTexto() + "\n";
        salida += "Capacidad de almacenamiento: " + getCapacidadDeAlmacenamiento() + "\n";
        salida += "Autonomia: " + getAutonomia() + "\n";
        salida += "Peso(g): " + getPeso() + "\n";
        salida += "Ancho(mm): " + getAncho() + "\n";
        salida += "Alto(mm): " + getAncho() + "\n";
        salida += "Grosor(mm): " + getAncho() + "\n";
        salida += "Pantalla: " + pantallaTexto() + "\n";
        salida += "Tipo de bateria: " + bateriaTexto() + "\n";
        salida += "Reproduciendo sonido: " + isReproduceSonido()+"\n";
        salida += "Reproduciendo video: " + isReproduceVideo()+"\n";
        return salida;
    }

}
