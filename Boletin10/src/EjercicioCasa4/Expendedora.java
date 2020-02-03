package EjercicioCasa4;

public class Expendedora implements IExpendedora {
    private int iNumeroSerie;
    private float iCreditoAcumulado;
    private float iCreditoConsumido;
    private double iDineroAcumulado;

    public Expendedora(int iNumeroSerie){
        setiNumeroSerie(iNumeroSerie);
        setiCreditoConsumido(0);
        setiCreditoAcumulado(0);
        setiDineroAcumulado(0);
    }

    @Override
    public int getiNumeroSerie() {
        return iNumeroSerie;
    }

    @Override
    public void setiNumeroSerie(int iNumeroSerie) {
        this.iNumeroSerie = iNumeroSerie;
    }

    @Override
    public float getiCreditoAcumulado() {
        return iCreditoAcumulado - getiCreditoConsumido();
    }

    @Override
    public void setiCreditoAcumulado(float iCreditoAcumulado) {
        this.iCreditoAcumulado = iCreditoAcumulado;
    }

    @Override
    public float getiCreditoConsumido() {
        return iCreditoConsumido;
    }

    @Override
    public void setiCreditoConsumido(float iCreditoConsumido) {
        this.iCreditoConsumido = iCreditoConsumido;
    }

    @Override
    public double getiDineroAcumulado() {
        return iDineroAcumulado;
    }

    @Override
    public void setiDineroAcumulado(double iDineroAcumulado) {
        this.iDineroAcumulado = iDineroAcumulado;
    }

    @Override
    public void insertarMoneda(float valorMoneda){
        setiCreditoAcumulado(getiCreditoAcumulado() + valorMoneda);
        System.out.println("Has insertado una moneda de "+valorMoneda+" en la maquina "+getiNumeroSerie());
    }

    @Override
    public void pedirProducto(float costeProducto){
        if (costeProducto <= getiCreditoAcumulado()) {
            setiCreditoConsumido(getiCreditoConsumido() + costeProducto);
            setiDineroAcumulado(getiCreditoConsumido());
            System.out.println("Has pedido el producto que cuesta "+costeProducto+" de la maquina "+getiNumeroSerie());
        }else
            System.out.println("El coste del producto es mayor que el credito acumulado de la maquina "+getiNumeroSerie()+". Inserta mas monedas o pide otro producto");
    }

    @Override
    public void devolucionCreditoRestante(){
        float creditoRestante =  getiCreditoAcumulado();
        System.out.println("El creddito restante de la maquina "+getiNumeroSerie() +" es "+creditoRestante);
        System.exit(0);
    }
}
