package EjercicioCasa1;

import EjercicioClase1.ReproductorPortatil;

public class ReproductorVideo extends ReproductorPortatil implements IReproductorVideo {
    private boolean reproduceWMV, reproduceDIVX, reproduceMPG, reproduceDVD, reproduceJPG;
    private float tamanioDeLaPantalla;
    private boolean television;


    public ReproductorVideo(String marca, String modelo, byte tipoDeAlmacenamiento) {
        super(marca, modelo, tipoDeAlmacenamiento);
    }

    @Override
    public boolean isReproduceWMV() {
        return reproduceWMV;
    }

    @Override
    public void setReproduceWMV(boolean reproduceWMV) {
        this.reproduceWMV = reproduceWMV;
    }

    @Override
    public boolean isReproduceDIVX() {
        return reproduceDIVX;
    }

    @Override
    public void setReproduceDIVX(boolean reproduceDIVX) {
        this.reproduceDIVX = reproduceDIVX;
    }

    @Override
    public boolean isReproduceMPG() {
        return reproduceMPG;
    }

    @Override
    public void setReproduceMPG(boolean reproduceMPG) {
        this.reproduceMPG = reproduceMPG;
    }

    @Override
    public boolean isReproduceDVD() {
        return reproduceDVD;
    }

    @Override
    public void setReproduceDVD(boolean reproduceDVD) {
        this.reproduceDVD = reproduceDVD;
    }

    @Override
    public boolean isReproduceJPG() {
        return reproduceJPG;
    }

    @Override
    public void setReproduceJPG(boolean reproduceJPG) {
        this.reproduceJPG = reproduceJPG;
    }

    @Override
    public float getTamanioDeLaPantalla() {
        return tamanioDeLaPantalla;
    }

    @Override
    public boolean setTamanioDeLaPantalla(float tamanioDeLaPantalla) {
        boolean bExito = false;
        if (tamanioDeLaPantalla > 0){
            this.tamanioDeLaPantalla = tamanioDeLaPantalla;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean isTelevision() {
        return television;
    }

    @Override
    public void setTelevision(boolean television) {
        this.television = television;
    }

    @Override
    public String toString (){
        String salida = "";

        return salida;
    }
}
