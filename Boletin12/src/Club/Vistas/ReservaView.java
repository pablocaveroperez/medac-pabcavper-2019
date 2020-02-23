package Club.Vistas;

import Club.Controladores.Terminal;
import Club.Modelos.Instalacion;
import Club.Modelos.Reserva;
import Club.Modelos.Socio;
import Tienda.Vistas.TiendaView;

import java.util.Calendar;

import static Libreria.LibreriaValida.*;

public class ReservaView {
    public static void menuReservas(Terminal terminal) {
        byte opcion;
        boolean bExito;

        do {
            opcion = subMenuReservas();
            bExito = gestionMenuReserva(terminal,opcion);
        }while(opcion != 4);
    }

    private static boolean gestionMenuReserva(Terminal terminal, byte opcion) {
        boolean bExito = false;
        switch (opcion) {
            case 1: // ADD RESERVA
                bExito = altaReserva(terminal);
                break;
            case 2: // ELIMINAR RESERVA
                bExito = eliminarReserva(terminal);
                break;
            case 3: // MOSTRAR RESERVA
                System.out.println(mostrarReserva(terminal));
                bExito = true;
                break;
            case 4:
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

    private static String mostrarReserva(Terminal terminal) {
        return null;
    }

    private static boolean eliminarReserva(Terminal terminal) {
    }

    private static boolean altaReserva(Terminal terminal) {
        boolean bExito = false;
        Socio socio;
        Instalacion instalacion;
        Calendar fecha = null;
        byte hora = 0;
        byte minutos = 0;

        int idSocio = 0;
        do {
            try {
                idSocio = (int) valida("Introduce la id del socio: ",0,-1,1);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("ID del socio introducido incorrecto");
            }
        }while(!bExito);

        socio = terminal.getSocioController().getaVector()[terminal.getSocioController().search(new Socio(idSocio))];

        byte ubicacion = 0, tipo = 0;
        do {
            bExito = false;
            try {
                ubicacion = (byte) valida("Introduce la ubicacion de la instalacion: ",0,-1,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Ubicacion de la instalacion introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                ubicacion = (byte) valida("Introduce el tipo de la instalacion: ",1,3,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Tipo de la instalacion introducido incorrecto");
            }
        }while(!bExito);

        instalacion = terminal.getInstalacionController().getaVector()[terminal.getInstalacionController().search(new Instalacion(ubicacion,tipo))];

        short year = 0;
        byte month = 0, day = 0;

        do {
            bExito = false;
            try {
                year = (byte) valida("Introduce el anio de la reserva: ",1900,2020,4);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Anio de la reserva introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                month = (byte) valida("Introduce el mes de la reserva: ",1,12,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Mes de la reserva introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                day = (byte) valida("Introduce el dia de la reserva: ",1,31,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Dia de la reserva introducido incorrecto");
            }
        }while(!bExito);

        fecha.set(year,month,day);

        do {
            bExito = false;
            try {
                hora = (byte) valida("Introduce la hora de la reserva: ",0,23,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Hora de la reserva introducido incorrecto");
            }
        }while(!bExito);

        do {
            bExito = false;
            try {
                minutos = (byte) valida("Introduce el minuto de la reserva: ",0,59,3);
                bExito = true;
            }catch (NumberFormatException exc){
                System.out.println("Error: " + exc.getMessage());
            }catch (Exception exc){
                System.out.println("Error generico: " + exc.getMessage());
            }finally {
                if (!bExito)
                    System.out.println("Minuto de la reserva introducido incorrecto");
            }
        }while(!bExito);

        Reserva reserva = new Reserva(socio,instalacion,fecha,hora,minutos);

        bExito = terminal.add(reserva);

        if (bExito)
            System.out.println("Reserva aniadida con exito");
        else
            System.out.println("Reserva aniadida sin exito");
        return bExito;
    }

    public static byte subMenuReservas(){
        System.out.println("¿Que deseas hacer?");
        System.out.println("*********************************");
        System.out.println("1. Añadir ");
        System.out.println("2. Eliminar ");
        System.out.println("3. Mostrar ");
        System.out.println("4. Volver a menu principal");
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
}
