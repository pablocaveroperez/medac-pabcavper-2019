package EjercicioCasa6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class mainProducto {

    public static void main(String[] args) {
        int iNumElementos, iUnidades;
        float fPrecio;
        String sNombre;
        Producto vProds[];

        iNumElementos = (int)valida("Cuantos productos quieres crear: ",1,5,1);

        vProds = new Producto[iNumElementos];

        for(int i=0; i < iNumElementos;i++) {
            sNombre = leer("Introduce un nombre de producto: ");
            fPrecio = (float)valida("Introduce un precio de producto: ",1,50,2);
            iUnidades = (int)valida("Introduce unidades de producto: ",1,50,1);
            vProds[i] = new Producto(sNombre,fPrecio,iUnidades);
        }

        for(int i=0; i < vProds.length; i++) {
            System.out.println(vProds[i]);
        }
    }

    private static String leer(String sMensaje) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String cadenaLeida;

        System.out.println(sMensaje);
        try {
            cadenaLeida = teclado.readLine();
        } catch (Exception e) {
            cadenaLeida = "";
        }
        return cadenaLeida;
    }

    private static Object valida(String sMensaje, double dMin, double dMax, int iTipoDato) {
        Object oResultado = null;

        switch(iTipoDato) {
            case 1: // int
                if(dMin != -1 && dMax != -1) {
                    oResultado = validaNumero(sMensaje,(int)dMin,(int)dMax);
                }else if(dMin != -1) {
                    oResultado = validaNumeroMinimo(sMensaje,(int)dMin);
                }else if(dMax != -1) {
                    oResultado = validaNumeroMaximo(sMensaje,(int)dMax);
                }else {
                    oResultado = convertirEntero(sMensaje);
                }
                break;
            case 2: // float
                if(dMin != -1 && dMax != -1) {
                    oResultado = validaNumero(sMensaje,(float)dMin,(float)dMax);
                }else if(dMin != -1) {
                    oResultado = validaNumeroMinimo(sMensaje,(float)dMin);
                }else if(dMax != -1) {
                    oResultado = validaNumeroMaximo(sMensaje,(float)dMax);
                }else {
                    oResultado = convertirDecimal(sMensaje);
                }
                break;
        }

        return oResultado;
    }

    /*
     * #################################
     * # VALIDACIÓN DE NUMEROS ENTEROS #
     * #################################
     */
    private static int validaNumero(String sMensaje, int iMin, int iMax) {
        int iNumero;
        do {
            iNumero = convertirEntero(sMensaje);
        }while(iNumero < iMin || iNumero > iMax);
        return iNumero;
    }

    private static int validaNumeroMaximo(String sMensaje, int iMax) {
        int iNumero;
        do {
            iNumero = convertirEntero(sMensaje);
        }while(iNumero > iMax);
        return iNumero;
    }

    private static int validaNumeroMinimo(String sMensaje, int iMin) {
        int iNumero;
        do {
            iNumero = convertirEntero(sMensaje);
        }while(iNumero < iMin);
        return iNumero;
    }

    private static int convertirEntero(String sMensaje) {
        return Integer.parseInt(leer(sMensaje));
    }

    /*
     * ###################################
     * # VALIDACION DE NUMEROS DECIMALES #
     * ###################################
     */
    private static float validaNumero(String sMensaje, float fMin, float fMax) {
        float fNumero;
        do {
            fNumero = convertirDecimal(sMensaje);
        }while(fNumero < fMin || fNumero > fMax);
        return fNumero;
    }

    private static float validaNumeroMinimo(String sMensaje, float fMin) {
        float fNumero;
        do {
            fNumero = convertirDecimal(sMensaje);
        }while(fNumero < fMin);
        return fNumero;
    }

    private static float validaNumeroMaximo(String sMensaje, float fMax) {
        float fNumero;
        do {
            fNumero = convertirDecimal(sMensaje);
        }while(fNumero > fMax);
        return fNumero;
    }

    private static float convertirDecimal(String sMensaje) {
        return Float.parseFloat(leer(sMensaje));
    }

}
