package EjercicioCasa3;

public class Socio implements IComparable {
    private int numeroSocio;
    private int telefono;
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String direccion;

    public Socio(){
        introducirDatos();
    }

    @Override
    public void introducirDatos(){
        setNumeroSocio((int) ValidaLibrary.valida("Introduce el numero de socio: ",0,10,1));
        setTelefono((int) ValidaLibrary.valida("Introduce el telefono del socio: ",100000000,999999999,1));
        setDni(ValidaLibrary.leer("Introduce el DNI del socio: "));
        setNombre(ValidaLibrary.leer("Introduce el nombre del socio: "));
        setApellidos(ValidaLibrary.leer("Introduce los apellidos del socio: "));
        setEmail(ValidaLibrary.leer("Introduce el email del socio: "));
        setDireccion(ValidaLibrary.leer("Introduce la direccion del socio: "));
    }

    @Override
    public void modificarSocio(String datos){

    }

    @Override
    public String imprimir(){
        String salida ="\n****************************************\n";
        salida += "El socio "+getNombre()+" "+getApellidos()+" tiene:\n";
        salida += "Numero de socio: "+getNumeroSocio()+".\n";
        salida += "Telefono: "+getTelefono()+".\n";
        salida += "DNI: "+getDni()+".\n";
        salida += "Email: "+getEmail()+".\n";
        salida += "Direccion: "+getDireccion()+".";
        salida += "\n****************************************\n";
        return salida;
    }

    @Override
    public boolean equals(Socio oSocio) {
        boolean bIgual = false;
        Socio otro = (Socio) oSocio;
        if(this != null && otro != null && this.getNumeroSocio() == (otro.getNumeroSocio())) {
            bIgual = true;
        }
        return bIgual;
    }

    @Override
    public int getNumeroSocio() {
        return numeroSocio;
    }

    private void setNumeroSocio(int numeroSocio) { // ESTE METODO ES PRIVADO POR QUE ES LA CLAVE PRIMARIA
        this.numeroSocio = numeroSocio;
    }

    @Override
    public int getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellidos() {
        return apellidos;
    }

    @Override
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
