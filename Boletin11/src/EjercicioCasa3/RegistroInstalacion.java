package EjercicioCasa3;

public class RegistroInstalacion {
    private Instalacion[] instalacions;
    private int iContInstalaciones;

    public RegistroInstalacion(int numInstalaciones) {
        instalacions = new Instalacion[numInstalaciones];
        setiContInstalaciones(0);
    }

    // Metodos getters y setters
    public Instalacion[] getInstalacions() {
        return instalacions;
    }

    public void setInstalacions(Instalacion[] instalacions) {
        this.instalacions = instalacions;
    }

    public int getiContInstalaciones() {
        return iContInstalaciones;
    }

    public void setiContInstalaciones(int iContInstalaciones) {
        this.iContInstalaciones = iContInstalaciones;
    }

    // #####################
    // # INTERFACE METHODS #
    // #####################

    public int searchPosition(Instalacion oObjeto) {
        int iPosicion = -1;
        int iContador = 0;
        while (iPosicion == -1 && iContador < instalacions.length) {
            if (oObjeto.equals(instalacions[iContador])) {
                iPosicion = iContador;
            }
            iContador++;
        }
        return iPosicion;
    }

    public Instalacion searchObject(Instalacion oObjeto) {
        Instalacion oDevolver = null;
        int iContador = 0;
        while (oDevolver == null && iContador < instalacions.length) {
            if (oObjeto.equals(instalacions[iContador])) {
                oDevolver = instalacions[iContador];
            }
            iContador++;
        }
        return oDevolver;
    }

    public boolean add(Instalacion oObjeto) {
        boolean bExito = false;
        if (iContInstalaciones < instalacions.length && searchPosition(oObjeto) == -1) {
            instalacions[iContInstalaciones] = oObjeto;
            setiContInstalaciones(iContInstalaciones + 1);
            bExito = true;
        }
        return bExito;
    }

    public Instalacion read(Instalacion oObjeto) {
        return searchObject(oObjeto);
    }

    public boolean update(Instalacion oObjeto) {
        boolean bExito = false;
        int iPosicion = searchPosition(oObjeto);
        if (iPosicion != -1) {
            instalacions[iPosicion] = oObjeto;
            bExito = true;
        }
        return bExito;
    }

    public boolean delete(Instalacion oObjeto) {
        boolean bExito = false;
        int iPosicion = searchPosition(oObjeto);
        if (iPosicion != -1) {
            for (int iCont = iPosicion + 1; iCont < instalacions.length; iCont++) {
                instalacions[iCont - 1] = instalacions[iCont];
            }
            instalacions[instalacions.length - 1] = null;
            setiContInstalaciones(iContInstalaciones - 1);
            bExito = true;
        }
        return bExito;
    }

    public String printAll() {
        String sResultado = "";

        if (iContInstalaciones == 0) {
            sResultado = "No hay instalaciones registradas en la aplicacion.";
        } else {
            for (int iCont = 0; iCont < iContInstalaciones; iCont++) {
                sResultado += instalacions[iCont] + "\n";
            }
        }
        return sResultado;
    }
}
