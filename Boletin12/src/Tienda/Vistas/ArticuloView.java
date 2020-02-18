package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Articulo;

import static Libreria.LibreriaValida.*;


public class ArticuloView {
    public static String altaArticulo(Tienda tienda){
        int id = 0;
        String sNombre;
        float precio = 0;
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

        sNombre = leer("Introduce el nombre del articulo: ");

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

        Articulo articulo = new Articulo(id,sNombre,precio);
        if (!(tienda.getArticuloController().add(articulo)))
            sResultado = "El articulo no se ha podido registrar correctamente";
        else
            sResultado = "El articulo se ha podido registrar correctamente";
        return sResultado;
    }
}
