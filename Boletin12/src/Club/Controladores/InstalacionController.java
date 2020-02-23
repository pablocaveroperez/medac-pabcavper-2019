package Club.Controladores;

import Club.Modelos.Instalacion;

public class InstalacionController implements ICrud<Instalacion> {
    private Instalacion[] vInstalaciones;
    private final byte MAXINSTALACIONES = 50;
    private byte contadorInstalaciones;


    @Override
    public Instalacion[] getaVector() {
        return vInstalaciones;
    }

    @Override
    public byte getbContadorArray() {
        return contadorInstalaciones;
    }

    @Override
    public boolean add(Instalacion oObject) {
        boolean bExito = false;
        if (oObject.instalacionValida() && contadorInstalaciones < MAXINSTALACIONES && search(oObject) == -1){
            vInstalaciones[contadorInstalaciones] = oObject;
            contadorInstalaciones++;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean remove(Instalacion oObject) {
        boolean bExito = false;
        int iPosicion = search(oObject);
        if (iPosicion != -1){
            for (int i = iPosicion; i < contadorInstalaciones; i++)
                vInstalaciones[i] = vInstalaciones[i+1];
            vInstalaciones[contadorInstalaciones] = null;
            contadorInstalaciones--;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public int search(Instalacion oObject) {
        int iPosicion = -1;
        int iContador = 0;
        while (iPosicion == -1 && iContador < contadorInstalaciones){
            if (oObject.equals(vInstalaciones[iContador]))
                iPosicion = iContador;
            iContador++;
        }
        return iPosicion;
    }

    @Override
    public String printAll() {
        return null;
    }

    @Override
    public boolean update(Instalacion oObjeto, int iPosicion) {
        return false;
    }
}
