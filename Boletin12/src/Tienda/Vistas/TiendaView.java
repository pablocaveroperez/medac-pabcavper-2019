package Tienda.Vistas;

import Libreria.LibreriaValida;
import Tienda.Controladores.Tienda;

import static Libreria.LibreriaValida.valida;

public class TiendaView {
    private ArticuloView articuloView;
    private ClienteView clienteView;
    private byte opcionMenuPrincipal;

    public ArticuloView getArticuloView() {
        return articuloView;
    }

    public ClienteView getClienteView() {
        return clienteView;
    }

    public byte getOpcionMenuPrincipal() {
        return opcionMenuPrincipal;
    }

    private boolean setOpcionMenuPrincipal(byte opcionMenuPrincipal) {
        boolean bExito = false;
        if (opcionMenuPrincipal >=1 && opcionMenuPrincipal <= 3){
            this.opcionMenuPrincipal = opcionMenuPrincipal;
            bExito = true;
        }
        return bExito;
    }

    private static byte menuPrincipal(){
        System.out.println("*********************************");
        System.out.println("* 1. Gestion de Clientes:       *");
        System.out.println("* 2. Gestion de Articulos:      *");
        System.out.println("* 3. Salir del programa:        *");
        return (byte) valida("Introduce la opcion deseada: ",1,3,3);
    }

    public void gestionOpcionMenuPrincipal(Tienda tienda){
        do {
            byte opcion = menuPrincipal();
            switch (opcion){
                case 1://  GESTION DE CLIENTES
                    clienteView.menuClientes(tienda);
                    break;
                case 2:
                    articuloView.menuArticulos(tienda);
                    break;
                case 3:
                    System.out.println("ADIOS.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion introducida incorrecta.");
                    break;
            }
        }while (opcionMenuPrincipal > 3 || opcionMenuPrincipal < 1);

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
        return (byte) valida("Introduce una opcion valida: ", 1, 6, 3);
    }


}
