package Club.Controladores;

import Club.Modelos.Reserva;

public class Terminal {
    private SocioController socioController;
    private ReservaController reservaController;
    private InstalacionController instalacionController;

    public Terminal() {
        socioController = new SocioController();
        instalacionController = new InstalacionController();
        reservaController = new ReservaController();
    }

    public SocioController getSocioController() {
        return socioController;
    }

    public InstalacionController getInstalacionController() {
        return instalacionController;
    }

    public ReservaController getReservaController() {
        return reservaController;
    }

    public boolean add(Reserva reserva) {
        boolean bExito = false;
        if (socioController.search(reserva.getSocio()) != -1 && instalacionController.search(reserva.getInstalacion()) != -1)
            bExito = reservaController.add(reserva);
        return bExito;
    }
}

