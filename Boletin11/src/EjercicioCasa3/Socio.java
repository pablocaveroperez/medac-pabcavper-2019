package EjercicioCasa3;

public class Socio {
    private int numeroSocio;
    private int telefono;
    private String dni;
    private String nombre;
    private String apellidos;
    private String email;
    private String direccion;

    public Socio(){

    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    private void setNumeroSocio(int numeroSocio) { // ESTE METODO ES PRIVADO POR QUE ES LA CLAVE PRIMARIA
        this.numeroSocio = numeroSocio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
