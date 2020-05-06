package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class User implements LimitsDB {
    private String sUsername;
    private String sPassword;
    private String sEmail;

    public User(String sUsername, String sPassword, String sEmail) {
        setsUsername(sUsername);
        setsPassword(sPassword);
        setsEmail(sEmail);
    }

    public String getsUsername() {
        return sUsername;
    }

    private boolean setsUsername(String sUsername) {
        boolean bExito = false;
        if (sUsername != null && sUsername.length() < MAXCHAR_50 && sUsername.length() > MINCHAR) {
            this.sUsername = sUsername;
            bExito = true;
        }
        return bExito;
    }

    public String getsPassword() {
        return sPassword;
    }

    public boolean setsPassword(String sPassword) {
        boolean bExito = false;
        if (sPassword != null && sPassword.length() > MINCHAR_PASSWORD && sPassword.length() < MAXCHAR_PASSWORD) {
            this.sPassword = encryptSha512(sPassword);
            bExito = true;
        }
        return bExito;
    }

    public String getsEmail() {
        return sEmail;
    }

    public boolean setsEmail(String sEmail) {
        boolean bExito = false;
        if (sEmail != null && sEmail.length() > MINCHAR && sEmail.length() < MAXCHAR_500) {
            this.sEmail = sEmail;
            bExito = true;
        }
        return bExito;
    }

    public boolean checkUser() {
        boolean bExito = false;
        if (sUsername != null && sPassword != null && sEmail != null)
            bExito = true;
        return bExito;
    }

    public boolean checkLogin(Object obj) {
        boolean bExito = false;
        User other = (User) obj;
        if(checkUser() && other.checkUser() && this.sUsername.equals(other.sUsername) && this.sPassword.equals(other.sPassword)) {
            bExito = true;
        }
        return bExito;
    }

    // Generar SHA-512 a partir de una contraseña (String).
    public String encryptSha512(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getsUsername().equals(user.getsUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getsUsername());
    }

    public String toString() {
        String salida = "";
        salida += "\n**********************";
        salida += "\nNombre de usuario: " + getsUsername();
        salida += "\nEmail: " + getsEmail();
        salida += "\n**********************";
        return salida;
    }
}
