package ua.nure.pihnastyi.service;

import ua.nure.pihnastyi.db.CategoryDAO;
import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.RoleDAO;
import ua.nure.pihnastyi.db.entity.Category;
import ua.nure.pihnastyi.db.entity.Role;

import java.sql.Connection;

public class RoleService {

    private static RoleService instance;

    public static synchronized RoleService getInstance() {
        if (instance == null) {
            instance = new RoleService();
        }
        return instance;
    }

    private RoleService() {
        RoleDao = RoleDAO.getInstance();

    }

    //////////////////////////////////

    private RoleDAO RoleDao;


    public Role getCategoryByName(String roleName) {
        Connection con = null;
        Role role = null;
        try {
            con = DBManager.getInstance().getConnection();

            role = RoleDao.findRoleByName(con,roleName);
        } finally {
            DBManager.close(con);
        }
        return role;
    }

}