package Club.Vistas;

import Club.Controladores.Terminal;

import static Libreria.LibreriaValida.*;

public class TerminalView {

    private byte opcionMenuPrincipal;

    public byte getOpcionMenuPrincipal() {
        return opcionMenuPrincipal;
    }

    private boolean setOpcionMenuPrincipal(byte opcionMenuPrincipal) {
        boolean bExito = false;
        if (opcionMenuPrincipal >=1 && opcionMenuPrincipal <= 4){
            this.opcionMenuPrincipal = opcionMenuPrincipal;
            bExito = true;
        }
        return bExito;
    }

    private static byte menuPrincipal(){
        System.out.println("*********************************");
        System.out.println("* 1. Gestion de Socios:       *");
        System.out.println("* 2. Gestion de Instalaciones:      *");
        System.out.println("* 3. Gestion de Reservas:      *");
        System.out.println("* 4. Salir del programa:        *");
        boolean bExito = false;
        byte opcion = 0;
        do {
            try {
                opcion = (byte) valida("Introduce una opcion valida: ", 1, 4, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Opcion introducida incorrecto");
            }
        }while(!bExito);
        return opcion;
    }

    public void gestionOpcionMenuPrincipal(Terminal terminal){
        do {
            byte opcion = menuPrincipal();
            switch (opcion){
                case 1://  GESTION DE CLIENTES
                    SocioView.menuSocios(terminal);
                    break;
                case 2:
                    InstalacionView.menuInstalaciones(terminal);
                    break;
                case 3:
                    ReservaView.menuReservas(terminal);
                    break;
                case 4:
                    System.out.println("ADIOS.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion introducida incorrecta.");
                    break;
            }
        }while (opcionMenuPrincipal > 4 || opcionMenuPrincipal < 1);

    }

    public static byte subMenu(){
        System.out.println("¿Que deseas hacer?");
        System.out.println("*********************************");
        System.out.println("1. Añadir ");
        System.out.println("2. Modificar ");
        System.out.println("3. Eliminar ");
        System.out.println("4. Buscar ");
        System.out.println("5. Mostrar ");
        System.out.println("6. Volver a menu principal");
        boolean bExito = false;
        byte opcion = 0;
        do {
            try {
                opcion = (byte) valida("Introduce una opcion valida: ", 1, 6, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Opcion introducida incorrecto");
            }
        }while(!bExito);
        return opcion;
    }
}
