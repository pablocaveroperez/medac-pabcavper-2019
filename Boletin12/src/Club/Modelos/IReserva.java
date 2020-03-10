package Club.Modelos;

import java.util.Calendar;

public interface IReserva {
    Socio getSocio();

    Instalacion getInstalacion();

    Calendar getFecha();

    byte getHora();

    byte getMinutos();

    boolean reservaValida();
}
