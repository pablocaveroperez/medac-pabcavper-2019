package Club.Controladores;

import Club.Modelos.Reserva;

public class ReservaController implements ICrud<Reserva> {
    private byte contadorReservas;
    private Reserva[] vReservas;
    private final byte MAXRESERVAS = 50;

    public ReservaController() {
        vReservas = new Reserva[MAXRESERVAS];
        contadorReservas = 0;
    }

    @Override
    public Reserva[] getaVector() {
        return vReservas;
    }

    @Override
    public byte getbContadorArray() {
        return contadorReservas;
    }

    @Override
    public boolean add(Reserva oObject) {
        boolean bExito = false;
        if (oObject.reservaValida() && contadorReservas < MAXRESERVAS && search(oObject) == -1){
            vReservas[contadorReservas] = oObject;
            contadorReservas++;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean remove(Reserva oObject) {
        boolean bExito = false;
        int iPosicion = search(oObject);
        if (iPosicion != 1) {
            for (int i = iPosicion; i < contadorReservas; i++)
                vReservas[i] = vReservas[i+1];
            vReservas[contadorReservas] = null;
            contadorReservas--;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int search(Reserva oObject) {
        int iPosicion = -1;
        int iContador = 0;
        while (iPosicion == -1 && iContador < contadorReservas){
            if (oObject.equals(vReservas[iContador]))
                iPosicion = iContador;
        }
        return iPosicion;
    }

    @Override
    public String printAll() {
        String salida = "";
        if (contadorReservas == 0)
            salida += "No hay reservas registradas.";
        else{
            for (int i = 0; i < contadorReservas; i++)
                salida += vReservas[i] + "\n";
        }
        return salida;
    }

    @Override
    public boolean update(Reserva oObjeto, int iPosicion) {
        boolean bExito = false;
        if (iPosicion != -1){
            vReservas[iPosicion] = oObjeto;
            bExito = true;
        }
        return bExito;
    }
}
