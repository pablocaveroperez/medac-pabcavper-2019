package ExperimentoAvion;

public class mainAvion {
    public static void main(String[] args) {
        IAeronave a = new AvionComercial("1234", 256);
        System.out.println(a.despegar());
        System.out.println(a.aterrizar());
    }

}
