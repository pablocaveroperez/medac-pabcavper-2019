package Problema4;

public class MaquinaExpendedora {
    private int iNumeroSerie;
    private int iCreditoAcumulado;
    private int iCreditoConsumido;
    private int iDineroAcumulado;

    public MaquinaExpendedora(int iNumeroSerie){
        setiNumeroSerie(iNumeroSerie);
        setiCreditoConsumido(0);
        setiCreditoAcumulado(0);
        setiDineroAcumulado(0);
    }

    public int getiNumeroSerie() {
        return iNumeroSerie;
    }

    public void setiNumeroSerie(int iNumeroSerie) {
        this.iNumeroSerie = iNumeroSerie;
    }

    public int getiCreditoAcumulado() {
        return iCreditoAcumulado;
    }

    public void setiCreditoAcumulado(int iCreditoAcumulado) {
        this.iCreditoAcumulado = iCreditoAcumulado;
    }

    public int getiCreditoConsumido() {
        return iCreditoConsumido;
    }

    public void setiCreditoConsumido(int iCreditoConsumido) {
        this.iCreditoConsumido = iCreditoConsumido;
    }

    public int getiDineroAcumulado() {
        return iDineroAcumulado;
    }

    public void setiDineroAcumulado(int iDineroAcumulado) {
        this.iDineroAcumulado = iDineroAcumulado;
    }

    public void insertarMoneda(byte valorMoneda){
        setiCreditoAcumulado(getiCreditoAcumulado() + valorMoneda);
        System.out.println("Has insertado una moneda de "+valorMoneda+" en la maquina "+getiNumeroSerie());
    }

    public void pedirProducto(byte costeProducto){
        if (costeProducto <= getiCreditoAcumulado()) {
            setiCreditoConsumido(getiCreditoConsumido() + costeProducto);
            System.out.println("Has pedido el producto que cuesta "+costeProducto+" de la maquina "+getiNumeroSerie());
        }else
            System.out.println("El coste del producto es mayor que el credito acumulado de la maquina "+getiNumeroSerie()+". Inserta mas monedas o pide otro producto");
    }

    public int devolucionCreditoRestante(){
        int creditoRestante =  getiCreditoAcumulado() - getiCreditoConsumido();
        System.out.println("El creddito restante de la maquina "+getiNumeroSerie() +" es "+creditoRestante);
        return creditoRestante;
    }


}
