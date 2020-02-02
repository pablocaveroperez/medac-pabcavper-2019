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

    }

    public void introducirDatos(){

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
