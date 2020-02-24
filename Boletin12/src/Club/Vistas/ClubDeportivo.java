package Club.Vistas;

import Club.Controladores.Terminal;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClubDeportivo {
    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        TerminalView terminalView = new TerminalView();

        terminalView.gestionOpcionMenuPrincipal(terminal);
    }
}
