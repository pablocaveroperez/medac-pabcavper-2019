package EjercicioCasa3;

public class Terminal {
    // Atributos
    private byte idTerminal;
    private RegistroSocios socControl;
    private RegistroArticulos artControl;
    private RegistroInstalacion insControl;
    private RegistroReserva resControl;
    private RegistroAlquiler alqControl;



    // Constructores
    public Terminal(byte idTerminal, int numSocios, int numArticulos, int numInstalaciones, int numReservas, int numAlquileres) {
        socControl = new RegistroSocios(numSocios);
        artControl = new RegistroArticulos(numArticulos);
        insControl = new RegistroInstalacion(numInstalaciones);
        resControl = new RegistroReserva(numReservas);
        alqControl = new RegistroAlquiler(numAlquileres);
        setIdTerminal(idTerminal);
    }

    // Métodos getters y setters
    private void setIdTerminal(byte idTerminal) {
        this.idTerminal = idTerminal;
    }

    public byte getIdTerminal() {
        return idTerminal;
    }

    // ##################
    // # SEARCH METHODS #
    // ##################
    public int searchPositionSocio(Socio oCli) {
        return socControl.searchPosition(oCli);
    }

    public Socio searchSocio(Socio oCli) {
        return socControl.searchObject(oCli);
    }

    public int searchPositionArticulo(Articulo oCli) {
        return artControl.searchPosition(oCli);
    }

    public Articulo searchArticulo(Articulo oCli) {
        return artControl.searchObject(oCli);
    }

    public int searchPositionInstalacion(Instalacion oCli) {
        return insControl.searchPosition(oCli);
    }

    public Instalacion searchInstalacion(Instalacion oCli) {
        return insControl.searchObject(oCli);
    }

    public int searchPositionReserva(Reserva oCli) {
        return resControl.searchPosition(oCli);
    }

    public Reserva searchReserva(Reserva oCli) {
        return resControl.searchObject(oCli);
    }

    // ###################
    // # CRUD OPERATIONS #
    // # Socio CLASS #
    // ###################
    // CREATE
    public boolean addSocio(Socio oCli) {
        return socControl.add(oCli);
    }

    // READ
    public Socio readSocio(Socio oCli) {
        return socControl.read(oCli);
    }

    // UPDATE
    public boolean updateSocio(Socio oCli) {
        return socControl.update(oCli);
    }

    // DELETE
    public boolean deleteSocio(Socio oCli) {
        return socControl.delete(oCli);
    }

    // PRINT ALL SOCIOS
    public String printSocio() {
        return socControl.printAll();
    }

    // ###################
    // # CRUD OPERATIONS #
    // # Articulo CLASS #
    // ###################
    // CREATE
    public boolean addArticulo(Articulo oCli) {
        return artControl.add(oCli);
    }

    // READ
    public Articulo readArticulo(Articulo oCli) {
        return artControl.read(oCli);
    }

    // UPDATE
    public boolean updateArticulo(Articulo oCli) {
        return artControl.update(oCli);
    }

    // DELETE
    public boolean deleteArticulo(Articulo oCli) {
        return artControl.delete(oCli);
    }

    // PRINT ALL SOCIOS
    public String printArticulo() {
        return artControl.printAll();
    }

    // ###################
    // # CRUD OPERATIONS #
    // # Instalacion CLASS #
    // ###################
    // CREATE
    public boolean addInstalacion(Instalacion oCli) {
        return insControl.add(oCli);
    }

    // READ
    public Instalacion readInstalacion(Instalacion oCli) {
        return insControl.read(oCli);
    }

    // UPDATE
    public boolean updateInstalacion(Instalacion oCli) {
        return insControl.update(oCli);
    }

    // DELETE
    public boolean deleteInstalacion(Instalacion oCli) {
        return insControl.delete(oCli);
    }

    // PRINT ALL SOCIOS
    public String printInstalacion() {
        return insControl.printAll();
    }

    // ###################
    // # CRUD OPERATIONS #
    // # Reserva CLASS #
    // ###################
    // CREATE
    public boolean addReserva(Reserva oCli) {
        return resControl.add(oCli);
    }

    // READ
    public Reserva readReserva(Reserva oCli) {
        return resControl.read(oCli);
    }

    // UPDATE
    public boolean updateReserva(Reserva oCli) {
        return resControl.update(oCli);
    }

    // DELETE
    public boolean deleteReserva(Reserva oCli) {
        return resControl.delete(oCli);
    }

    // PRINT ALL SOCIOS
    public String printReserva() {
        return resControl.printAll();
    }

}
