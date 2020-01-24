package modelo;

public class Cliente extends Persona {
	private String sTarjetaCredito;
	
	public Cliente(String sDni, String sNombre, String sApellidos, String sTarjetaCredito) {
		super(sDni, sNombre, sApellidos);
		setsTarjetaCredito(sTarjetaCredito);
	}
	
	public Cliente(String sDni) {
		super(sDni);
	}

	public String getsTarjetaCredito() {
		return sTarjetaCredito;
	}

	public void setsTarjetaCredito(String sTarjetaCredito) {
		this.sTarjetaCredito = sTarjetaCredito;
	}
	
	public String toString() {
		String sResultado = "";
		sResultado += super.toString() + "\n";
		sResultado += "Tarjeta de credito: " + this.sTarjetaCredito + "\n";
		return sResultado;
	}
	
	
}
