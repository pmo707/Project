package ua.nure.pihnastyi.db;

import ua.nure.pihnastyi.db.entity.Role;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.db.exeption.DBException;
import ua.nure.pihnastyi.db.util.DBConstants;

import java.sql.*;


public class UserDAO {

    public static final String SQL_FIND_ALL_USERS = "SELECT * FROM user u" +
            " INNER JOIN roles r ON u.role_id = r.id";

    public static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD =
            SQL_FIND_ALL_USERS + " WHERE u.login=? && u.password=?";

    public static final String SQL_FIND_USER_BY_LOGIN =
            SQL_FIND_ALL_USERS + " WHERE u.login=?";
    private static UserDAO instance;

    public static synchronized UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public UserDAO() {
    }


    public User findUserByLoginAndPassword(Connection connection, String login, String password) {
        User user = null;
        Connection con = connection;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN_AND_PASSWORD);
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
        }

        return user;
    }

    public User findUserByLogin(Connection connection, String login) {
        User user = null;
        Connection con = connection;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            pstmt.setString(1, login);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
        }

        return user;
    }

    public boolean editUserRoleByLogin(Connection con, String login, int role) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        int k = 1;
        connection = con;
        try {
            pstmt = connection.prepareStatement(DBConstants.SQL_EDIT_USER_ROLE,
                    Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(k++, role);
            pstmt.setString(k++, login);

            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);
        }
        return count > 0;
    }

    private static User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(DBConstants.USER_ID));
        user.setLogin(rs.getString(DBConstants.USER_LOGIN));

        user.setRole(rs.getString(DBConstants.ROLE));
        return user;
    }


}
