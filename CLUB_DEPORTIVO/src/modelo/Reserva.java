package modelo;

import java.util.Calendar;

public class Reserva implements IReserva {

	private Socio oSocio;
	private Instalacion oInstalacion;
	private Calendar cFecha;
	private byte bHora, bMinutos;

	public Reserva(Socio oSocio, Instalacion oInstalacion, Calendar cFecha, byte bHora, byte bMinutos) {
		setoSocio(oSocio);
		setoInstalacion(oInstalacion);
		setcFecha(cFecha);
		setbHora(bHora);
		setbMinutos(bMinutos);
	}

	@Override
	public Socio getoSocio() {
		return oSocio;
	}

	private void setoSocio(Socio oSocio) {
		this.oSocio = oSocio;
	}

	@Override
	public Instalacion getoInstalacion() {
		return oInstalacion;
	}

	private void setoInstalacion(Instalacion oInstalacion) {
		this.oInstalacion = oInstalacion;
	}

	@Override
	public Calendar getcFecha() {
		return cFecha;
	}

	private void setcFecha(Calendar cFecha) {
		this.cFecha = cFecha;
	}

	@Override
	public byte getbHora() {
		return bHora;
	}

	private boolean setbHora(byte bHora) {
		boolean bExito = false;
		if (bHora >= 0 && bHora < 24) {
			this.bHora = bHora;
			bExito = true;
		} else {
			this.bHora = -1;
		}
		return bExito;
	}

	@Override
	public byte getbMinutos() {
		return bMinutos;
	}

	private boolean setbMinutos(byte bMinutos) {
		boolean bExito = false;
		if (bMinutos >= 0 && bMinutos < 60) {
			this.bMinutos = bMinutos;
			bExito = true;
		} else {
			this.bMinutos = -1;
		}
		return bExito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bHora;
		result = prime * result + bMinutos;
		result = prime * result + ((cFecha == null) ? 0 : cFecha.hashCode());
		result = prime * result + ((oInstalacion == null) ? 0 : oInstalacion.hashCode());
		result = prime * result + ((oSocio == null) ? 0 : oSocio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Reserva other = (Reserva) obj;
		if (this != null && other != null && this.oInstalacion.equals(other.oInstalacion)
				&& this.cFecha.equals(other.cFecha)) {
			if ((this.bHora + 1 == other.bHora && other.bMinutos < this.bMinutos)
					|| (this.bHora - 1 == other.bHora && other.bMinutos > this.bMinutos)
					|| (this.bHora == other.bHora)) {
				bExito = true;
			}
		}
		return bExito;
	}

	public String toString() {
		String sResultado = "";
		if (this.validarReserva()) {
			sResultado += "Socio de la reserva: \n" + this.oSocio.toString() + "\n";
			sResultado += "Instalacion de la reserva: \n" + this.oInstalacion.toString() + "\n";
			sResultado += "Fecha de la reserva: " + cFecha.get(Calendar.DAY_OF_MONTH) + "/" + cFecha.get(Calendar.MONTH)
					+ "/" + cFecha.get(Calendar.YEAR) + "   -   " + this.bHora + ":" + this.bMinutos + "\n";
		}
		return sResultado;
	}

	@Override
	public boolean validarReserva() {
		boolean bExito = false;
		if (this.bHora != -1 && this.bMinutos != -1 && !cFecha.equals(null) && oInstalacion.validarInstalacion()
				&& this.oSocio.getsDni() != null) {
			bExito = true;
		}
		return bExito;
	}
}
