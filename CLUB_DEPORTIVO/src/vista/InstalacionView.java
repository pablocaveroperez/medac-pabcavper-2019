package vista;

import controlador.Terminal;
import medac.validaciones.LibFrontend;
import modelo.Instalacion;

public class InstalacionView{
	
	public static String altaInstalacion(Terminal t) {
		byte bTipo = -1, bUbicacion = -1;
		String sResultado;
		boolean errorControl = true;
		System.out.println("1. Futbol.");
		System.out.println("2. Padel.");
		System.out.println("3. Baloncesto.");

		while (errorControl) {
			try {
				bTipo = (byte) LibFrontend.valida("Introduce un número de tipo de instalacion (1-3): ", 1, 3, 3);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println("Error: " + ex.getMessage());
			} catch (Exception ex) {
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		errorControl = true;
		while (errorControl) {
			try {
				bUbicacion = (byte) LibFrontend.valida("Introduce un numero de ubicacion: ", 0, -1, 3);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println("Error: " + ex.getMessage());
			} catch (Exception ex) {
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		Instalacion oInst = new Instalacion(bUbicacion, bTipo);
		
		if(t.getInstController().add(oInst)) {
			sResultado = "La instalacion se ha registrado con exito.";
		}else {
			sResultado = "La instalacion no se ha registrado.";
		}
		return sResultado;
	}

}
