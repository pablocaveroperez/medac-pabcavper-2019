package Club.Controladores;

import Club.Modelos.Instalacion;

public class InstalacionController implements ICrud<Instalacion> {
    private Instalacion[] vInstalaciones;
    private final byte MAXINSTALACIONES = 50;
    private byte contadorInstalaciones;

    public InstalacionController() {
        vInstalaciones = new Instalacion[MAXINSTALACIONES];
        contadorInstalaciones = 0;
    }

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
        String salida = "";
        if (contadorInstalaciones == 0)
            salida += "No hay instalaciones registradas";
        else{
            for (int i = 0; i < contadorInstalaciones; i++) {
                salida += vInstalaciones[i]+"\n";
            }
        }
        return salida;
    }

    @Override
    public boolean update(Instalacion oObjeto, int iPosicion) {
        boolean bExito = false;
        if (iPosicion != -1) {
            vInstalaciones[iPosicion]= oObjeto;
            bExito = true;
        }
        return bExito;
    }
}
