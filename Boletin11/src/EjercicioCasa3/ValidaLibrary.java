package EjercicioCasa3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ValidaLibrary {
    public static String leer(String sMensaje) {
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

    private static int numeroEntero(int iNumero, int iMin, int iMax) {
        do {
            iNumero = Integer.parseInt(leer("Introduce un número entero"));
        } while (iNumero < iMin || iNumero > iMax);
        return iNumero;
    }

    private static byte numeroEntero(byte bNumero, byte bMin, byte bMax) {
        do {
            bNumero = Byte.parseByte(leer("Introduzca números a mostrar"));
        } while (bNumero < bMin || bNumero > bMax);
        return bNumero;
    }

    private static float numeroDecimal(float fNumero, float fMin, float fMax) {
        do {
            fNumero = Float.parseFloat(leer("Introduce un número decimal"));
        } while (fNumero < fMin || fNumero > fMax);
        return fNumero;
    }

    public static Object valida(String sMensaje, double dMin, double dMax, int iTipoDato) {
        Object oResultado = 0;

        switch (iTipoDato) {
            case 1: // int
                if (dMin != -1 && dMax != -1) {
                    oResultado = validaNumero(sMensaje, (int) dMin, (int) dMax);
                } else if (dMin != -1) {
                    oResultado = validaNumeroMinimo(sMensaje, (int) dMin);
                } else if (dMax != -1) {
                    oResultado = validaNumeroMaximo(sMensaje, (int) dMax);
                } else {
                    oResultado = convertirEntero(sMensaje);
                }
                break;
            case 2: // float
                if (dMin != -1 && dMax != -1) {
                    oResultado = validaNumero(sMensaje, (float) dMin, (float) dMax);
                } else if (dMin != -1) {
                    oResultado = validaNumeroMinimo(sMensaje, (float) dMin);
                } else if (dMax != -1) {
                    oResultado = validaNumeroMaximo(sMensaje, (float) dMax);
                } else {
                    oResultado = convertirDecimal(sMensaje);
                }
                break;
            case 3: // byte
                if (dMin != -1 && dMax != -1) {
                    oResultado = validaNumeroByte(sMensaje, (byte) dMin, (byte) dMax);
                } else if (dMin != -1) {
                    oResultado = validaNumeroMinimo(sMensaje, (byte) dMin);
                } else if (dMax != -1) {
                    oResultado = validaNumeroMaximo(sMensaje, (byte) dMax);
                } else {
                    oResultado = convertirEnteroByte(sMensaje);
                }
                break;
            case 4: // short
                if (dMin != -1 && dMax != -1) {
                    oResultado = validaNumeroShort(sMensaje, (short) dMin, (short) dMax);
                } else if (dMin != -1) {
                    oResultado = validaNumeroMinimo(sMensaje, (short) dMin);
                } else if (dMax != -1) {
                    oResultado = validaNumeroMaximo(sMensaje, (short) dMax);
                } else {
                    oResultado = convertirEnteroShort(sMensaje);
                }
                break;
            case 5: // double
                if (dMin != -1 && dMax != -1) {
                    oResultado = validaNumeroDouble(sMensaje, (double) dMin, (double) dMax);
                } else if (dMin != -1) {
                    oResultado = validaNumeroMinimo(sMensaje, (double) dMin);
                } else if (dMax != -1) {
                    oResultado = validaNumeroMaximo(sMensaje, (double) dMax);
                } else {
                    oResultado = convertirDecimal(sMensaje);
                }
                break;
        }

        return oResultado;
    }

    /*
     * ################################# # VALIDACIÓN DE NUMEROS DOUBLE #
     * #################################
     */

    private static double validaNumeroDouble(String sMensaje, double dMin, double dMax) {
        double dNumero;
        do {
            dNumero = convertirDecimal(sMensaje);
        } while (dNumero < dMin || dNumero > dMax);
        return dNumero;
    }
    private static double validaNumeroMaximo(String sMensaje, double dMax) {
        double dNumero;
        do {
            dNumero = convertirDecimal(sMensaje);
        } while (dNumero > dMax);
        return dNumero;
    }
    private static double validaNumeroMinimo(String sMensaje, double dMin) {
        double dNumero;
        do {
            dNumero = convertirDecimal(sMensaje);
        } while (dNumero < dMin);
        return dNumero;
    }

    /*
     * ################################# # VALIDACIÓN DE NUMEROS ENTEROS #
     * #################################
     */
    private static int validaNumero(String sMensaje, int iMin, int iMax) {
        int iNumero;
        do {
            iNumero = convertirEntero(sMensaje);
        } while (iNumero < iMin || iNumero > iMax);
        return iNumero;
    }


    private static int validaNumeroMaximo(String sMensaje, int iMax) {
        int iNumero;
        do {
            iNumero = convertirEntero(sMensaje);
        } while (iNumero > iMax);
        return iNumero;
    }

    private static int validaNumeroMinimo(String sMensaje, int iMin) {
        int iNumero;
        do {
            iNumero = convertirEntero(sMensaje);
        } while (iNumero < iMin);
        return iNumero;
    }

    private static int convertirEntero(String sMensaje) {
        return Integer.parseInt(leer(sMensaje));
    }

    /*
     * ############################## # VALIDACIÓN DE NUMEROS BYTE #
     * ##############################
     */
    private static byte validaNumeroByte(String sMensaje, byte bMin, byte bMax) {
        byte bNumero;
        do {
            bNumero = convertirEnteroByte(sMensaje);
        } while (bNumero < bMin || bNumero > bMax);
        return bNumero;
    }

    private static byte validaNumeroMaximo(String sMensaje, byte bMax) {
        byte bNumero;
        do {
            bNumero = convertirEnteroByte(sMensaje);
        } while (bNumero > bMax);
        return bNumero;
    }

    private static byte validaNumeroMinimo(String sMensaje, byte bMin) {
        byte bNumero;
        do {
            bNumero = convertirEnteroByte(sMensaje);
        } while (bNumero < bMin);
        return bNumero;
    }

    private static byte convertirEnteroByte(String sMensaje) {
        return Byte.parseByte(leer(sMensaje));
    }

    /*
     * ############################## # VALIDACIÓN DE NUMEROS SHORT #
     * ##############################
     */
    private static short validaNumeroShort(String sMensaje, short shMin, short shMax) {
        short shNumero;
        do {
            shNumero = convertirEnteroShort(sMensaje);
        } while (shNumero < shMin || shNumero > shMax);
        return shNumero;
    }

    private static short validaNumeroMaximo(String sMensaje, short shMax) {
        short shNumero;
        do {
            shNumero = convertirEnteroShort(sMensaje);
        } while (shNumero > shMax);
        return shNumero;
    }

    private static short validaNumeroMinimo(String sMensaje, short shMin) {
        short shNumero;
        do {
            shNumero = convertirEnteroShort(sMensaje);
        } while (shNumero < shMin);
        return shNumero;
    }

    private static short convertirEnteroShort(String sMensaje) {
        return Short.parseShort(leer(sMensaje));
    }

    /*
     * ################################### # VALIDACION DE NUMEROS DECIMALES #
     * ###################################
     */
    private static float validaNumero(String sMensaje, float fMin, float fMax) {
        float fNumero;
        do {
            fNumero = convertirDecimal(sMensaje);
        } while (fNumero < fMin || fNumero > fMax);
        return fNumero;
    }

    private static float validaNumeroMinimo(String sMensaje, float fMin) {
        float fNumero;
        do {
            fNumero = convertirDecimal(sMensaje);
        } while (fNumero < fMin);
        return fNumero;
    }

    private static float validaNumeroMaximo(String sMensaje, float fMax) {
        float fNumero;
        do {
            fNumero = convertirDecimal(sMensaje);
        } while (fNumero > fMax);
        return fNumero;
    }

    private static float convertirDecimal(String sMensaje) {
        return Float.parseFloat(leer(sMensaje));
    }
}
