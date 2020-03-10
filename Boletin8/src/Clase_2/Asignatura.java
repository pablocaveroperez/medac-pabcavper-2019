package Clase_2;

public class Asignatura {
    private String sNombre, sCurso;
    private int iCodigo;

    public Asignatura(){

    }

    public Asignatura(String sNombre, String sCurso, int iCodigo) {
        this.setsNombre(sNombre);
        this.setsCurso(sCurso);
        this.setiCodigo(iCodigo);
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsCurso() {
        return sCurso;
    }

    public void setsCurso(String sCurso) {
        this.sCurso = sCurso;
    }

    public int getiCodigo() {
        return iCodigo;
    }

    private void setiCodigo(int iCodigo) {
        this.iCodigo = iCodigo;
    }

    @Override
    public String toString() {
        String salida = "";
        salida += "La asignatura "+getsNombre()+" con el codigo "+getiCodigo()+" corresponde al curso "+getsCurso();

        return salida;
    }
}
