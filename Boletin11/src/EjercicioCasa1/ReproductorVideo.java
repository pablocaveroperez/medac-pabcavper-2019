package EjercicioCasa1;

import EjercicioClase1.ReproductorPortatil;

public class ReproductorVideo extends ReproductorPortatil implements IReproductorVideo {
    private boolean reproduceWMV, reproduceDIVX, reproduceMPG, reproduceDVD, reproduceJPG;
    private float tamanioDeLaPantalla;
    private boolean television;


    public ReproductorVideo(String marca, String modelo, byte tipoDeAlmacenamiento) {
        super(marca, modelo, tipoDeAlmacenamiento);
    }

    public boolean isReproduceWMV() {
        return reproduceWMV;
    }

    public void setReproduceWMV(boolean reproduceWMV) {
        this.reproduceWMV = reproduceWMV;
    }

    public boolean isReproduceDIVX() {
        return reproduceDIVX;
    }

    public void setReproduceDIVX(boolean reproduceDIVX) {
        this.reproduceDIVX = reproduceDIVX;
    }

    public boolean isReproduceMPG() {
        return reproduceMPG;
    }

    public void setReproduceMPG(boolean reproduceMPG) {
        this.reproduceMPG = reproduceMPG;
    }

    public boolean isReproduceDVD() {
        return reproduceDVD;
    }

    public void setReproduceDVD(boolean reproduceDVD) {
        this.reproduceDVD = reproduceDVD;
    }

    public boolean isReproduceJPG() {
        return reproduceJPG;
    }

    public void setReproduceJPG(boolean reproduceJPG) {
        this.reproduceJPG = reproduceJPG;
    }

    public float getTamanioDeLaPantalla() {
        return tamanioDeLaPantalla;
    }

    public boolean setTamanioDeLaPantalla(float tamanioDeLaPantalla) {
        boolean bExito = false;
        if (tamanioDeLaPantalla > 0){
            this.tamanioDeLaPantalla = tamanioDeLaPantalla;
            bExito = true;
        }
        return bExito;
    }

    public boolean isTelevision() {
        return television;
    }

    public void setTelevision(boolean television) {
        this.television = television;
    }
}
