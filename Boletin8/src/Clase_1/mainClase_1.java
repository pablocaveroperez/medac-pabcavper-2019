package Clase_1;

public class mainClase_1 {
    public static void main(String[] args) {
        Producto vProductos[] = new Producto[3];
        vProductos[0] = new Producto("Cola-Cao", 2.4f,48);
        vProductos[1] = new Producto("Agua", 0.8f,200);
        vProductos[2] = new Producto("Zumito", 1.3f,20);

        for (int i = 0; i < vProductos.length; i++){
            System.out.println(vProductos[i]);
        }
    }
}
