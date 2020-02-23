package Club.Modelos;

public interface IInstalacion {
    final byte BALONCESTO = 1;
    final byte FUTBOL = 2;
    final byte PADEL = 3;

    byte getUbicacion();

    byte getTipo();

    boolean isbEstado();

    void setbEstado(boolean bEstado);

    String tipoString();

    boolean instalacionValida();
}
