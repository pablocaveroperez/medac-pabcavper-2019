package Tienda.Vistas;

import static Libreria.LibreriaValida.leer;
import static Libreria.LibreriaValida.valida;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Empresa;
import Tienda.Modelos.Particular;
import Tienda.Modelos.Proveedor;

public class ProveedorView {
	public static void menuProveedores(Tienda tienda) {
		// TODO Auto-generated method stub
		byte opcion;
        boolean bExito;

        do {
            opcion = subMenuProveedores();
            bExito = gestionMenuProveedores(tienda, opcion);
        }while(opcion != 3);
	}

	private static byte subMenuProveedores() {
		System.out.println("Gestion de Proveedores");
        System.out.println("-----------------------");
        System.out.println("1. Alta ");
        System.out.println("2. Busqueda ");
        System.out.println("3. Volver ");
        boolean bExito = false;
        byte opcion = 0;
        do {
            try {
                opcion = (byte) valida("Introduce una opcion valida: ", 1, 3, 3);
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

	private static boolean gestionMenuProveedores(Tienda tienda, byte opcion) {
		// TODO Auto-generated method stub
		boolean bExito = false;
        switch (opcion){
            case 1: // ADD CLIENTE
                bExito = altaProveedores(tienda);
                break;
            case 2: // BUSCAR CLIENTE
                Proveedor oProveedor = buscarProveedores(tienda);
                if (oProveedor != null)
                    System.out.println(oProveedor);
                else
                    System.out.println("No se ha encontrado ningun proveedor con esa ID.");
                break;
            case 3:
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

	private static Proveedor buscarProveedores(Tienda tienda) {
		byte bIdentificador = 0;
		boolean bExito = false;
		
		do {
            try {
            	bIdentificador = (byte) valida("Introduce el identificador: ",1,-1,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Identificador introducido incorrecto");
            }
        }while(!bExito);
		
		
		return tienda.getProveedorController().searchObject(bIdentificador);
	}

	
	private static boolean altaProveedores(Tienda tienda) {
		byte bOpcion = 0;
		boolean bExito = false;
		
		do {
            try {
            	bOpcion = (byte) valida("Introduce el tipo de empresa que desea registrar (1 - Empresa :: 2 - Particular): ",1,2,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Opcion introducida incorrecta");
            }
        }while(!bExito);
		
		if (bOpcion == 1)
			bExito = altaEmpresa(tienda);
		else if (bOpcion == 2)
			bExito = altaParticular(tienda);
		
		if(bExito)
			System.out.println("El proveedor ha sido registrado correctamente.");
		else
			System.out.println("El proveedor NO ha sido registrado correctamente.");
		
		return bExito;
	}
	
	private static boolean altaParticular(Tienda tienda) {
		byte idProveedor = 0;
		String sNombre = "";
		String sDomicilio = "";
		String sTelefono = "";
		String sNombreParticular = "";
		String sApellidosParticular = "";
		
		boolean bExito = false;
		do {
            try {
            	idProveedor = (byte) valida("Introduce la ID del proveedor: ",1,-1,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID introducida incorrecta");
            }
        }while(!bExito);
		
		bExito = false;
		do {
            try {
                sNombre = leer("Introduce el Nombre del proveedor: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Nombre introducido incorrecto");
            }
        }while(!bExito);
		
		bExito = false;
		do {
            try {
            	sDomicilio = leer("Introduce el Domicilio del proveedor: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Domicilio introducido incorrecto");
            }
        }while(!bExito);
		
		bExito = false;
		do {
            try {
            	sTelefono = leer("Introduce el Telefono del proveedor: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Telefono introducido incorrecto");
            }
        }while(!bExito);
		
		bExito = false;
		do {
            try {
            	sNombreParticular = leer("Introduce el nombre del particular: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Nombre del particular introducido incorrecto");
            }
        }while(!bExito);
		
		bExito = false;
		do {
            try {
            	sApellidosParticular = leer("Introduce los apellidos del particular: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Apellios del particular introducidos incorrectos");
            }
        }while(!bExito);
		
		Proveedor proveedor1 = new Particular(idProveedor,sNombre,sDomicilio,sTelefono,sNombreParticular,sApellidosParticular); 
		
		bExito = tienda.getProveedorController().add(proveedor1);
		
		return bExito;
		
	}

	private static boolean altaEmpresa(Tienda tienda) {
		byte idProveedor = 0;
		String sNombre = "";
		String sDomicilio = "";
		String sTelefono = "";
		String sDenominacionOficial = "";
		byte bTipoEmpresa = 0;
		
		boolean bExito = false;
		do {
            try {
            	idProveedor = (byte) valida("Introduce la ID del proveedor: ",1,-1,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID introducida incorrecta");
            }
        }while(!bExito);
		
		bExito = false;
		do {
            try {
                sNombre = leer("Introduce el Nombre del proveedor: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Nombre introducido incorrecto");
            }
        }while(!bExito);
		
		bExito = false;
		do {
            try {
            	sDomicilio = leer("Introduce el Domicilio del proveedor: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Domicilio introducido incorrecto");
            }
        }while(!bExito);
		
		bExito = false;
		do {
            try {
            	sTelefono = leer("Introduce el Telefono del proveedor: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Telefono introducido incorrecto");
            }
        }while(!bExito);
		
		bExito = false;
		do {
            try {
            	sDenominacionOficial = leer("Introduce la denominacion oficial: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Denominacion oficial introducida incorrecto");
            }
        }while(!bExito);
		
		
		System.out.println("1. Responsabilidad Limitada (SL).");
		System.out.println("2. Sociedad Limitada Nueva Empresa (SLNE).");
		System.out.println("3. Sociedad Anonima (SA).");
		bExito = false;
		do {
            try {
            	bTipoEmpresa = (byte) valida("Introduce el tipo de empresa (valor entre 1 y 3): ",1,3,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println(exc.getMessage());
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Tipo introducido incorrecto");
            }
        }while(!bExito);
		
		Proveedor proveedor2 = new Empresa(idProveedor, sNombre, sDomicilio, sTelefono, sDenominacionOficial, bTipoEmpresa);
		
		bExito = tienda.getProveedorController().add(proveedor2);
		
		return bExito;
	}

}
