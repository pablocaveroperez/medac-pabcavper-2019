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
        return false;
    }

    @Override
    public int search(Instalacion oObject) {
        return 0;
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
