package ua.nure.pihnastyi.db;

import org.apache.log4j.Logger;
import ua.nure.pihnastyi.db.entity.Role;
import ua.nure.pihnastyi.db.entity.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public final class DBManager {


    private static final Logger LOG = Logger.getLogger(DBManager.class);

    // //////////////////////////////////////////////////////////
    // singleton
    // //////////////////////////////////////////////////////////

    private static DBManager instance;

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            // ST4DB - the name of data source
            ds = (DataSource) envContext.lookup("jdbc/task4db");
            LOG.trace("Data source ==> " + ds);
        } catch (NamingException ex) {
            LOG.error("ERR_CANNOT_OBTAIN_DATA_SOURCE" + ex);
            //throw new DBException(Messages.ERR_CANNOT_OBTAIN_DATA_SOURCE, ex);
        }
    }

    private DataSource ds;


    public Connection getConnection() {
        Connection con = null;
        try {
            con = ds.getConnection();
        } catch (SQLException ex) {
            //  LOG.error(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
            // throw new DBException(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
        }
        return con;
    }


    public static void close(AutoCloseable quality) {
        try {
            if (quality != null) {
                quality.close();
            }
        } catch (Exception e) {
            LOG.warn(e);
        }
    }


}