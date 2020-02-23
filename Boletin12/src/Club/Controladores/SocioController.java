package Club.Controladores;

import Club.Modelos.Socio;

public class SocioController implements ICrud<Socio> {
    private byte contadorSocios;
    private Socio[] vSocios;
    private final byte MAXSOCIOS = 20;

    public SocioController(){
        vSocios = new Socio[MAXSOCIOS];
        contadorSocios = 0;
    }

    @Override
    public Socio[] getaVector() {
        return vSocios;
    }

    @Override
    public byte getbContadorArray() {
        return contadorSocios;
    }

    @Override
    public int search(Socio oObject) {
        int iPosicion = -1;
        int iContador = 0;

        while(iPosicion == -1 && iContador < contadorSocios){
            if (oObject.equals(vSocios[iContador]))
                iPosicion = iContador;
            iContador++;
        }
        return iPosicion;
    }

    @Override
    public String printAll() {
        String salida = "";

        if (contadorSocios == 0)
            salida = "No hay socios registrados.";
        else {
            for (int i = 0; i < contadorSocios; i++){
                salida += vSocios[i]+"\n";
            }
        }
        return salida;
    }

    @Override
    public boolean add(Socio oObject) {
        boolean bExito = false;
        if (oObject.getId() != 0 && contadorSocios < MAXSOCIOS && search(oObject) == -1){
            vSocios[contadorSocios] = oObject;
            contadorSocios++;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean remove(Socio oObject) {
        boolean bExito = false;
        int iPosicion = search(oObject);
        if (iPosicion != -1){
            for (int i = iPosicion; i < contadorSocios; i++)
                vSocios[i] = vSocios[i+1];
            vSocios[contadorSocios] = null;
            contadorSocios--;
            bExito = true;
        }
        return bExito;
    }

    @Override
    public boolean update(Socio oObjeto, int iPosicion) {
        boolean bExito = false;
        if (iPosicion != -1) {
            vSocios[iPosicion] = oObjeto;
            bExito = true;
        }
        return bExito;
    }
}