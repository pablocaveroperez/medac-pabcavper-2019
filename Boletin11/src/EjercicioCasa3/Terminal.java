package EjercicioCasa3;

public class Terminal {
    // Atributos
    private byte idTerminal;
    private RegistroSocios socControl;



    // Constructores
    public Terminal(byte idTerminal, int numSocios) {
        socControl = new RegistroSocios(numSocios);
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
    public int searchPositionCliente(Socio oCli) {
        return socControl.searchPosition(oCli);
    }

    public Socio searchCliente(Socio oCli) {
        return socControl.searchObject(oCli);
    }

    // ###################
    // # CRUD OPERATIONS #
    // # Cliente CLASS #
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
    // # Articulo CLASS  #
    // ###################
    // CREATE
    public boolean addArticulo(Articulo oArt) {
        return artControl.add(oArt);
    }

    // READ
    public Articulo readArticulo(Articulo oArt) {
        return artControl.read(oArt);
    }

    // UPDATE
    public boolean updateArticulo(Articulo oArt) {
        return artControl.update(oArt);
    }

    // DELETE
    public boolean deleteArticulo(Articulo oArt) {
        return artControl.delete(oArt);
    }

    // PRINT ALL ARTICULOS
    public String printArticulos() {
        return artControl.printAll();
    }
}
