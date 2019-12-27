package Problema2;

public class mainPunto {
    public static void main(String[] args) {
        Punto punto1 = new Punto();
        Punto punto2 = new Punto();

        punto1.setX(5.3);
        punto1.setY(2);

        System.out.println(punto1);

        punto1.borrar();
        System.out.println(punto1);

        punto1.mover(3,4.1);
        System.out.println(punto1);

        punto2.mover(15,3);
        punto1.mover(punto2);
        System.out.println(punto1);

        punto1.mover(6,2);
        System.out.println(punto1.distancia(punto2));
    }
}
