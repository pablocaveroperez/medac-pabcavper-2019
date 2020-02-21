package modelo;

public class Socio implements ISocio {
	private String sDni, sNombre;
	
	public Socio(String sDni, String sNombre) {
		setsDni(sDni);
		setsNombre(sNombre);
	}
	
	public Socio(String sDni) {
		setsDni(sDni);
	}
	
	@Override
	public String getsDni() {
		return sDni;
	}

	private boolean setsDni(String sDni) {
		boolean bExito = false;
		if(sDni.length() == 9) {
			this.sDni = sDni;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getsNombre() {
		return sNombre;
	}

	@Override
	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sDni == null) ? 0 : sDni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean bExito = false;
		Socio other = (Socio) obj;
		if (this != null && other != null && other.sDni.equals(this.sDni)) {
			bExito = true;
		}
		return bExito;
	}
	
	public String toString() {
		String sResultado = "";
		if(this.sDni != null) {
			sResultado += "DNI: " + this.sDni + "\n";
			sResultado += "Nombre: " + this.sNombre + "\n";
		}
		return sResultado;
	}
}
