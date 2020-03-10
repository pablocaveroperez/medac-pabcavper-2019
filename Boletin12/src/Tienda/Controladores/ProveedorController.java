package Tienda.Controladores;

import Tienda.Modelos.Proveedor;

public class ProveedorController implements ICrud<Proveedor> {
	private Proveedor[] vProveedores;
	private byte contadorProveedores;
	private final byte MAXPROVEEDORES = 20;
	
	public ProveedorController() {
		vProveedores = new Proveedor[MAXPROVEEDORES];
		contadorProveedores = 0;
	}

	@Override
	public Proveedor[] getaVector() {
		// TODO Auto-generated method stub
		return vProveedores;
	}

	@Override
	public byte getbContadorArray() {
		// TODO Auto-generated method stub
		return contadorProveedores;
	}

	@Override
	public boolean add(Proveedor oObject) {
		// TODO Auto-generated method stub
		boolean bExito = false;
		if (oObject.getIdProveedor() != 0 && contadorProveedores < MAXPROVEEDORES && search(oObject) == -1) {
			vProveedores[contadorProveedores] = oObject;
			contadorProveedores++;
			bExito = true;
		}
		return bExito;		
	}

	@Override
	public boolean remove(Proveedor oObject) {
		// TODO Auto-generated method stub
		boolean bExito = false;
		int iPosicion = search(oObject);
		if (iPosicion != -1) {
			for (int i = iPosicion; i < contadorProveedores; i++)
				vProveedores[i] = vProveedores[i+1];
			vProveedores[contadorProveedores] = null;
			contadorProveedores--;
			bExito = true;
		}
		return bExito;
	}

	@Override
	public int search(Proveedor oObject) {
		// TODO Auto-generated method stub
		int iContador = 0;
		int iPosicion = -1;
		while (iPosicion == -1 && iContador < contadorProveedores) {
			if (oObject.equals(vProveedores[iContador]))
				iPosicion = iContador;
			iContador++;
		}
		return iPosicion;
	}
	
	@Override
	public Proveedor searchObject(byte idProveedor) {
		int iContador = 0;
		int iPosicion = -1;
		Proveedor proveedor;
		while (iPosicion == -1 && iContador < contadorProveedores) {
			if (idProveedor == vProveedores[iContador].getIdProveedor()) {
				iPosicion = iContador;
			}
			iContador++;
		}
		if (iPosicion == -1)
			proveedor = null;
		else
			proveedor = vProveedores[iPosicion];
		return proveedor;
	}

	@Override
	public String printAll() {
		// TODO Auto-generated method stub
		String salida = "";
		
		if (contadorProveedores == 0)
			salida = "No hay proveedores registrados.";
		else {
			for (int i = 0; i < contadorProveedores; i++)
				salida += vProveedores[i] + "\n";
		}
		return salida;
	}

	@Override
	public boolean update(Proveedor oObjeto, int iPosicion) {
		// TODO Auto-generated method stub
		boolean bExito = false;
		if (iPosicion != 1) {
			vProveedores[iPosicion] = oObjeto;
			bExito = true;
		}
		return bExito;
	}

}
