package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.User;

public class UserController implements IUserController {

    // #########
    // # CRUDS #
    // #########
    @Override
    public int add(User oObject) {
        int iRes = 0;
        if (oObject.checkUser()) {
            String sql;
            if (oObject.getsEmail() != null) {
                sql = "INSERT INTO user VALUES (\"" + oObject.getsUsername() + "\",\"" + oObject.getsPassword() + "\",\"" +
                        oObject.getsEmail() + "\")";
            } else {
                sql = "INSERT INTO user VALUES (\"" + oObject.getsUsername() + "\",\"" + oObject.getsPassword() + "\",null)";
            }
            iRes = ConexionDB.executeUpdate(sql);
        }
        return iRes;
    }

    @Override
    public int remove(User oObject) {
        int iRes = 0;
        String sql = "DELETE FROM user WHERE username LIKE \"" + oObject.getsUsername() + "\"";
        iRes = ConexionDB.executeUpdate(sql);
        return iRes;
    }

    // ###########
    // # QUERIES #
    // ###########
    @Override
    public int existeUser(User oObject) {
        int iRes = 0;
        if (oObject.checkUser()) {
            String sql = "SELECT COUNT(*) FROM user WHERE username LIKE \"" + oObject.getsUsername() + "\"";
            iRes = ConexionDB.executeCount(sql);
        }
        return iRes;
    }

    @Override
    public int checkLogin(User oUsuario) {
        String sql = "SELECT COUNT(*) FROM user WHERE username LIKE \"" + oUsuario.getsUsername() + "\" AND password LIKE \"" + oUsuario.getsPassword() + "\"";
        return ConexionDB.executeCount(sql);
    }
}
