package EjercicioCasa3;

public interface IComparable {

    public void introducirDatos();

    void modificarSocio(String datos);

    String imprimir();

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
