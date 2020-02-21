package modelo;

public class Instalacion implements IInstalacion {
	
	private byte bUbicacion; // PRIMARY KEY -  Equals - El atributo que realmente identifica a una instalacion
	private byte bTipo; // PRIMARY KEY - Descripcion de la instalacion (Campo OBLIGATORIO)
	private boolean bEstado; // True = Libre - False = Ocupado (Campo OBLIGATORIO)
	
	public Instalacion(byte bUbicacion, byte bTipo) {
		setbUbicacion(bUbicacion);
		setbEstado(true);
		setbTipo(bTipo);
	}

	@Override
	public byte getbUbicacion() {
		return bUbicacion;
	}

	private boolean setbUbicacion(byte bUbicacion) {
		boolean bExito = false;
		if(bUbicacion > 0) {
			this.bUbicacion = bUbicacion;
			bExito = true;
		} else {
			this.bUbicacion = -1;
		}
		return bExito;
	}

	@Override
	public boolean isbEstado() {
		return bEstado;
	}

	@Override
	public void setbEstado(boolean bEstado) {
		this.bEstado = bEstado;
	}

	@Override
	public byte getbTipo() {
		return bTipo;
	}

	private boolean setbTipo(byte bTipo) {
		boolean bExito = false;
		if(bTipo > 0 && bTipo < 4) {
			this.bTipo = bTipo;
			bExito = true;
		} else {
			this.bTipo = -1;
		}
		return bExito;
	}
	
	@Override
	public String cadenabTipo() {
		String sResultado;
		if(this.bTipo == FUTBOL) {
			sResultado = "FUTBOL";
		} else if(this.bTipo == PADEL) {
			sResultado = "PADEL";
		} else if(this.bTipo == BALONCESTO){
			sResultado = "BALONCESTO";
		} else {
			sResultado = "";
		}
		return sResultado;
	}
	
	@Override
	public boolean validarInstalacion() {
		boolean bExito = false;
		if(this.bUbicacion != -1 && this.bTipo != -1) {
			bExito = true;
		}
		return bExito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bTipo;
		result = prime * result + bUbicacion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		Instalacion other = (Instalacion) obj;
		if(this != null && other != null && this.bTipo == other.bTipo && this.bUbicacion == other.bUbicacion) {
			bIgual = true;
		}
		return bIgual;
	}
	
	@Override
	public String toString() {
		String sResultado = "";
		if(validarInstalacion()) {
			sResultado += "Nombre: " + this.cadenabTipo() + " " + this.bUbicacion + "\n";
			sResultado += "Estado de la instalacion: " + this.bEstado + "\n";
		}
		return sResultado;
	}
	
	
	
	
}
