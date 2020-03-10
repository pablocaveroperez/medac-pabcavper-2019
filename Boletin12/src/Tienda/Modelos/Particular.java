package Tienda.Modelos;

public class Particular extends Proveedor implements IParticular {
	private String sNombreParticular;
	private String sApellidosParticulas;
	
	public Particular(byte idProveedor) {
		super(idProveedor);
	}
	
	public Particular (byte idProveedor, String sNombre, String sDomicilio, String sTelefono, String sNombreParticular, String sApellidosParticulas) {
		super(idProveedor, sNombre, sDomicilio, sTelefono);
		setsNombreParticular(sNombreParticular);
		setsApellidosParticulas(sApellidosParticulas);
	}
	
	@Override
	public String getsNombreParticular() {
		return sNombreParticular;
	}
	
	@Override
	public boolean setsNombreParticular(String sNombreParticular) {
		boolean bExito = false;
		if (sNombreParticular.length() > 0 && sNombreParticular.length() < 255) {
			this.sNombreParticular = sNombreParticular;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String getsApellidosParticulas() {
		return sApellidosParticulas;
	}
	
	@Override
	public boolean setsApellidosParticulas(String sApellidosParticulas) {
		boolean bExito = false;
		if (sApellidosParticulas.length() > 0 && sApellidosParticulas.length() < 255) {
			this.sApellidosParticulas = sApellidosParticulas;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getIdProveedor();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		if (getIdProveedor() != other.getIdProveedor())
			return false;
		return true;
	}
	
	public String toString() {
		String salida = "";
		salida += super.toString();
		salida += "\nNombre del Particular: " + getsNombreParticular();
		salida += "\nApellidos del Particular: " + getsApellidosParticulas() + "\n";
		return salida;
	}
	
	

}
