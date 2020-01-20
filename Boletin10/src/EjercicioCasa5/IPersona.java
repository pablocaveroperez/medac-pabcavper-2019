package EjercicioCasa5;

public interface IPersona {
    public final byte SOLTERO = 1;
    public final byte CASADO = 2;
    public final byte SEPARADO = 3;
    public final byte DIVORCIADO = 4;
    public final byte VIUDO = 5;

    public String getsNombre() ;

    public void setsNombre(String sNombre) ;

    public String getsApellido1() ;

    public void setsApellido1(String sApellido1) ;

    public String getsApellido2() ;

    public void setsApellido2(String sApellido2) ;

    public short getShEdad() ;

    public boolean setbEdad(short shEdad) ;

    public float getfEstatura() ;

    public boolean setfEstatura(float fEstatura) ;

    public float getfKilos();

    public boolean setfKilos(float fKilos);

    public byte getbEstado();

    public boolean setbEstado(byte bEstado);
}
