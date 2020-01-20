package EjercicioCasa2;

public class mainTelefono {
    public static void main(String[] args) {
        Movil telefono1 = new Movil(689794523);
        Fijo telefono2 = new Fijo(955632586);
        Satelite telefono3 = new Satelite(526369784);

        System.out.println(telefono1.marcar());
        System.out.println(telefono2.marcar());
        System.out.println(telefono3.marcar());

        System.out.println(telefono1.sonarTimbre());
        System.out.println(telefono2.sonarTimbre());
        System.out.println(telefono3.sonarTimbre());

        System.out.println(telefono1.colgar());
        System.out.println(telefono2.colgar());
        System.out.println(telefono3.colgar());

        System.out.println(telefono1.activarAltavoz());
        System.out.println(telefono2.activarAltavoz());
        System.out.println(telefono3.activarAltavoz());

        System.out.println(telefono1.desactivarAltavoz());
        System.out.println(telefono2.desactivarAltavoz());
        System.out.println(telefono3.desactivarAltavoz());

        System.out.println(telefono1.imprimir());
        System.out.println(telefono2.imprimir());
        System.out.println(telefono3.imprimir());
    }
}
