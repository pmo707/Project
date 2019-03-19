package ua.nure.pihnastyi.service;


import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.RoleDAO;
import ua.nure.pihnastyi.db.UserDAO;
import ua.nure.pihnastyi.db.entity.Role;
import ua.nure.pihnastyi.db.entity.User;

import java.sql.Connection;

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

    public boolean setUserRoleByLogin(String login, String roleName) {
        Connection con = null;
        UserDAO userDAO = new UserDAO();
        RoleDAO roleDAO = new RoleDAO();
        Role role = null;
        boolean hasBaned;
        try {
            con = DBManager.getInstance().getConnection();
            role = roleDAO.findRoleByName(con, roleName);
            int roleId = (int) role.getId();
            hasBaned = userDAO.editUserRoleByLogin(con, login, roleId);
        } finally {
            DBManager.close(con);
        }
        return hasBaned;
    }

    public User getUsersByLogin(String login) {

        Connection con = null;
        UserDAO userDAO = new UserDAO();
        try {
            con = DBManager.getInstance().getConnection();
            return userDAO.findUserByLogin(con, login);
        } finally {
            DBManager.close(con);
        }

    }

    public User getUsersByLoginAndPassword(String login, String password) {

        Connection con = null;
        UserDAO userDAO = new UserDAO();
        try {
            con = DBManager.getInstance().getConnection();
            return userDAO.findUserByLoginAndPassword(con, login, password);
        } finally {
            DBManager.close(con);
        }

    }


}
