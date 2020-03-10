package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Articulo;
import Tienda.Modelos.Empresa;
import Tienda.Modelos.Proveedor;

import static Libreria.LibreriaValida.*;


public class ArticuloView {

    public static void menuArticulos(Tienda tienda) {
        byte opcion;
        boolean bExito;

        do {
            opcion = subMenuArticulos();
            bExito = gestionMenuArticulos(tienda, opcion);
        }while(opcion != 7);

    }

    private static byte subMenuArticulos() {
    	System.out.println("¿Que deseas hacer?");
        System.out.println("*********************************");
        System.out.println("1. Aniadir ");
        System.out.println("2. Modificar ");
        System.out.println("3. Eliminar ");
        System.out.println("4. Buscar ");
        System.out.println("5. Mostrar ");
        System.out.println("6. Asociar un articulo a un proveedor ");
        System.out.println("7. Volver a menu principal");
        boolean bExito = false;
        byte opcion = 0;
        do {
            try {
                opcion = (byte) valida("Introduce una opcion valida: ", 1, 7, 3);
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

	private static boolean gestionMenuArticulos(Tienda tienda, byte opcion) {
        boolean bExito = false;
        switch (opcion){
            case 1: // ADD CLIENTE
                bExito = altaArticulo(tienda);
                break;
            case 2:// MODIFICAR CLIENTE
                bExito = modificarArticulo(tienda);
                break;
            case 3: // ELIMINAR CLIENTE
                bExito = eliminarArticulo(tienda);
                break;
            case 4: // BUSCAR CLIENTE
                Articulo oArticulo = buscarArticulo(tienda);
                if (oArticulo != null)
                    System.out.println(oArticulo);
                else
                    System.out.println("No se ha encontrado ningun articulo con esa ID.");
                break;
            case 5: // MOSTRAR CLIENTES
                System.out.println(mostrarArticulos(tienda));
                break;
            case 6:
            	bExito = asociarArticulo(tienda);
            	break;
            case 7:
                System.out.println("Volviendo al menus principal");
                break;
            default:
                System.out.println("Opcion introducida incorrecta");
                break;
        }
        return bExito;
    }

    private static boolean asociarArticulo(Tienda tienda) {
    	boolean bExito = false;
    	int idArticulo = 0;
    	byte idEmpresa = 0;
    	
    	do {
            try {
            	idArticulo = (int) valida("Introduce el id del articulo: ",0,-1,1);
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
    	do {
            try {
            	idEmpresa = (byte) valida("Introduce el id del proveedor: ",0,-1,3);
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
    	
    	int iPosicionArticulo = tienda.getArticuloController().search(new Articulo(idArticulo));
    	
    	if(iPosicionArticulo == -1) {
    		System.out.println("No hay articulos registrados con esa ID");
    		bExito = false;
    	}else {
    		Proveedor empresa = tienda.getProveedorController().searchObject(idEmpresa);
    		Empresa aux = new Empresa();
    		if (empresa == null || empresa.getClass() != aux.getClass() ) {
    			System.out.println("No hay empresas registradas con esa ID");
    			bExito = false;
    		}else {
    			tienda.getArticuloController().getaVector()[iPosicionArticulo].setIdProveedor(idEmpresa);
    			bExito = true;
    		}
    	}
    	
    	if (bExito)
    		System.out.println("El proveedor ha sido asociado al articulo");
    	else
    		System.out.println("El proveedor no ha sido asociado al articulo");
    	
    	return bExito;
	}

	private static String mostrarArticulos(Tienda tienda){
        return tienda.getArticuloController().printAll();
    }

    private static Articulo buscarArticulo(Tienda tienda){
        boolean bExito = false;
        int id = 0;
        do {
            try {
                id = (int) valida("Introduce el id del articulo que desea buscar: ",0,-1,1);
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
        return tienda.getArticuloController().getaVector()[tienda.getArticuloController().search(new Articulo(id))];
    }

    private static boolean eliminarArticulo(Tienda tienda){
        int id = 0;
        boolean bExito = false;
        do {
            try {
                id = (int) valida("Introduce el id del articulo que desea eliminar: ",0,-1,1);
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
        bExito = tienda.getArticuloController().remove(new Articulo(id));
        if (bExito)
            System.out.println("Articulo eliminado con exito.");
        else
            System.out.println("Articulo eliminado sin exito.");
        return bExito;

    }

    private static boolean modificarArticulo(Tienda tienda) {
        int id = 0;
        boolean bExito = false;
        do {
            try {
                id = (int) valida("Introduce un DNI de un articulo que desees modificar: ",0,-1,1);
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
        int iPosicion = tienda.getArticuloController().search(new Articulo(id));
        if (iPosicion != -1) {
            do {
                try {
                    tienda.getArticuloController().getaVector()[iPosicion].setNombre(leer("Introduce el nuevo nombre del articulo: "));
                    bExito = true;
                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }finally {
                    if (!bExito)
                        System.out.println("Nombre introducido incorrecto");
                }
            }while(!bExito);

            do {
                bExito = false;
                try {
                    tienda.getArticuloController().getaVector()[iPosicion].setPrecio((float) valida("Introduce el nuevo precio del articulo(0-2000): ",0,2000,2));
                    bExito = true;
                }catch (NumberFormatException exc){
                    System.out.println(exc.getMessage());
                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }finally {
                    if (!bExito)
                        System.out.println("Precio introducido incorrecto");
                }
            }while(!bExito);

            do {
                bExito = false;
                try {
                    tienda.getArticuloController().getaVector()[iPosicion].setStock((short) valida("Introduce el stock del articulo: ", 0,1000,4));
                    bExito = true;
                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }finally {
                    if (!bExito)
                        System.out.println("Stock introducido incorrecto");
                }
            }while(!bExito);


            bExito = true;
        }
        if (bExito)
            System.out.println("Articulo modificado con exito.");
        else
            System.out.println("Articulo modificado sin exito.");

        return bExito;
    }

    public static boolean altaArticulo(Tienda tienda){
        int id = 0;
        String sNombre = "";
        float precio = 0;
        short stock = 0;
        String sResultado;

        boolean bExito = false;
        do {
            try {
                id = (int) valida("Instroduce el ID del articulo: ",0,-1,1);
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

        do {
            bExito = false;
            try {
                stock = (short) valida("Introduce el stock del articulo: ", 0,1000,4);
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Stock introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                sNombre = leer("Introduce el nombre del articulo: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Nombre introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                precio = (float) valida("Introduce el precio del articulo: ",0,500,2);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Saldo introducido incorrecto");
            }
        }while(!bExito);

        Articulo articulo = new Articulo(id,sNombre,precio,stock);

        bExito = tienda.getArticuloController().add(articulo);
        if (bExito)
            System.out.println("Articulo aniadido con exito.");
        else
            System.out.println("Articulo aniadido sin exito.");

        return bExito;
    }
}
