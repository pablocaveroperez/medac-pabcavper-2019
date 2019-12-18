package Clase_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class mainClase_2 {

    public static void main(String[] args) {
        Asignatura vAsignaturas[] = new Asignatura[2];

        vAsignaturas[0] = new Asignatura("Matematicas","Primero",589725);
        vAsignaturas[1] = new Asignatura("Programacion","Segundo",225448);

        for (int i = 0; i < vAsignaturas.length; i++){
            System.out.println(vAsignaturas[i]);
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
                    oResultado = validaNumero(sMensaje, (byte) dMin, (byte) dMax);
                } else if (dMin != -1) {
                    oResultado = validaNumeroMinimo(sMensaje, (byte) dMin);
                } else if (dMax != -1) {
                    oResultado = validaNumeroMaximo(sMensaje, (byte) dMax);
                } else {
                    oResultado = convertirByte(sMensaje);
                }
                break;
            case 4: // short
                if (dMin != -1 && dMax != -1) {
                    oResultado = validaNumero(sMensaje, (short) dMin, (short) dMax);
                } else if (dMin != -1) {
                    oResultado = validaNumeroMinimo(sMensaje, (short) dMin);
                } else if (dMax != -1) {
                    oResultado = validaNumeroMaximo(sMensaje, (short) dMax);
                } else {
                    oResultado = convertirShort(sMensaje);
                }
                break;
        }
        return oResultado;
    }

    /* #################################
     * # VALIDACIÓN DE NUMEROS ENTEROS #
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

    /* ###################################
     * # VALIDACION DE NUMEROS DECIMALES #
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

    /* ##############################
     * # VALIDACION DE NUMEROS BYTE #
     * ##############################
     */

    private static byte validaNumero(String sMensaje, byte fMin, byte fMax) {
        byte bNumero;
        do {
            bNumero = convertirByte(sMensaje);
        } while (bNumero < fMin || bNumero > fMax);
        return bNumero;
    }

    private static byte validaNumeroMinimo(String sMensaje, byte fMin) {
        byte bNumero;
        do {
            bNumero = convertirByte(sMensaje);
        } while (bNumero < fMin);
        return bNumero;
    }

    private static byte validaNumeroMaximo(String sMensaje, byte fMax) {
        byte bNumero;
        do {
            bNumero = convertirByte(sMensaje);
        } while (bNumero > fMax);
        return bNumero;
    }

    private static byte convertirByte(String sMensaje) {
        return Byte.parseByte(leer(sMensaje));
    }

    /* ###############################
     * # VALIDACION DE NUMEROS SHORT #
     * ###############################
     */

    private static short validaNumero(String sMensaje, short fMin, short fMax) {
        short shNumero;
        do {
            shNumero = convertirShort(sMensaje);
        } while (shNumero < fMin || shNumero > fMax);
        return shNumero;
    }

    private static short validaNumeroMinimo(String sMensaje, short fMin) {
        short shNumero;
        do {
            shNumero = convertirShort(sMensaje);
        } while (shNumero < fMin);
        return shNumero;
    }

    private static short validaNumeroMaximo(String sMensaje, short fMax) {
        short shNumero;
        do {
            shNumero = convertirShort(sMensaje);
        } while (shNumero > fMax);
        return shNumero;
    }

    private static short convertirShort(String sMensaje) {
        return Short.parseShort(leer(sMensaje));
    }

}
