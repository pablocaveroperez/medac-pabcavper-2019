package EjercicioCasa7;



public class mainTarjeta {
    public static void simulaCompra(ITarjetaMonedero tarjetaMonedero){
        String DNI = Libreria.leer("Introduce el DNI: ");

        float importeCompra = (float) Libreria.valida("Introduce el importe de la compra: ",0,1000,2);

        tarjetaMonedero.comprar(importeCompra,DNI);
    }

    public static void simulaRetiradaCajero(ITarjetaCredito tarjetaCredito){
        int pin = (int)Libreria.valida("Introduce el pin: ",0,9999,1);
        float importeRetirar = (float) Libreria.valida("Introuce el imnporte a retirar: ",0,500,2);

        tarjetaCredito.retirarCajero(importeRetirar,pin);

    }

    public static void main(String[] args) {
        ITarjetaMonedero tm = new Tarjeta("01","29517020Q",1234,50);
        ITarjetaCredito tc = new Tarjeta("02","29517018Z",1234,150);
        Tarjeta t = new Tarjeta("03","28589926Y",1234,500);

        simulaCompra(tm);
        //simulaCompra(tc); No se puede llamar este metodo pasandole
        // una tarjeta de credito como parametro por que solo admite TarjetaMonedero
        simulaCompra(t);

        //simulaRetiradaCajero(tm); No se puede llamar este metodo pasandole
        // una tarjeta de monedero como parametro por que solo admite TarjetaCredito
        simulaRetiradaCajero(tc);
        simulaRetiradaCajero(t);

        Tarjeta tm2 = t;
        System.out.println(tm2.getDNITitular());
        System.out.println(tm2.getSaldo());

        ITarjetaCredito tc2 = t;

        System.out.println(tc2.getSaldo());
        System.out.println(tc2.getId());

    }
}
