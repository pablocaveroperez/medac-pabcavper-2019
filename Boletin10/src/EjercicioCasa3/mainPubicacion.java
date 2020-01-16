package EjercicioCasa3;

public class mainPubicacion {
    public static void main(String[] args) {
        Publicacion publicacion1 = new Libro(1,"Edu Aguirre", "Luna de Pluton", (short) 123);
        Publicacion publicacion2 = new Revista(2,"Edu Aguirre", "Chiringuito de jugones", (short) 123);
        Publicacion publicacion3 = new Disco(3,"Edu Aguirre", "CR7 campeon", (short) 123);

        publicacion1.setTitulo("Chiricirco de mamones");
        System.out.println(publicacion1.getTitulo());
    }
}
