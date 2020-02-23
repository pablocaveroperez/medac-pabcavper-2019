package Club.Vistas;

import Club.Controladores.Terminal;
import Club.Modelos.Instalacion;
import Club.Modelos.Socio;
import Tienda.Vistas.TiendaView;

import static Libreria.LibreriaValida.*;

public class InstalacionView {
    public static void menuInstalaciones(Terminal terminal) {
        byte opcion;
        boolean bExito;

        do {
            opcion = TiendaView.subMenu();
            bExito = gestionMenuInstalacion(terminal, opcion);
        }while(opcion != 6);
    }

    private static boolean gestionMenuInstalacion(Terminal terminal, byte opcion) {
        boolean bExito = false;
        switch (opcion) {
            case 1: // ADD INSTALACION
                bExito = altaInstalacion(terminal);
                break;
            case 2: // MODIFICAR INSTALACION
                bExito = modificarEstadoInstalacion(terminal);
                break;
            case 3: // ELIMINAR INSTALACION
                bExito = eliminarInstalacion(terminal);
                break;
            case 4: // BUSCAR INSTALACION
                Socio socio = buscarInstalacion(terminal);
                if (socio != null)
                    System.out.println(socio);
                else
                    System.out.println("No se ha encontrado ninguna instalacion con esa id");
                break;
            case 5: // MOSTRAR INSTALACION
                System.out.println(mostrarInstalaciones(terminal));
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

    private static boolean eliminarInstalacion(Terminal terminal) {
        boolean bExito = false;
        byte bTipo = 0, bUbicacion = 0;

        do {
            try {
                bTipo = (byte) valida("Introduce el número del tipo de la instalacion que quieres modificar (1-3): ", 1, 3, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Tipo introducido incorrecto.");
            }
        }while (!bExito);

        do {
            bExito = false;
            try {
                bUbicacion = (byte) valida("Introduce el número de ubicaicon de la instalacion que quieres modificar: ", 0, -1, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Ubicaicon introducido incorrecto.");
            }
        }while (!bExito);

        bExito = terminal.getInstalacionController().remove(new Instalacion(bUbicacion,bTipo));

        if (bExito)
            System.out.println("Instalacion eliminada con exito");
        else
            System.out.println("Instalacion eliminada sin exito");
        return bExito;
    }

    private static boolean modificarEstadoInstalacion(Terminal terminal) {
        boolean bExito = false;
        byte bTipo = 0, bUbicacion = 0;

        do {
            try {
                bTipo = (byte) valida("Introduce el número del tipo de la instalacion que quieres modificar (1-3): ", 1, 3, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Tipo introducido incorrecto.");
            }
        }while (!bExito);

        do {
            bExito = false;
            try {
                bUbicacion = (byte) valida("Introduce el número de ubicaicon de la instalacion que quieres modificar: ", 0, -1, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Ubicaicon introducido incorrecto.");
            }
        }while (!bExito);

        int iPosicion = terminal.getInstalacionController().search(new Instalacion(bUbicacion,bTipo));
        bExito = false;
        if (iPosicion != 1) {
            terminal.getInstalacionController().getaVector()[iPosicion].setbEstado(selectorEstado());
            bExito = true;
        }

        if (bExito)
            System.out.println("Modificacion del estado con exito");
        else
            System.out.println("Modificacion del estado sin exito");
        return bExito;
    }

    private static boolean selectorEstado() {
        boolean bExito = false;
        byte opcion = 0;

        do {
            try {
                opcion = (byte) valida("Introduce 1 para liberar la instalacion o 2 para ocuparla.",1,2,3);
                bExito = true;
            }catch (NumberFormatException exc) {
                System.out.println("Error: " +exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Opcion introducida incorrecta");
            }
        }while(!bExito);

        if (opcion == 1)
            bExito = true;
        else if (opcion == 2)
            bExito = false;
        else
            System.out.println("Opcion introducida incorrecta");
        return bExito;

    }

    public static boolean altaInstalacion(Terminal terminal) {
        byte bTipo = -1, bUbicacion = -1;
        boolean bExito = false;

        do {
            try {
                bTipo = (byte) valida("Introduce un número de tipo de instalacion (1-3): ", 1, 3, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Tipo introducido incorrecto.");
            }
        }while (!bExito);

        do {
            bExito = false;
            try {
                bUbicacion = (byte) valida("Introduce un número de ubicaicon: ", 0, -1, 3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Ubicaicon introducido incorrecto.");
            }
        }while (!bExito);

        Instalacion instalacion = new Instalacion(bUbicacion, bTipo);
        bExito = terminal.getInstalacionController().add(instalacion);
        if (bExito)
            System.out.println("Instalacion aniadida con exito");
        else
            System.out.println("Instalacion aniadida sin exito");
        return bExito;
    }
}
