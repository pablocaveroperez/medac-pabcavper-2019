package EjercicioCasa4;

public interface IExpendedora {

    int getiNumeroSerie();

    void setiNumeroSerie(int iNumeroSerie);

    float getiCreditoAcumulado();

    void setiCreditoAcumulado(float iCreditoAcumulado);

    float getiCreditoConsumido();

    void setiCreditoConsumido(float iCreditoConsumido);

    double getiDineroAcumulado();

    void setiDineroAcumulado(double iDineroAcumulado);

    public void insertarMoneda(float valorMoneda);

    public void pedirProducto(float costeProducto);

    public void devolucionCreditoRestante();
}
