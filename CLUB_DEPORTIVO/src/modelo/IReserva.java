package modelo;

import java.util.Calendar;

public interface IReserva {

	public byte getbMinutos();
	public byte getbHora();
	public Calendar getcFecha();
	public Instalacion getoInstalacion();
	public Socio getoSocio();
	public boolean validarReserva();
}
