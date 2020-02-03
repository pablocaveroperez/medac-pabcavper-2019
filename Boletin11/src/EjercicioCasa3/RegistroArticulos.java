package EjercicioCasa3;

public class RegistroArticulos {
    private Articulo[] articulos;
    private int iContArticulos;

    public RegistroArticulos(int numArticulos) {
        articulos = new Articulo[numArticulos];
        setiContArticulos(0);
    }

    // Metodos getters y setters
    public Articulo[] getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulo[] articulos) {
        this.articulos = articulos;
    }

    public int getiContArticulos() {
        return iContArticulos;
    }

    public void setiContArticulos(int iContArticulos) {
        this.iContArticulos = iContArticulos;
    }

    // #####################
    // # INTERFACE METHODS #
    // #####################

    public int searchPosition(Articulo oObjeto) {
        int iPosicion = -1;
        int iContador = 0;
        while (iPosicion == -1 && iContador < articulos.length) {
            if (oObjeto.equals(articulos[iContador])) {
                iPosicion = iContador;
            }
            iContador++;
        }
        return iPosicion;
    }

    public Articulo searchObject(Articulo oObjeto) {
        Articulo oDevolver = null;
        int iContador = 0;
        while (oDevolver == null && iContador < articulos.length) {
            if (oObjeto.equals(articulos[iContador])) {
                oDevolver = articulos[iContador];
            }
            iContador++;
        }
        return oDevolver;
    }

    public boolean add(Articulo oObjeto) {
        boolean bExito = false;
        if (iContArticulos < articulos.length && searchPosition(oObjeto) == -1) {
            articulos[iContArticulos] = oObjeto;
            setiContArticulos(iContArticulos + 1);
            bExito = true;
        }
        return bExito;
    }

    public Articulo read(Articulo oObjeto) {
        return searchObject(oObjeto);
    }

    public boolean update(Articulo oObjeto) {
        boolean bExito = false;
        int iPosicion = searchPosition(oObjeto);
        if (iPosicion != -1) {
            articulos[iPosicion] = oObjeto;
            bExito = true;
        }
        return bExito;
    }

    public boolean delete(Articulo oObjeto) {
        boolean bExito = false;
        int iPosicion = searchPosition(oObjeto);
        if (iPosicion != -1) {
            for (int iCont = iPosicion + 1; iCont < articulos.length; iCont++) {
                articulos[iCont - 1] = articulos[iCont];
            }
            articulos[articulos.length - 1] = null;
            setiContArticulos(iContArticulos - 1);
            bExito = true;
        }
        return bExito;
    }

    public String printAll() {
        String sResultado = "";

        if (iContArticulos == 0) {
            sResultado = "No hay articulos registrados en la aplicacion.";
        } else {
            for (int iCont = 0; iCont < iContArticulos; iCont++) {
                sResultado += articulos[iCont] + "\n";
            }
        }
        return sResultado;
    }
}
