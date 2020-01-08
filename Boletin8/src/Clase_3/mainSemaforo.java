package Clase_3;

public class mainSemaforo {
    public static void main(String[] args) {
        // Paso 1
        Semaforo oSem1 = new Semaforo();
        Semaforo oSem2;
        System.out.println(oSem1.imprimir());
        // Paso 2
        oSem1.setiColor(5);
        System.out.println(oSem1.imprimir());
        // Paso 3
        oSem1.setiColor(3);
        System.out.println(oSem1.imprimir());
        // Paso 4
        oSem1.setbParpadeando(true);
        System.out.println(oSem1.imprimir());
        // Paso 5
        oSem1.setiColor(2);
        System.out.println(oSem1.imprimir());
        // Paso 6
        oSem1.setbParpadeando(true);
        System.out.println(oSem1.imprimir());
        // Paso 7
        for(int i=0; i < 5; i++) {
            oSem1.cambia();
            System.out.println(oSem1.imprimir());
        }

        // Paso 8
        System.out.println("SEMAFORO 2: ");
        oSem2 = new Semaforo();
        oSem2.setiColor(oSem1.getiColor());
        oSem2.setbParpadeando(oSem2.isbParpadeando());
        System.out.println(oSem2.imprimir());
    }
}
