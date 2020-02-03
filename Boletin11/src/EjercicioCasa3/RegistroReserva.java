package EjercicioCasa3;

public class RegistroReserva {
    private Reserva[] reservas;
    private int iContReservas;

    public RegistroReserva(int numReservas) {
        reservas = new Alquiler[numReservas];
        setiContReservas(0);
    }

    // Metodos getters y setters
    public Reserva[] getReservas() {
        return reservas;
    }

    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }

    public int getiContReservas() {
        return iContReservas;
    }

    public void setiContReservas(int iContReservas) {
        this.iContReservas = iContReservas;
    }

    // #####################
    // # INTERFACE METHODS #
    // #####################

    public int searchPosition(Reserva oObjeto) {
        int iPosicion = -1;
        int iContador = 0;
        while (iPosicion == -1 && iContador < reservas.length) {
            if (oObjeto.equals(reservas[iContador])) {
                iPosicion = iContador;
            }
            iContador++;
        }
        return iPosicion;
    }

    public Reserva searchObject(Reserva oObjeto) {
        Reserva oDevolver = null;
        int iContador = 0;
        while (oDevolver == null && iContador < reservas.length) {
            if (oObjeto.equals(reservas[iContador])) {
                oDevolver = reservas[iContador];
            }
            iContador++;
        }
        return oDevolver;
    }

    public boolean add(Reserva oObjeto) {
        boolean bExito = false;
        if (iContReservas < reservas.length && searchPosition(oObjeto) == -1) {
            reservas[iContReservas] = oObjeto;
            setiContReservas(iContReservas + 1);
            bExito = true;
        }
        return bExito;
    }

    public Reserva read(Reserva oObjeto) {
        return searchObject(oObjeto);
    }

    public boolean update(Reserva oObjeto) {
        boolean bExito = false;
        int iPosicion = searchPosition(oObjeto);
        if (iPosicion != -1) {
            reservas[iPosicion] = oObjeto;
            bExito = true;
        }
        return bExito;
    }

    public boolean delete(Reserva oObjeto) {
        boolean bExito = false;
        int iPosicion = searchPosition(oObjeto);
        if (iPosicion != -1) {
            for (int iCont = iPosicion + 1; iCont < reservas.length; iCont++) {
                reservas[iCont - 1] = reservas[iCont];
            }
            reservas[reservas.length - 1] = null;
            setiContReservas(iContReservas - 1);
            bExito = true;
        }
        return bExito;
    }

    public String printAll() {
        String sResultado = "";

        if (iContReservas == 0) {
            sResultado = "No hay reservas registradas en la aplicacion.";
        } else {
            for (int iCont = 0; iCont < iContReservas; iCont++) {
                sResultado += reservas[iCont] + "\n";
            }
        }
        return sResultado;
    }
}

