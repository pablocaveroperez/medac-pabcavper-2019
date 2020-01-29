package EjercicioCasa1;

public interface IReproductorVideo {
    boolean isReproduceWMV();

    void setReproduceWMV(boolean reproduceWMV);

    boolean isReproduceDIVX();

    void setReproduceDIVX(boolean reproduceDIVX);

    boolean isReproduceMPG();

    void setReproduceMPG(boolean reproduceMPG);

    boolean isReproduceDVD();

    void setReproduceDVD(boolean reproduceDVD);

    boolean isReproduceJPG();

    void setReproduceJPG(boolean reproduceJPG);

    float getTamanioDeLaPantalla();

    boolean setTamanioDeLaPantalla(float tamanioDeLaPantalla);

    boolean isTelevision();

    void setTelevision(boolean television);
}
