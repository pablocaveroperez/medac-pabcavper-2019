package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Articulo;
import Tienda.Modelos.Cliente;
import Tienda.Modelos.LineaArticulo;

import static Libreria.LibreriaValida.valida;

public class CarritoView {

    public static void menuCarrito(Tienda tienda) {
        byte opcion;
        boolean bExito;

        do {
            opcion = subMenuCarrito();
            bExito = gestionMenuCarrito(tienda, opcion);
        }while (opcion != 8);
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
                bExito = comprarCarrito(tienda);
                break;
            case 7:
                vaciarCarrito(tienda);
                break;
            case 8:
                System.out.println("Volviendo al menus principal.");
                bExito = true;
                break;
            default:
                System.out.println("Opcion introducida incorrecta.");
                bExito = false;
                break;
        }
        return bExito;
    }

    private static void vaciarCarrito(Tienda tienda) {
        tienda.getCarritoController().vaciarCarrito();
        System.out.println("*****************");
        System.out.println("*CARRITO VACIADO*");
        System.out.println("*****************");
    }

    private static boolean comprarCarrito(Tienda tienda) {
        int idCliente = 0;
        boolean bExito = false;

        do {
            try {
                idCliente = (int) valida("Introduce el ID del socio que va a pagar el carrito",0,-1,1);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID introducido incorrecto");
            }
        }while(!bExito);

        bExito = false;
        int iPosicion = tienda.getClienteController().search(new Cliente(idCliente));
        if (iPosicion == -1)
            System.out.println("El ID introducido no corresponde con ningun cliente");
        else{
            Cliente oCliente = tienda.getClienteController().getaVector()[iPosicion];
            if (tienda.getCarritoController().comprarCarrito() > oCliente.getSaldo())
                System.out.println("El cliente "+oCliente.getsNombre()+" no tiene suficiente saldo");
            else{
                oCliente.setSaldo(oCliente.getSaldo() - tienda.getCarritoController().comprarCarrito());
                bExito = true;
            }
        }
        if (bExito) {
            System.out.println("Se ha comprado el carrito por un valor de: " + tienda.getCarritoController().comprarCarrito());
            tienda.getCarritoController().vaciarCarrito();
        }else
            System.out.println("No se ha podido comprar el carrito con exito.");
        return bExito;
    }

    private static boolean aniadirAlCarrito(Tienda tienda) {
        boolean bExito = false;
        int idArticulo = 0;
        int iCantidad = 0;

        do {
            try {
                idArticulo = (int) valida("Instroduce el ID del articulo que quieres aniadir al carrito: ",0,-1,1);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID introducido incorrecto.");
            }
        }while(!bExito);

        int iPosicion = tienda.getArticuloController().search(new Articulo(idArticulo));
        if (iPosicion == -1)
            System.out.println("No existe ningun articulo con esa ID.");
        else{
            Articulo oArticulo = tienda.getArticuloController().getaVector()[iPosicion];

            do {
                bExito = false;
                try {
                    iCantidad = (short) valida("Introduce la cantidad del articulo: ", 0,1000,4);
                    bExito = true;
                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }finally {
                    if (!bExito)
                        System.out.println("Cantidad introducida incorrecto.");
                }
            }while(!bExito);

            LineaArticulo oLineaArticulo = new LineaArticulo(oArticulo,iCantidad);

            bExito = tienda.getCarritoController().add(oLineaArticulo,tienda);
            if (bExito)
                System.out.println("Articulo aniadido al carrito con exito.");
            else
                System.out.println("Articulo aniadido al carrito sin exito.");
        }
        return bExito;
    }

    private static boolean modificarCarrito(Tienda tienda) {
        boolean bExito = false;
        int idArticulo = 0;

        do {
            try {
                idArticulo = (int) valida("Instroduce el ID del articulo del carrito que quieres modificar: ",0,-1,1);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID introducido incorrecto.");
            }
        }while(!bExito);
        bExito = false;

        int iPosicion = tienda.getArticuloController().search(new Articulo(idArticulo));
        Articulo oArticulo = tienda.getArticuloController().getaVector()[iPosicion];
        LineaArticulo oLineaArticulo = new LineaArticulo(oArticulo);
        iPosicion = tienda.getCarritoController().search(oLineaArticulo);
        if (iPosicion == -1)
            System.out.println("No existe ningun articulo con esa ID en el carrito.");
        else{
            do {
                bExito = false;
                try {
                    tienda.getCarritoController().getaVector()[iPosicion].setCantidad((short) valida("Introduce la cantidad del articulo: ", 0,1000,4));
                    bExito = true;
                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }finally {
                    if (!bExito)
                        System.out.println("Cantidad introducida incorrecto.");
                }
            }while(!bExito);

            bExito = true;
        }

        if (bExito)
            System.out.println("Articulo del carrito modificado con exito.");
        else
            System.out.println("Articulo del carrito modificado sin exito.");
        return bExito;
    }

    private static boolean eliminarDelCarrito(Tienda tienda) {
        boolean bExito = false;
        int idArticulo = 0;
        do {
            try {
                idArticulo = (int) valida("Instroduce el ID del articulo del carrito que quieres eliminar: ",0,-1,1);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID introducido incorrecto.");
            }
        }while(!bExito);

        int iPosicion = tienda.getArticuloController().search(new Articulo(idArticulo));
        Articulo oArticulo = tienda.getArticuloController().getaVector()[iPosicion];
        LineaArticulo oLineaArticulo = new LineaArticulo(oArticulo);
        iPosicion = tienda.getCarritoController().search(oLineaArticulo);
        if (iPosicion == -1)
            System.out.println("No existe ningun articulo con esa ID en el carrito.");
        else{
            bExito = tienda.getCarritoController().remove(oLineaArticulo);
        }
        if (bExito)
            System.out.println("Articulo eliminado del carrito con exito.");
        else
            System.out.println("Articulo eliminado del carrito sin exito.");
        return bExito;
    }

    private static LineaArticulo buscarCarrito(Tienda tienda) {
        boolean bExito = false;
        int idArticulo = 0;
        do {
            try {
                idArticulo = (int) valida("Instroduce el ID del articulo del carrito que quieres buscar: ",0,-1,1);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID introducido incorrecto.");
            }
        }while(!bExito);

        int iPosicion = tienda.getArticuloController().search(new Articulo(idArticulo));
        Articulo oArticulo = tienda.getArticuloController().getaVector()[iPosicion];
        LineaArticulo oLineaArticulo = new LineaArticulo(oArticulo);

        LineaArticulo oLineaArticuloAux = tienda.getCarritoController().getaVector()[tienda.getCarritoController().search(oLineaArticulo)];
        return oLineaArticuloAux;
    }

    private static String mostrarCarrito(Tienda tienda) {
        return tienda.getCarritoController().printAll();
    }

    public static byte subMenuCarrito(){
        System.out.println("¿Que deseas hacer?");
        System.out.println("*********************************");
        System.out.println("1. Añadir ");
        System.out.println("2. Modificar ");
        System.out.println("3. Eliminar ");
        System.out.println("4. Buscar ");
        System.out.println("5. Mostrar ");
        System.out.println("6. Comprar Carrito ");
        System.out.println("7. Vaciar Carrito ");
        System.out.println("8. Volver a menu principal");
        boolean bExito = false;
        byte opcion = 0;
        do {
            try {
                opcion = (byte) valida("Introduce una opcion valida: ", 1, 8, 3);
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
