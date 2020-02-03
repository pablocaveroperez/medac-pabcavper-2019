package EjercicioCasa3;

public class Terminal {
    // Atributos
    private byte idTerminal;
    private RegistroSocios socControl;
    private RegistroArticulos artControl;
    private RegistroInstalacion insControl;



    // Constructores
    public Terminal(byte idTerminal, int numSocios, int numArticulos, int numInstalaciones) {
        socControl = new RegistroSocios(numSocios);
        artControl = new RegistroArticulos(numArticulos);
        insControl = new RegistroInstalacion(numInstalaciones);
        setIdTerminal(idTerminal);
    }

    // Métodos getters y setters
    public void setIdTerminal(byte idTerminal) {
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

}
