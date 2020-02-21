package controlador;

import modelo.Instalacion;

public class InstalacionController implements ICrud<Instalacion>{
	
	private Instalacion aInstalaciones[];
	private byte bContadorInstalaciones;
	private final int MAXINSTALACIONES = 100;
	
	public InstalacionController() {
		aInstalaciones = new Instalacion[MAXINSTALACIONES];
		bContadorInstalaciones = 0;
	}

	
	@Override
	public Instalacion[] getaVector() {
		return aInstalaciones;
	}
	
	@Override
	public byte getbContadorArray() {
		return bContadorInstalaciones;
	}

	@Override
	public int search(Instalacion oInst) {
		int iPosicion = -1;
		int iContador = 0;
		while(iPosicion == -1 && iContador < bContadorInstalaciones) {
			if(oInst.equals(aInstalaciones[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}

	@Override
	public boolean add(Instalacion oInst) {
		boolean bExito = false;
		if(oInst.validarInstalacion() && bContadorInstalaciones < MAXINSTALACIONES && search(oInst) == -1) {
			aInstalaciones[bContadorInstalaciones] = oInst;
			bContadorInstalaciones++;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public boolean remove(Instalacion oObject) {
		boolean bExito = false;
		int iPosicion = search(oObject);
		if(iPosicion != -1) {
			for(int i=iPosicion+1; i<bContadorInstalaciones; i++) {
				aInstalaciones[i-1] = aInstalaciones[i];	
			}
			aInstalaciones[bContadorInstalaciones] = null;
			bContadorInstalaciones--;
			bExito = true;
		}
		return bExito;
	}
	
	
}
