package Problema4;

public class mainMaquinaExpendedora {
    public static void main(String[] args) {
        MaquinaExpendedora maquina1 = new MaquinaExpendedora(9999);

        maquina1.insertarMoneda((byte) 2);
        System.out.println(maquina1.getiCreditoAcumulado());
        maquina1.insertarMoneda(1);
        maquina1.insertarMoneda(0.5f);
        System.out.println(maquina1.getiCreditoAcumulado());

        maquina1.pedirProducto(0.75f);
        System.out.println(maquina1.getiCreditoAcumulado());
        maquina1.pedirProducto(1);
        System.out.println(maquina1.getiCreditoAcumulado());
        maquina1.pedirProducto(1.5f);

        System.out.println(maquina1.getiDineroAcumulado());

        maquina1.pedirProducto(1);
    }
}
