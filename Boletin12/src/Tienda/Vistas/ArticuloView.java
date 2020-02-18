package Tienda.Vistas;

import Tienda.Controladores.Tienda;
import Tienda.Modelos.Articulo;

import static medac.validaciones.LibFrontend.*;

public class ArticuloView {
    public static String altaArticulo(Tienda tienda){
        int id;
        String sNombre;
        float precio;
        String sResultado;

        id = (int) valida("Instroduce el ID del articulo: ",0,-1,1);
        sNombre = leer("Introduce el nombre del articulo: ");
        precio = (float) valida("Introduce el precio del articulo: ",0,500,2);

        Articulo articulo = new Articulo(id,sNombre,precio);
        if (!(tienda.getArticuloController().add(articulo)))
            sResultado = "El articulo no se ha podido registrar correctamente";
        else
            sResultado = "El articulo se ha podido registrar correctamente";
    }
}
