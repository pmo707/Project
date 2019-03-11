package ua.nure.pihnastyi.service;


import ua.nure.pihnastyi.db.CategoryDAO;
import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.RoleDAO;
import ua.nure.pihnastyi.db.UserDAO;
import ua.nure.pihnastyi.db.entity.Category;
import ua.nure.pihnastyi.db.entity.Goods;
import ua.nure.pihnastyi.db.entity.Role;
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

    public void setUserRoleByLogin(String login, String roleName) {
        Connection con = null;
        UserDAO userDAO = new UserDAO();
        RoleDAO roleDAO = new RoleDAO();
        Role role = null;
        try {
            con = DBManager.getInstance().getConnection();
            role = roleDAO.findRoleByName(con, roleName);
            int roleId = (int) role.getId();
            userDAO.editUserRoleByLogin(con, login, roleId);
        } finally {
            DBManager.close(con);
        }

    }

    public User getUsersByLoginAndPassword(String login, String password) {

        Connection con = null;
        UserDAO userDAO = new UserDAO();
        try {
            con = DBManager.getInstance().getConnection();
            return userDAO.findUser(con, login, password);
        } finally {
            DBManager.close(con);
        }

    }


}
