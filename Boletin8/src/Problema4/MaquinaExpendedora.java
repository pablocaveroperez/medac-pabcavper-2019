package Problema4;

public class MaquinaExpendedora {
    private int iNumeroSerie;
    private float iCreditoAcumulado;
    private float iCreditoConsumido;
    private double iDineroAcumulado;

    public MaquinaExpendedora(int iNumeroSerie){
        setiNumeroSerie(iNumeroSerie);
        setiCreditoConsumido(0);
        setiCreditoAcumulado(0);
        setiDineroAcumulado(0);
    }

    public int getiNumeroSerie() {
        return iNumeroSerie;
    }

    private void setiNumeroSerie(int iNumeroSerie) {
        this.iNumeroSerie = iNumeroSerie;
    }

    public float getiCreditoAcumulado() {
        return iCreditoAcumulado - getiCreditoConsumido();
    }

    private void setiCreditoAcumulado(float iCreditoAcumulado) {
        this.iCreditoAcumulado = iCreditoAcumulado;
    }

    public float getiCreditoConsumido() {
        return iCreditoConsumido;
    }

    private void setiCreditoConsumido(float iCreditoConsumido) {
        this.iCreditoConsumido = iCreditoConsumido;
    }

    public double getiDineroAcumulado() {
        return iDineroAcumulado;
    }

    private void setiDineroAcumulado(double iDineroAcumulado) {
        this.iDineroAcumulado = iDineroAcumulado;
    }

    public void insertarMoneda(float valorMoneda){
        setiCreditoAcumulado(getiCreditoAcumulado() + valorMoneda);
        System.out.println("Has insertado una moneda de "+valorMoneda+" en la maquina "+getiNumeroSerie());
    }

    public void pedirProducto(float costeProducto){
        if (costeProducto <= getiCreditoAcumulado()) {
            setiCreditoConsumido(getiCreditoConsumido() + costeProducto);
            setiDineroAcumulado(getiCreditoConsumido());
            System.out.println("Has pedido el producto que cuesta "+costeProducto+" de la maquina "+getiNumeroSerie());
        }else
            System.out.println("El coste del producto es mayor que el credito acumulado de la maquina "+getiNumeroSerie()+". Inserta mas monedas o pide otro producto");
    }

    public void devolucionCreditoRestante(){
        float creditoRestante =  getiCreditoAcumulado() - getiCreditoConsumido();
        System.out.println("El creddito restante de la maquina "+getiNumeroSerie() +" es "+creditoRestante);
        System.exit(0);
    }


}
