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
            String sql = "INSERT INTO user VALUES (\"" + oObject.getsUsername() + "\",\"" + oObject.getsPassword() + "\",\"" +
                    oObject.getsEmail() + "\n)";
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
}
