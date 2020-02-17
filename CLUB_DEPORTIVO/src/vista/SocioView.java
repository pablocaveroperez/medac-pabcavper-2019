package vista;

import controlador.Terminal;
import medac.validaciones.LibFrontend;
import modelo.Socio;

public class SocioView {
	public static String altaSocio(Terminal t) {
		String sDni,sNombre, sResultado;
		sDni = LibFrontend.leer("Introduce un DNI de un socio: ");
		sNombre = LibFrontend.leer("Introduce un nombre de un socio: ");
		Socio oSocio = new Socio(sDni,sNombre);
		if(t.getSocController().add(oSocio)) {
			sResultado = "El socio se ha registrado correctamente.";
		} else {
			sResultado = "El socio no se ha podido registrar.";
		}
		return sResultado;
	}
	
}
