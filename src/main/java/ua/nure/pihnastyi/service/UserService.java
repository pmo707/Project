package ua.nure.pihnastyi.service;


import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.UserDAO;
import ua.nure.pihnastyi.db.entity.User;
import ua.nure.pihnastyi.db.exeption.DBException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private static UserService instance;

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
        userDao = UserDAO.getInstance();

    }

    //////////////////////////////////

    private UserDAO userDao;


    public User getUsersByLoginAndPassword(String login, String password) {

        Connection con = null;
        UserDAO userDAO = new UserDAO();
        try {
            con = DBManager.getInstance().getConnection();
            return userDAO.findUser(con, login, password);
        } catch (SQLException | DBException e) {
            e.printStackTrace();
        }
        return null;
    }


}
