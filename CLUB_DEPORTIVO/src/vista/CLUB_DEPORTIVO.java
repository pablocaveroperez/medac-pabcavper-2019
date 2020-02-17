package vista;

import java.util.Calendar;
import java.util.GregorianCalendar;

import controlador.Terminal;
import modelo.Instalacion;
import modelo.Reserva;
import modelo.Socio;
import medac.validaciones.LibFrontend;
import vista.SocioView;
import vista.InstalacionView;

public class CLUB_DEPORTIVO {

	public static void main(String[] args) {
	
		Terminal t = new Terminal();
		// Alta de socio
		System.out.println(SocioView.altaSocio(t));
		System.out.println("Numero de socios registros: "+t.getSocController().getbContadorArray());

		// Instalaciones
		System.out.println(InstalacionView.altaInstalacion(t));
		System.out.println("Numero de instalaciones registradas: "+t.getInstController().getbContadorArray());
		
		//Reserva
		Calendar calendar = new GregorianCalendar();
		calendar.set(2008, 2, 6);
		
		/*Reserva oReserva = new Reserva(oSocio,oInst,calendar,(byte)10,(byte)30);

		if(t.add(oReserva)) {
			System.out.println("Reserva añadida con exito");
		}else {
			System.out.println("No se ha registrado la reserva.");
		}*/
		
		System.out.println("Numero de reservas registradas: "+t.getResController().getbContadorArray());

	}
}
