package controlador;

import modelo.Reserva;

public class ReservaController implements ICrud<Reserva> {
	private Reserva aReserva[];
	private byte bContadorReservas;
	private final int MAXRESERVAS = 100;
	
	public ReservaController() {
		aReserva = new Reserva[MAXRESERVAS];
		bContadorReservas = 0;
	}

	@Override
	public Reserva[] getaVector() {
		return aReserva;
	}

	@Override
	public byte getbContadorArray() {
		return bContadorReservas;
	}

	@Override
	public boolean add(Reserva oObject) {
		boolean bExito = false;
		if(oObject.validarReserva() && bContadorReservas < MAXRESERVAS && search(oObject) == -1) {
			aReserva[bContadorReservas] = oObject;
			bContadorReservas++;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public boolean remove(Reserva oObject) {
		boolean bExito = false;
		int iPosicion = search(oObject);
		if(iPosicion != -1) {
			for(int i=iPosicion+1; i<bContadorReservas; i++) {
				aReserva[i-1] = aReserva[i];	
			}
			aReserva[bContadorReservas] = null;
			bContadorReservas--;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public int search(Reserva oObject) {
		int iPosicion = -1;
		int iContador = 0;
		while(iPosicion == -1 && iContador < bContadorReservas) {
			if(oObject.equals(aReserva[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
}
