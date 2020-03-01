package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Cliente;
import Tienda.Modelos.LineaArticulo;

public class CarritoView {

    public static void menuCarrito(Tienda tienda) {
        byte opcion;
        boolean bExito;

        do {
            opcion = TiendaView.subMenu();
            bExito = gestionMenuCarrito(tienda, opcion);
        }while (opcion != 6);
    }

    private static boolean gestionMenuCarrito(Tienda tienda, byte opcion) {
        boolean bExito = false;
        switch (opcion){
            case 1: // ADD CLIENTE
                bExito = aniadirAlCarrito(tienda);
                break;
            case 2:// MODIFICAR CLIENTE
                bExito = modificarCarrito(tienda);
                break;
            case 3: // ELIMINAR CLIENTE
                bExito = eliminarDelCarrito(tienda);
                break;
            case 4: // BUSCAR CLIENTE
                LineaArticulo oArticulo = buscarCarrito(tienda);
                if (oArticulo != null)
                    System.out.println(oArticulo);
                else
                    System.out.println("No se ha encontrado ningun articulo en el carrito.");
                break;
            case 5: // MOSTRAR CLIENTES
                System.out.println(mostrarCarrito(tienda));
                bExito = true;
                break;
            case 6:
                System.out.println("Volviendo al menus principal");
                bExito = true;
                break;
            default:
                System.out.println("Opcion introducida incorrecta");
                bExito = false;
                break;
        }
        return bExito;
    }


}
