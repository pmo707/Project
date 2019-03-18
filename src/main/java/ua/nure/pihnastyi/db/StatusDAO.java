package ua.nure.pihnastyi.db;

import ua.nure.pihnastyi.db.entity.Status;
import ua.nure.pihnastyi.db.util.DBConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusDAO {




    private static StatusDAO instance;

    public static synchronized StatusDAO getInstance() {
        if (instance == null) {
            instance = new StatusDAO();
        }
        return instance;
    }

    public StatusDAO() {
    }

    public Status findStatusById(Connection con, long statusId) {

        Status status = null;

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connection = con;
            pstmt = connection.prepareStatement(DBConstants.SQL_FIND_STATUS_BY_ID);
            pstmt.setLong(1, statusId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                status = extractStatus(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);

        }
        return status;
    }

    public Status findStatusByName(Connection con, String statusName) {

        Status status = null;

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connection = con;
            pstmt = connection.prepareStatement(DBConstants.SQL_FIND_STATUS_BY_NAME);
            pstmt.setString(1, statusName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                status = extractStatus(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            DBManager.close(rs);
            DBManager.close(pstmt);

        }
        return status;
    }


    public static Status extractStatus(ResultSet rs) throws SQLException {
        Status status = new Status();
        status.setId(rs.getInt(DBConstants.STATUS_ID));
        status.setName(rs.getString(DBConstants.STATUS_NAME));
        return status;
    }


}
