package modelo;

public interface IInstalacion {
	public final byte FUTBOL = 1;
	public final byte PADEL = 2;
	public final byte BALONCESTO = 3;
	
	public byte getbUbicacion();
	public boolean isbEstado();
	public void setbEstado(boolean bEstado);
	public byte getbTipo();
	public String cadenabTipo();
	public boolean validarInstalacion();
}
