package controlador;

import modelo.Socio;

public class SocioController implements ICrud<Socio> {

	private Socio aSocios[];
	private byte bContadorSocios;
	private final int MAXSOCIOS = 100;
	
	public SocioController() {
		aSocios = new Socio[MAXSOCIOS];
		bContadorSocios = 0;
	}
	
	@Override
	public Socio[] getaVector() {
		return aSocios;
	}

	@Override
	public byte getbContadorArray() {
		return bContadorSocios;
	}

	@Override
	public boolean add(Socio oObject) {
		boolean bExito = false;
		if(oObject.getsDni() != null && bContadorSocios < MAXSOCIOS && search(oObject) == -1) {
			aSocios[bContadorSocios] = oObject;
			bContadorSocios++;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public boolean remove(Socio oObject) {
		boolean bExito = false;
		int iPosicion = search(oObject);
		if(iPosicion != -1) {
			for(int i=iPosicion+1; i<bContadorSocios; i++) {
				aSocios[i-1] = aSocios[i];	
			}
			aSocios[bContadorSocios] = null;
			bContadorSocios--;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public int search(Socio oObject) {
		int iPosicion = -1;
		int iContador = 0;
		while(iPosicion == -1 && iContador < bContadorSocios) {
			if(oObject.equals(aSocios[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}

}
