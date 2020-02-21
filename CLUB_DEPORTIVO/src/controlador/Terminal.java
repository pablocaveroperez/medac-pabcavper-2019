package controlador;

import modelo.Reserva;

public class Terminal {

	InstalacionController instController;
	SocioController socController;
	ReservaController resController;

	public Terminal() {
		instController = new InstalacionController();
		socController = new SocioController();
		resController = new ReservaController();
	}

	public InstalacionController getInstController() {
		return instController;
	}
	
	public SocioController getSocController() {
		return socController;
	}
	
	public ReservaController getResController() {
		return resController;
	}
	
	public boolean add(Reserva oReserva) {
		boolean bExito = false;
		if(socController.search(oReserva.getoSocio()) != -1 && instController.search(oReserva.getoInstalacion()) != -1) {
			bExito = resController.add(oReserva);
		}
		return bExito;
	}
}
