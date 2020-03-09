package Tienda.Modelos;

public abstract class Proveedor implements IProveedor {
	private byte idProveedor;
	private String sNombre;
	private String sDomicilio;
	private String sTelefono;
	
	public Proveedor() {}
	
	public Proveedor(byte idProveedor) {
		setIdProveedor(idProveedor);
	}
	
	public Proveedor(byte idProveedor, String sNombre, String sDomicilio, String sTelefono) {
		setIdProveedor(idProveedor);
		setsNombre(sNombre);
		setsDomicilio(sDomicilio);
		setsTelefono(sTelefono);
	}

	@Override
	public byte getIdProveedor() {
		return idProveedor;
	}

	private boolean setIdProveedor(byte idProveedor) {
		boolean bExito = false;
		if (idProveedor > 0) {
			this.idProveedor = idProveedor;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public String getsNombre() {
		return sNombre;
	}

	@Override
	public boolean setsNombre(String sNombre) {
		boolean bExito = false;
		if (sNombre.length() > 0 && sNombre.length() < 255) {
			this.sNombre = sNombre;
			bExito = true;
		}
		return bExito;		
	}

	@Override
	public String getsDomicilio() {
		return sDomicilio;
	}

	@Override
	public boolean setsDomicilio(String sDomicilio) {
		boolean bExito = false;
		if (sDomicilio.length() > 0 && sDomicilio.length() < 255) {
			this.sDomicilio = sDomicilio;
			bExito = true;
		}
		return bExito;	
	}

	@Override
	public String getsTelefono() {
		return sTelefono;
	}

	@Override
	public boolean setsTelefono(String sTelefono) {
		boolean bExito = false;
		if (sTelefono.length() == 9) {
			this.sTelefono = sTelefono;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProveedor;
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
		if (idProveedor != other.idProveedor)
			return false;
		return true;
	}
	
	public String toString() {
		String salida = "";
		salida += "**********************************";
		salida += "\nID del proveedor: " + getIdProveedor();
		salida += "\nNombre del proveedor: " + getsNombre();
		salida += "\nDomicilio del proveedor: " + getsDomicilio();
		salida += "\nTelefono del proveedor: " + getsTelefono()+"\n";
		return salida;
	}

}
