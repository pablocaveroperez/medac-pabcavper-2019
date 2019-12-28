package Problema4;

public class mainMaquinaExpendedora {
    public static void main(String[] args) {
        MaquinaExpendedora maquina1 = new MaquinaExpendedora(9999);

        maquina1.insertarMoneda((byte) 2);
        System.out.println(maquina1.getiCreditoAcumulado());
    }
}
