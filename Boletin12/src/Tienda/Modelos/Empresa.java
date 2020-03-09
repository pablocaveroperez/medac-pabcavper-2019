package Tienda.Modelos;

public class Empresa extends Proveedor implements IEmpresa {
	private String sDenominacionOficial;
	private byte bTipoEmpresa;
	
	public Empresa(byte idProveedor) {
		super(idProveedor);
	}
	
	public Empresa() {
		super();
	}
	
	public Empresa(byte idProveedor, String sNombre, String sDomicilio, String sTelefono, String sDenominacion, byte bTipoEmpresa) {
		super(idProveedor, sNombre, sDomicilio, sTelefono);
		setsDenominacionOficial(sDenominacion);
		setbTipoEmpresa(bTipoEmpresa);
	}	
	
	@Override
	public String getsDenominacionOficial() {
		return sDenominacionOficial;
	}
	
	@Override
	public boolean setsDenominacionOficial(String sDenominacionOficial) {
		boolean bExito = false;
		if (sDenominacionOficial.length() > 0 && sDenominacionOficial.length() < 255) {
			this.sDenominacionOficial = sDenominacionOficial;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public byte getbTipoEmpresa() {
		return bTipoEmpresa;
	}
	
	@Override
	public boolean setbTipoEmpresa(byte bTipoEmpresa) {
		boolean bExito = false;
		if (bTipoEmpresa >= 1 && bTipoEmpresa <= 3) {
			this.bTipoEmpresa = bTipoEmpresa;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String tipoToString() {
		String salida = "";
		
		if (getbTipoEmpresa() == SL)
			salida += "Sociedad de Responsabilidad Limitada(SL)";
		else if (getbTipoEmpresa() == SLNE)
			salida += "Sociedad Limitada Nueva Empresa(SLNE)";
		else if (getbTipoEmpresa() == SA)
			salida += "Sociedad Anonima(SA)";
		else
			salida += "Tipo de Empresa incorrecto";
		return salida;
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
		salida += "\nDenominacion Oficial: " + getsDenominacionOficial();
		salida += "\nTipo de Empresa: " + tipoToString() + "\n";
		return salida;
	}
	
	
}
