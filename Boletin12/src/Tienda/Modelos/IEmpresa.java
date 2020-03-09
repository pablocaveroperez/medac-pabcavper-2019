package Tienda.Modelos;

public interface IEmpresa {
	
	public final byte SL = 1;
	public final byte SLNE = 2;
	public final byte SA = 3;

	String getsDenominacionOficial();

	boolean setsDenominacionOficial(String sDenominacionOficial);

	byte getbTipoEmpresa();

	boolean setbTipoEmpresa(byte bTipoEmpresa);

	String tipoToString();

}