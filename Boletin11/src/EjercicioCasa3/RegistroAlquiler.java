package EjercicioCasa3;

public class RegistroAlquiler {
    private Alquiler[] alquilers;
    private int iContAlquileres;

    public RegistroAlquiler(int numAlquileres) {
        alquilers = new Alquiler[numAlquileres];
        setiContAlquileres(0);
    }

    // Metodos getters y setters
    public Alquiler[] getAlquilers() {
        return alquilers;
    }

    public void setAlquilers(Alquiler[] alquilers) {
        this.alquilers = alquilers;
    }

    public int getiContAlquileres() {
        return iContAlquileres;
    }

    public void setiContAlquileres(int iContAlquileres) {
        this.iContAlquileres = iContAlquileres;
    }

    // #####################
    // # INTERFACE METHODS #
    // #####################

    public int searchPosition(Alquiler oObjeto) {
        int iPosicion = -1;
        int iContador = 0;
        while (iPosicion == -1 && iContador < alquilers.length) {
            if (oObjeto.equals(alquilers[iContador])) {
                iPosicion = iContador;
            }
            iContador++;
        }
        return iPosicion;
    }

    public Alquiler searchObject(Alquiler oObjeto) {
        Alquiler oDevolver = null;
        int iContador = 0;
        while (oDevolver == null && iContador < alquilers.length) {
            if (oObjeto.equals(alquilers[iContador])) {
                oDevolver = alquilers[iContador];
            }
            iContador++;
        }
        return oDevolver;
    }

    public boolean add(Alquiler oObjeto) {
        boolean bExito = false;
        if (iContAlquileres < alquilers.length && searchPosition(oObjeto) == -1) {
            alquilers[iContAlquileres] = oObjeto;
            setiContAlquileres(iContAlquileres + 1);
            bExito = true;
        }
        return bExito;
    }

    public Alquiler read(Alquiler oObjeto) {
        return searchObject(oObjeto);
    }

    public boolean update(Alquiler oObjeto) {
        boolean bExito = false;
        int iPosicion = searchPosition(oObjeto);
        if (iPosicion != -1) {
            alquilers[iPosicion] = oObjeto;
            bExito = true;
        }
        return bExito;
    }

    public boolean delete(Alquiler oObjeto) {
        boolean bExito = false;
        int iPosicion = searchPosition(oObjeto);
        if (iPosicion != -1) {
            for (int iCont = iPosicion + 1; iCont < alquilers.length; iCont++) {
                alquilers[iCont - 1] = alquilers[iCont];
            }
            alquilers[alquilers.length - 1] = null;
            setiContAlquileres(iContAlquileres - 1);
            bExito = true;
        }
        return bExito;
    }

    public String printAll() {
        String sResultado = "";

        if (iContAlquileres == 0) {
            sResultado = "No hay alquileres registrados en la aplicacion.";
        } else {
            for (int iCont = 0; iCont < iContAlquileres; iCont++) {
                sResultado += alquilers[iCont] + "\n";
            }
        }
        return sResultado;
    }
}
