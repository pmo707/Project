package ua.nure.pihnastyi.service;

import ua.nure.pihnastyi.db.DBManager;
import ua.nure.pihnastyi.db.RoleDAO;
import ua.nure.pihnastyi.db.StatusDAO;
import ua.nure.pihnastyi.db.entity.Role;
import ua.nure.pihnastyi.db.entity.Status;

import java.sql.Connection;

public class StatusService {
    private static StatusService instance;

    public static synchronized StatusService getInstance() {
        if (instance == null) {
            instance = new StatusService();
        }
        return instance;
    }

    private StatusService() {
        StatusDao = StatusDAO.getInstance();

    }

    //////////////////////////////////

    private StatusDAO StatusDao;


    public Status getStatusByName(String statusName) {
        Connection con = null;
        Status status = null;
        try {
            con = DBManager.getInstance().getConnection();

            status = StatusDao.findStatusByName(con,statusName);
        } finally {
            DBManager.close(con);
        }
        return status;
    }

}