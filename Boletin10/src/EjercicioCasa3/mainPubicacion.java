package EjercicioCasa3;

public class mainPubicacion {
    public static void main(String[] args) {
        Publicacion publicacion1 = new Libro(1,"Edu Aguirre", "Luna de Pluton", (short) 123);
        Publicacion publicacion2 = new Revista(2,"Edu Aguirre", "Chiringuito de jugones", (short) 123);
        Publicacion publicacion3 = new Disco(3,"Edu Aguirre", "CR7 campeon", (short) 123);

        publicacion1.setTitulo("Chiricirco de mamones");
        System.out.println(publicacion1.getTitulo());

        publicacion1.prestar();
        publicacion2.prestar();
        publicacion3.prestar();

        publicacion1.retirar();
        publicacion2.retirar();
        publicacion3.retirar();

        System.out.println(publicacion1.imprimir());
        System.out.println(publicacion2.imprimir());
        System.out.println(publicacion3.imprimir());

        publicacion1.devolver();
        publicacion2.devolver();
        publicacion3.devolver();

        publicacion1.devolverConsul();
        publicacion2.devolverConsul();
        publicacion3.devolverConsul();
        
        System.out.println(publicacion1.imprimir());
        System.out.println(publicacion2.imprimir());
        System.out.println(publicacion3.imprimir());
    }
}
