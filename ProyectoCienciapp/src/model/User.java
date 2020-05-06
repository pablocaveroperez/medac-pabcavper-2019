package model;

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
        if (sPassword != null && sPassword.length() > MINCHAR && sPassword.length() < MAXCHAR_PASSWORD) {
            this.sPassword = sPassword;
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
}
