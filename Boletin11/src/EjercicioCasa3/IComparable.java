package EjercicioCasa3;

public interface IComparable {

    void introducirDatos(int numeroSocio, int telefono, String dni, String nombre, String apellidos, String email, String direccion);

    void modificarSocio(String datos);

    void imprimir();

    boolean equals(Socio oSocio);

    int getNumeroSocio();

    int getTelefono();

    void setTelefono(int telefono);

    String getDni();

    void setDni(String dni);

    String getNombre();

    void setNombre(String nombre);

    String getApellidos();

    void setApellidos(String apellidos);

    String getEmail();

    void setEmail(String email);

    String getDireccion();

    void setDireccion(String direccion);
}
