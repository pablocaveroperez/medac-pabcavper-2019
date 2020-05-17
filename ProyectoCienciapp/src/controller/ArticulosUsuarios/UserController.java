package controller.ArticulosUsuarios;

import controller.ConexionDB;
import model.ArticulosUsuarios.Category;
import model.ArticulosUsuarios.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> getTodasCategorias(){
        List<User> lUsers = new ArrayList<>();

        String sql = "SELECT username, password, email FROM user";
        Statement stm = null;

        try {
            stm = ConexionDB.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String sUserName = rs.getString(1);
                String sPassword = rs.getString(2);
                String sEmail = rs.getString(3);
                lUsers.add(new User(sUserName, sPassword, sEmail));
            }
            stm.close();
        } catch (SQLException exception) {
            lUsers = null;
        }
        return lUsers;
    }
}
