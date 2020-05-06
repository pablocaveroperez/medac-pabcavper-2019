package model;

public interface IUser {
    String getsUsername();

    String getsPassword();

    boolean setsPassword(String sPassword);

    String getsEmail();

    boolean setsEmail(String sEmail);

    boolean checkUser();

    boolean checkLogin(Object obj);

    // Generar SHA-512 a partir de una contraseña (String).
    String encryptSha512(String input);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    String toString();
}
