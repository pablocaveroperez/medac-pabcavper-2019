package Club.Vistas;

import Club.Controladores.Terminal;
import Club.Modelos.Socio;
import Tienda.Modelos.Cliente;
import Tienda.Vistas.TiendaView;

import static Libreria.LibreriaValida.*;

public class SocioView {

    public static void menuSocios(Terminal terminal) {
        byte opcion;
        boolean bExito;

        do {
            opcion = TiendaView.subMenu();
            bExito = gestionMenuSocio(terminal, opcion);
        }while(opcion != 6);
    }

    private static boolean gestionMenuSocio(Terminal terminal, byte opcion) {
        boolean bExito = false;
        switch (opcion) {
            case 1: // ADD SOCIO
                bExito = altaSocio(terminal);
                break;
            case 2: // MODIFICAR SOCIO
                bExito = modificarSocio(terminal);
                break;
            case 3: // ELIMINAR SOCIO
                bExito = eliminarSocio(terminal);
                break;
            case 4: // BUSCAR SOCIO
                Socio socio = buscarSocio(terminal);
                if (socio != null)
                    System.out.println(socio);
                else
                    System.out.println("No se ha encontrado ningun cliente con esa id");
                break;
            case 5: // MOSTRAR SOCIOS
                System.out.println(mostrarSocios(terminal));
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

    private static String mostrarSocios(Terminal terminal) {
        return terminal.getSocioController().printAll();
    }

    private static Socio buscarSocio(Terminal terminal) {
        boolean bExito = false;
        int id = 0;

        do {
            try {
                id = (int) valida("Introduce el ID del socio que desees buscar: ",0,-1,1);
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

        return terminal.getSocioController().getaVector()[terminal.getSocioController().search(new Socio(id))];
    }

    private static boolean eliminarSocio(Terminal terminal) {
        boolean bExito = false;
        int id = 0;

        do {
            try {
                id = (int) valida("Introduce el ID del socio que desees eliminar: ",0,-1,1);
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

        bExito = terminal.getSocioController().remove(new Socio(id));

        if (bExito)
            System.out.println("Socio eliminado con exito.");
        else
            System.out.println("Socio eliminado sin exito.");
        return bExito;
    }

    private static boolean modificarSocio(Terminal terminal) {
        int id = 0;
        boolean bExito = false;
        do {
            try {
                id = (int) valida("Introduce el ID del socio que desees modificar: ",0,-1,1);
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

        int iPosicion = terminal.getSocioController().search(new Socio(id));
        bExito = false;
        if (iPosicion != 1) {
            do {
                try {
                    terminal.getSocioController().getaVector()[iPosicion].setsDni(leer("Introduce el DNI del socio: "));
                    bExito = true;
                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }finally {
                    if (!bExito)
                        System.out.println("DNI introducido incorrecto");
                }
            }while(!bExito);

            do {
                bExito = false;
                try {
                    terminal.getSocioController().getaVector()[iPosicion].setsNombre(leer("Introduce el nombre del socio: "));
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
                    terminal.getSocioController().getaVector()[iPosicion].setsApellidos(leer("Introduce los apellidos del socio: "));
                    bExito = true;
                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }finally {
                    if (!bExito)
                        System.out.println("Apellidos introducido incorrecto");
                }
            }while(!bExito);

            do {
                bExito = false;
                try {
                    terminal.getSocioController().getaVector()[iPosicion].setsTelefono(leer("Introduce el telefono del socio: "));
                    bExito = true;
                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }finally {
                    if (!bExito)
                        System.out.println("Telefono introducido incorrecto");
                }
            }while(!bExito);

            do {
                bExito = false;
                try {
                    terminal.getSocioController().getaVector()[iPosicion].setsEmail(leer("Introduce el email del socio: "));
                    bExito = true;
                }catch (Exception exc){
                    System.out.println(exc.getMessage());
                }finally {
                    if (!bExito)
                        System.out.println("Email introducido incorrecto");
                }
            }while(!bExito);
            bExito = true;
        }
        if (bExito)
            System.out.println("Socio modificado con exito.");
        else
            System.out.println("Socio midificado sin exito.");
        return bExito;
    }

    private static boolean altaSocio(Terminal terminal) {
        String sDni = null, sNombre = null, sApellidos = null, sTelefono = null, sEmail = null;
        int id = 0;

        boolean bExito = false;
        do {
            try {
                id = (int) valida("Introduce el ID del socio",0,-1,1);
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
                sDni = leer("Introduce el DNI del socio: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("DNI introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                sNombre = leer("Introduce el nombre del socio: ");
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
                sApellidos = leer("Introduce los apellidos del socio: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Apellidos introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                sTelefono = leer("Introduce el telefono del socio: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Telefono introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                sEmail = leer("Introduce el email del socio: ");
                bExito = true;
            }catch (Exception exc){
                System.out.println(exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Email introducido incorrecto");
            }
        }while(!bExito);

        Socio socio = new Socio(id,sDni,sNombre,sApellidos,sEmail,sTelefono);

        bExito = terminal.getSocioController().add(socio);
        if (bExito)
            System.out.println("Cliente aniadido con exito");
        else
            System.out.println("Cliente aniadido sin exito");
        return bExito;
    }
}
