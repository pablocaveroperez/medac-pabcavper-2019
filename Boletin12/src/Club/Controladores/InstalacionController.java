package Club.Controladores;

import Club.Modelos.Instalacion;

public class InstalacionController implements ICrud<Instalacion> {
    private Instalacion[] vInstalaciones;
    private final byte MAXINSTALACIONES = 50;
    private byte contadorInstalaciones;


    @Override
    public Instalacion[] getaVector() {
        return new Instalacion[0];
    }

    @Override
    public byte getbContadorArray() {
        return 0;
    }

    @Override
    public boolean add(Instalacion oObject) {
        return false;
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
